package cz.marek.insurance.models.services;

import cz.marek.insurance.data.entities.InsuranceListEntity;
import cz.marek.insurance.data.repositories.InsuranceListRepository;
import cz.marek.insurance.models.dto.InsuranceListDTO;
import cz.marek.insurance.models.dto.mappers.InsuranceListMapper;
import cz.marek.insurance.models.exceptions.InsuranceListNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.StreamSupport;

@Service
public class InsuranceListServiceImpl implements InsuranceListService {

    @Autowired
    private InsuranceListRepository insuranceListRepository;

    @Autowired
    private InsuranceListMapper insuranceListMapper;

    @Override
    public void create(InsuranceListDTO insuranceListDTO){
        InsuranceListEntity newInsuranceListEntity = insuranceListMapper.toEntity(insuranceListDTO);

        insuranceListRepository.save(newInsuranceListEntity);
    }

    @Override
    public List<InsuranceListDTO> getAll(){
        return StreamSupport.stream(insuranceListRepository.findAll().spliterator(), false)
                .map(i -> insuranceListMapper.toDTO(i))
                .toList();
    }

    @Override
    public InsuranceListDTO getById(long insuranceListId){
        InsuranceListEntity fetchedInsuranceList = getInsuranceListOrThrow(insuranceListId);

        return insuranceListMapper.toDTO(fetchedInsuranceList);
    }

    @Override
    public void edit(InsuranceListDTO insuranceListDTO){
        InsuranceListEntity fetchedInsuranceList = getInsuranceListOrThrow(insuranceListDTO.getInsuranceListId());
        insuranceListMapper.updateInsuranceListEntity(insuranceListDTO, fetchedInsuranceList);
        insuranceListRepository.save(fetchedInsuranceList);
    }

    @Override
    public void remove(long insuranceListId){
        InsuranceListEntity fetchedInsuranceList = getInsuranceListOrThrow(insuranceListId);
        insuranceListRepository.delete(fetchedInsuranceList);
    }

    private InsuranceListEntity getInsuranceListOrThrow(long insuranceListId){
        return insuranceListRepository
                .findById(insuranceListId)
                .orElseThrow(InsuranceListNotFoundException::new);
    }
}
