package cz.marek.insurance.data.entities;

import jakarta.persistence.*;

import java.time.LocalDate;

@Entity
public class InsuranceEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long insuranceId;

    @ManyToOne
    @JoinColumn(name = "insuredId", nullable = false)
    private InsuredEntity insured;

    @ManyToOne
    @JoinColumn(name = "insuranceListId", nullable = false)
    private InsuranceListEntity insuranceList;

    @Column(nullable = false)
    private String insuranceLimit;

    @Column(nullable = false)
    private LocalDate beginning;

    @Column(name = "\"end\"", nullable = false) // because of postgres
    private LocalDate end;

    @Column(nullable = false)
    private String subjectOfInsurance;

    public long getInsuranceId() {
        return insuranceId;
    }

    public void setInsuranceId(long insuranceId) {
        this.insuranceId = insuranceId;
    }

    public InsuredEntity getInsured() {
        return insured;
    }

    public void setInsured(InsuredEntity insured) {
        this.insured = insured;
    }

    public InsuranceListEntity getInsuranceList() {
        return insuranceList;
    }

    public void setInsuranceList(InsuranceListEntity insuranceList) {
        this.insuranceList = insuranceList;
    }

    public String getInsuranceLimit() {
        return insuranceLimit;
    }

    public void setInsuranceLimit(String insuranceLimit) {
        this.insuranceLimit = insuranceLimit;
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
