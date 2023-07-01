package cz.marek.insurance.models.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

public class InsuranceListDTO {

    private long insuranceListId;
    @NotBlank(message = "Vyplňte název")
    @NotNull(message = "Vyplňte název")
    @Size(max = 50, message = "Název je příliš dlouhý")
    private String insuranceName;
    @NotBlank(message = "Vyplňte popis")
    @NotNull(message = "Vyplňte popis")
    private String insuranceDescription;

    @NotBlank(message = "Vyplňte pojišťovnu")
    @NotNull(message = "Vyplňte pojišťovnu")
    private String insuranceCompany;

    //Getters and Setters

    public long getInsuranceListId() {
        return insuranceListId;
    }

    public void setInsuranceListId(long insuranceListId) {
        this.insuranceListId = insuranceListId;
    }

    public String getInsuranceName() {
        return insuranceName;
    }

    public void setInsuranceName(String insuranceName) {
        this.insuranceName = insuranceName;
    }

    public String getInsuranceDescription() {
        return insuranceDescription;
    }

    public void setInsuranceDescription(String insuranceDescription) {
        this.insuranceDescription = insuranceDescription;
    }

    public String getInsuranceCompany() {
        return insuranceCompany;
    }

    public void setInsuranceCompany(String insuranceCompany) {
        this.insuranceCompany = insuranceCompany;
    }
}
