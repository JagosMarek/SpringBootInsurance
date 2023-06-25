package cz.marek.insurance.controllers;


import cz.marek.insurance.models.dto.InsuredDTO;
import cz.marek.insurance.models.dto.mappers.InsuredMapper;
import cz.marek.insurance.models.exceptions.InsuredNotFoundException;
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
@RequestMapping("/insured")
public class InsuredController {

    @Autowired
    private InsuredService insuredService;

    @Autowired
    private InsuredMapper insuredMapper;

    @GetMapping
    public String renderIndex(Model model) {
        List<InsuredDTO> insuredDTO = insuredService.getAll();
        model.addAttribute("insured", insuredDTO);
        return "pages/insured/index";
    }

    @GetMapping("create")
    public String renderCreateForm(@ModelAttribute InsuredDTO insuredDTO) {
        return "pages/insured/create";
    }

    @GetMapping("{insuredId}")
    public String renderDetail(@PathVariable long insuredId, Model model){
        InsuredDTO insuredDTO = insuredService.getById(insuredId);
        model.addAttribute("insured", insuredDTO);

        return "pages/insured/detail";
    }

    @GetMapping("edit/{insuredId}")
    public String renderEditForm(@PathVariable long insuredId, InsuredDTO insuredDTO){
        InsuredDTO fetchedInsured = insuredService.getById(insuredId);
        insuredMapper.updateInsuredDTO(fetchedInsured, insuredDTO);

        return "pages/insured/edit";
    }

    @GetMapping("delete/{insuredId}")
    public String deleteInsured(@PathVariable long insuredId, RedirectAttributes redirectAttributes){

        insuredService.remove(insuredId);
        redirectAttributes.addFlashAttribute("success", "Osoba smazána.");

        return "redirect:/insured";
    }

    @PostMapping("edit/{insuredId}")
    public String editInsured(@PathVariable long insuredId, @Valid InsuredDTO insuredDTO, BindingResult result, RedirectAttributes redirectAttributes){
        if(result.hasErrors()){
            return renderEditForm(insuredId, insuredDTO);
        }
        insuredDTO.setInsuredId(insuredId);
        insuredService.edit(insuredDTO);
        redirectAttributes.addFlashAttribute("success", "Osoba upravena.");

        return "redirect:/insured";
    }

    @PostMapping("create")
    public String createInsured(@Valid @ModelAttribute InsuredDTO insuredDTO, BindingResult result, RedirectAttributes redirectAttributes) {
        if(result.hasErrors())
            return renderCreateForm(insuredDTO);

        insuredService.create(insuredDTO);
        redirectAttributes.addFlashAttribute("success", "Osoba založena.");

        return "redirect:/insured";
    }

    @ExceptionHandler({InsuredNotFoundException.class})
    public String handlerInsuredNotFoundException(RedirectAttributes redirectAttributes){
        redirectAttributes.addFlashAttribute("error", "Osoba nenalezene.");
        return "redirect:/insured";
    }
}
