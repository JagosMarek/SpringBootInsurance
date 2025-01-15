package cz.marek.insurance.data.entities;

import jakarta.persistence.*;

import java.util.List;

@Entity
public class InsuranceListEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long insuranceListId;

    @Column(nullable = false)
    private String insuranceName;

    @Column(nullable = false)
    private String insuranceDescription;

    @Column(nullable = false)
    private String insuranceCompany;

    @OneToMany(mappedBy = "insuranceList", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<InsuranceEntity> insurances;

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
