package cz.marek.insurance.data.entities;

import jakarta.persistence.*;

import java.time.LocalDate;

@Entity
public class InsuranceEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long insuranceId;
    @Column(nullable = false)
    private long insuredId;
    @Column(nullable = false)
    private long insuranceListId;
    @Column(nullable = false)
    private String insuranceLimit;
    @Column(nullable = false)
    private LocalDate beginning;
    @Column(nullable = false)
    private LocalDate end;
    @Column(nullable = false)
    private String subjectOfInsurance;

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
