package cz.marek.insurance.models.dto;

import jakarta.validation.constraints.*;

import java.time.LocalDate;

public class InsuranceDTO {

    private long insuranceId;
    private long insuredId;
    @NotNull(message = "Vyberte pojištění ze seznamu")
    private long insuranceListId;
    private String contractNumber;
    @NotBlank(message = "Vyplňte limit")
    @NotNull(message = "Vyplňte limit")
    @Pattern(regexp = "\\d+", message = "Limit musí být kladné číslo")
    private String limit;
    @NotNull(message = "Vyplňte datum")
    @FutureOrPresent(message = "Počáteční datum musí být dnešní nebo budoucí datum")
    private LocalDate beginning;
    @NotNull(message = "Vyplňte datum")
    @FutureOrPresent(message = "Datum ukončení musí být dnešní nebo budoucí datum")
    private LocalDate end;
    @NotBlank(message = "Vyplňte předmět pojištění")
    @NotNull(message = "Vyplňte předmět pojištění")
    private String subjectOfInsurance;

    @AssertTrue
    public boolean isBeginningBeforeEnd() {
        if (beginning == null || end == null) {
            return true;
        }
        return beginning.isBefore(end) || beginning.isEqual(end);
    }

    public long getInsuranceId() {
        return insuranceId;
    }

    public void setInsuranceId(long insuranceId) {
        this.insuranceId = insuranceId;
    }

    public long getInsuredId() {
        return insuredId;
    }

    public void setInsuredId(long insuredId) {
        this.insuredId = insuredId;
    }

    public long getInsuranceListId() {
        return insuranceListId;
    }

    public void setInsuranceListId(long insuranceListId) {
        this.insuranceListId = insuranceListId;
    }

    public String getContractNumber() {
        return contractNumber;
    }

    public void setContractNumber(String contractNumber) {
        this.contractNumber = contractNumber;
    }

    public String getLimit() {
        return limit;
    }

    public void setLimit(String limit) {
        this.limit = limit;
    }

    public LocalDate getBeginning() {
        return beginning;
    }

    public void setBeginning(LocalDate beginning) {
        this.beginning = beginning;
    }

    public LocalDate getEnd() {
        return end;
    }

    public void setEnd(LocalDate end) {
        this.end = end;
    }

    public String getSubjectOfInsurance() {
        return subjectOfInsurance;
    }

    public void setSubjectOfInsurance(String subjectOfInsurance) {
        this.subjectOfInsurance = subjectOfInsurance;
    }
}
