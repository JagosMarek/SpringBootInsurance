package cz.marek.insurance.models.services;

import cz.marek.insurance.models.dto.InsuranceListDTO;

import java.util.List;

public interface InsuranceListService {

    void create(InsuranceListDTO insuranceListDTO);

    List<InsuranceListDTO> getAll();

    InsuranceListDTO getById(long insuranceListId);

    void edit(InsuranceListDTO insuranceListDTO);

    void remove(long insuranceListId);
}
