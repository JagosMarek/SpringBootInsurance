package cz.marek.insurance.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/insurance")
public class InsuranceController {

    @GetMapping
    public String renderIndex(){
        return "pages/insurance/index";
    }

}
