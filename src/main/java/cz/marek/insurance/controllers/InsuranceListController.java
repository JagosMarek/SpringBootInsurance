package cz.marek.insurance.controllers;

import cz.marek.insurance.models.dto.InsuranceListDTO;
import jakarta.validation.Valid;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/insurance-list")
public class InsuranceListController {

    @GetMapping
    public String renderIndex(){
        return "pages/insurance-list/index";
    }

    @GetMapping("create")
    public String renderCreateForm(@ModelAttribute InsuranceListDTO insuranceListDTO) {
        return "pages/insurance-list/create";
    }

    @PostMapping("create")
    public String createInsuranceList(@Valid @ModelAttribute InsuranceListDTO insuranceListDTO, BindingResult result){
        if(result.hasErrors())
            return renderCreateForm(insuranceListDTO);

        return "redirect:/insurance-list";
    }
}
