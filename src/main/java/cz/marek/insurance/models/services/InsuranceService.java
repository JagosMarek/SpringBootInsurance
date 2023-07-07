package cz.marek.insurance.models.services;

import cz.marek.insurance.models.dto.InsuranceDTO;

import java.util.List;

public interface InsuranceService {

    void create(InsuranceDTO insuranceDTO);

    List<InsuranceDTO> getAll();

    List<InsuranceDTO> getByInsuredId(long insuredId);

    List<InsuranceDTO> getByInsuranceListId(long insuranceListId);

    InsuranceDTO getById(long insuranceId);

    void edit(InsuranceDTO insuranceDTO);

    void remove(long insuranceId);
}
