package cz.marek.insurance.controllers;


import cz.marek.insurance.models.dto.InsuredDTO;
import jakarta.validation.Valid;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/insured")
public class InsuredController {

    @GetMapping
    public String renderIndex() {
        return "pages/insured/index";
    }

    @GetMapping("create")
    public String renderCreateForm(@ModelAttribute InsuredDTO insuredDTO) {
        return "pages/insured/create";
    }

    @PostMapping("create")
    public String createInsured(@Valid @ModelAttribute InsuredDTO insuredDTO, BindingResult result) {
        if(result.hasErrors())
            return renderCreateForm(insuredDTO);

        System.out.println(insuredDTO.getFirstName() + " - " + insuredDTO.getLastName());

        return "redirect:/insured";
    }
}
