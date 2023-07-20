package cz.marek.insurance.controllers;

import cz.marek.insurance.models.dto.InsuranceDTO;
import cz.marek.insurance.models.dto.InsuranceListDTO;
import cz.marek.insurance.models.dto.InsuredDTO;
import cz.marek.insurance.models.dto.mappers.InsuranceMapper;
import cz.marek.insurance.models.exceptions.InsuranceNotFoundException;
import cz.marek.insurance.models.services.InsuranceListService;
import cz.marek.insurance.models.services.InsuranceService;
import cz.marek.insurance.models.services.InsuredService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.annotation.Secured;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;

@Controller
@RequestMapping("/insurance")
public class InsuranceController {

    @Autowired
    private InsuranceListService insuranceListService;

    @Autowired
    private InsuredService insuredService;

    @Autowired
    private InsuranceService insuranceService;

    @Autowired
    private InsuranceMapper insuranceMapper;

    @Secured({"ROLE_ADMIN", "ROLE_USER"})
    @GetMapping
    public String renderIndex(Model model){
        List<InsuranceDTO> insuranceDTOS = insuranceService.getAll();
        model.addAttribute("insurance", insuranceDTOS);

        return "pages/insurance/index";
    }

    @GetMapping("deleteform/{insuranceId}")
    public String renderDeleteForm(@PathVariable long insuranceId, Model model){
        InsuranceDTO insuranceDTO = insuranceService.getById(insuranceId);
        model.addAttribute("insurance", insuranceDTO);

        return "pages/insurance/deleteform";
    }

    @GetMapping("{insuranceId}")
    public String renderDetail(@PathVariable long insuranceId, Model model){
        InsuranceDTO insuranceDTO = insuranceService.getById(insuranceId);
        InsuredDTO insuredDTO = insuredService.getById(insuranceDTO.getInsuredId());
        InsuranceListDTO insuranceListDTO = insuranceListService.getById(insuranceDTO.getInsuranceListId());

        model.addAttribute("insurance", insuranceDTO);
        model.addAttribute("insured", insuredDTO);
        model.addAttribute("insuranceList", insuranceListDTO);
        return "pages/insurance/detail";
    }

    @GetMapping("/create/{insuredId}")
    public String renderCreatorForm(@PathVariable long insuredId, @ModelAttribute InsuranceDTO insuranceDTO, Model model) {
        List<InsuranceListDTO> insuranceLists = insuranceListService.getAll();
        model.addAttribute("insuredId", insuredId);
        model.addAttribute("insuranceLists", insuranceLists);
        return "pages/insurance/create";
    }

    @GetMapping("edit/{insuranceId}")
    public String renderEditForm(@PathVariable long insuranceId, InsuranceDTO insuranceDTO, Model model){
        InsuranceDTO fetchedInsurance = insuranceService.getById(insuranceId);
        Long insuredId = fetchedInsurance.getInsuredId();
        List<InsuranceListDTO> insuranceLists = insuranceListService.getAll();
        insuranceMapper.updateInsuranceDTO(fetchedInsurance, insuranceDTO);
        model.addAttribute("insuredId", insuredId);
        model.addAttribute("insuranceLists", insuranceLists);

        return "pages/insurance/edit";
    }

    @GetMapping("delete/{insuranceId}")
    public String deleteInsurance(@PathVariable long insuranceId, RedirectAttributes redirectAttributes){
        insuranceService.remove(insuranceId);
        redirectAttributes.addFlashAttribute("success", "Pojištění smazáno");

        return "redirect:/insurance";
    }

    @PostMapping("/create/{insuredId}")
    public String createInsurance(@PathVariable long insuredId, @Valid InsuranceDTO insuranceDTO, BindingResult result, Model model, RedirectAttributes redirectAttributes){
        if(result.hasErrors()) {
            return renderCreatorForm(insuredId, insuranceDTO, model);
        }
        insuranceService.create(insuranceDTO);
        redirectAttributes.addFlashAttribute("success", "Pojištění přidáno");
        return "redirect:/insured/" + insuredId;
    }

    @PostMapping("edit/{insuranceId}")
    public String editInsurance(@PathVariable long insuranceId, @Valid InsuranceDTO insuranceDTO, BindingResult result, Model model, RedirectAttributes redirectAttributes){
        if (result.hasErrors()) {
            return renderEditForm(insuranceId, insuranceDTO, model);
        }

        InsuranceDTO fetchedInsurance = insuranceService.getById(insuranceId);
        Long insuredId = fetchedInsurance.getInsuredId();

        insuranceDTO.setInsuranceId(insuranceId);
        insuranceService.edit(insuranceDTO);
        redirectAttributes.addFlashAttribute("success", "Pojištění upraveno");

        return "redirect:/insurance/" + insuranceId;
    }

    @ExceptionHandler({InsuranceNotFoundException.class})
    public String handlerInsuranceNotFoundException(RedirectAttributes redirectAttributes){
        redirectAttributes.addFlashAttribute("error", "Pojištění nenalezeno");
        return "redirect:/insurance/";
    }


}
