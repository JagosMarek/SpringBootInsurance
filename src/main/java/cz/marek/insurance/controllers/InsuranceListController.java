package cz.marek.insurance.controllers;

import cz.marek.insurance.models.dto.InsuranceDTO;
import cz.marek.insurance.models.dto.InsuranceListDTO;
import cz.marek.insurance.models.dto.InsuredDTO;
import cz.marek.insurance.models.dto.mappers.InsuranceListMapper;
import cz.marek.insurance.models.exceptions.InsuranceListNotFoundException;
import cz.marek.insurance.models.services.InsuranceListService;
import cz.marek.insurance.models.services.InsuranceService;
import cz.marek.insurance.models.services.InsuredService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;

@Controller
@RequestMapping("/insurance-list")
public class InsuranceListController {

    @Autowired
    private InsuranceListService insuranceListService;

    @Autowired
    private InsuranceService insuranceService;

    @Autowired
    private InsuranceListMapper insuranceListMapper;

    @GetMapping
    public String renderIndex(Model model){
        List<InsuranceListDTO> insuranceListDTO = insuranceListService.getAll();
        model.addAttribute("insuranceList", insuranceListDTO);

        return "pages/insurance-list/index";
    }

    @GetMapping("deleteform/{insuranceListId}")
    public String renderDeleteForm(@PathVariable long insuranceListId, Model model){
        InsuranceListDTO insuranceListDTO = insuranceListService.getById(insuranceListId);
        model.addAttribute("insuranceList", insuranceListDTO);

        return "pages/insurance-list/deleteform";
    }

    @GetMapping("create")
    public String renderCreateForm(@ModelAttribute InsuranceListDTO insuranceListDTO) {
        return "pages/insurance-list/create";
    }

    @GetMapping("{insuranceListId}")
    public String renderDetail(@PathVariable long insuranceListId, Model model){
        InsuranceListDTO insuranceListDTO = insuranceListService.getById(insuranceListId);
        List<InsuranceDTO> insuranceList = insuranceService.getByInsuranceListId(insuranceListId);

        model.addAttribute("insuredList", insuranceList);
        model.addAttribute("insuranceList", insuranceListDTO);

        return "pages/insurance-list/detail";
    }

    @GetMapping("edit/{insuranceListId}")
    public String renderEditForm(@PathVariable long insuranceListId, InsuranceListDTO insuranceListDTO){
        InsuranceListDTO fetchedInsuranceList = insuranceListService.getById(insuranceListId);
        insuranceListMapper.updateInsuranceListDTO(fetchedInsuranceList, insuranceListDTO);

        return "pages/insurance-list/edit";
    }

    @GetMapping("delete/{insuranceListId}")
    public String deleteInsuranceList(@PathVariable long insuranceListId, RedirectAttributes redirectAttributes){
        insuranceListService.remove(insuranceListId);

        redirectAttributes.addFlashAttribute("success", "Pojištění smazáno");
        return "redirect:/insurance-list";
    }

    @PostMapping("create")
    public String createInsuranceList(@Valid @ModelAttribute InsuranceListDTO insuranceListDTO, BindingResult result, RedirectAttributes redirectAttributes){
        if(result.hasErrors())
            return renderCreateForm(insuranceListDTO);

        insuranceListService.create(insuranceListDTO);
        redirectAttributes.addFlashAttribute("success", "Pojištění vytvořeno");

        return "redirect:/insurance-list";
    }

    @PostMapping("edit/{insuranceListId}")
    public String editInsuranceList(@PathVariable long insuranceListId, @Valid InsuranceListDTO insuranceListDTO, BindingResult result, RedirectAttributes redirectAttributes){
        if(result.hasErrors())
            return renderEditForm(insuranceListId, insuranceListDTO);

        insuranceListDTO.setInsuranceListId(insuranceListId);
        insuranceListService.edit(insuranceListDTO);
        redirectAttributes.addFlashAttribute("success", "Pojištění upraveno");

        return "redirect:/insurance-list";
    }

    @ExceptionHandler({InsuranceListNotFoundException.class})
    public String handleInsuranceListNotFoundException(RedirectAttributes redirectAttributes){
        redirectAttributes.addFlashAttribute("error", "Pojištění nenalezeno");
        return "redirect:/insurance-list";
    }
}
