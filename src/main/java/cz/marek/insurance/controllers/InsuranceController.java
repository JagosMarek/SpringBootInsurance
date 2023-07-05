package cz.marek.insurance.controllers;

import cz.marek.insurance.models.dto.InsuranceDTO;
import cz.marek.insurance.models.dto.InsuranceListDTO;
import cz.marek.insurance.models.services.InsuranceListService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/insurance")
public class InsuranceController {

    @Autowired
    private InsuranceListService insuranceListService;

    @GetMapping
    public String renderIndex(){
        return "pages/insurance/index";
    }

    @GetMapping("/create/{insuredId}")
    public String renderCreatorForm(@PathVariable long insuredId, @ModelAttribute InsuranceDTO insuranceDTO, Model model) {
        List<InsuranceListDTO> insuranceLists = insuranceListService.getAll();
        model.addAttribute("insuredId", insuredId);
        model.addAttribute("insuranceLists", insuranceLists);
        return "pages/insurance/create";
    }

    @PostMapping("/create/{insuredId}")
    public String createInsurance(@PathVariable long insuredId, @Valid InsuranceDTO insuranceDTO, BindingResult result, Model model){
        if(result.hasErrors()) {
            return renderCreatorForm(insuredId, insuranceDTO, model);
        }

        // Vypsání atributů do konzole
        System.out.println("InsuranceId: " + insuranceDTO.getInsuranceId());
        System.out.println("InsuredId: " + insuranceDTO.getInsuredId());
        System.out.println("InsuranceListId: " + insuranceDTO.getInsuranceListId());
        System.out.println("ContractNumber: " + insuranceDTO.getContractNumber());
        System.out.println("Limit: " + insuranceDTO.getLimit());
        System.out.println("Beginning: " + insuranceDTO.getBeginning());
        System.out.println("End: " + insuranceDTO.getEnd());
        System.out.println("SubjectOfInsurance: " + insuranceDTO.getSubjectOfInsurance());

        // Návrat do detailu uživatele
        return "redirect:/insured/" + insuredId;
    }

}
