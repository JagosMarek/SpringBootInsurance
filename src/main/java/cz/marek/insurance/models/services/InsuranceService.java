package cz.marek.insurance.models.services;

import cz.marek.insurance.models.dto.InsuranceDTO;

import java.util.List;

public interface InsuranceService {

    void create(InsuranceDTO insuranceDTO);

    public List<InsuranceDTO> getAll();

    public List<InsuranceDTO> getByInsuredId(long insuredId);

    InsuranceDTO getById(long insuranceId);

    void edit(InsuranceDTO insuranceDTO);

    void remove(long insuranceId);
}
