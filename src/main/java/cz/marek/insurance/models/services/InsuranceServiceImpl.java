package cz.marek.insurance.models.services;

import cz.marek.insurance.data.entities.InsuranceEntity;
import cz.marek.insurance.data.repositories.InsuranceRepository;
import cz.marek.insurance.models.dto.InsuranceDTO;
import cz.marek.insurance.models.dto.mappers.InsuranceMapper;
import cz.marek.insurance.models.exceptions.InsuranceNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

@Service
public class InsuranceServiceImpl implements InsuranceService{

   @Autowired
   private InsuranceRepository insuranceRepository;
   @Autowired
   private InsuredService insuredService;
   @Autowired
   private InsuranceMapper insuranceMapper;

   @Override
   public void create(InsuranceDTO insuranceDTO) {
      InsuranceEntity newInsurance = insuranceMapper.toEntity(insuranceDTO);

      insuranceRepository.save(newInsurance);
   }

   @Override
   public List<InsuranceDTO> getAll(){
      return StreamSupport.stream(insuranceRepository.findAll().spliterator(), false)
              .map(i -> insuranceMapper.toDTO(i))
              .toList();
   }

   @Override
   public List<InsuranceDTO> getByInsuredId(long insuredId) {
      List<InsuranceEntity> insuranceEntities = insuranceRepository.findByInsured_InsuredId(insuredId);
      return insuranceEntities.stream()
              .map(insuranceMapper::toDTO)
              .collect(Collectors.toList());
   }

   @Override
   public List<InsuranceDTO> getByInsuranceListId(long insuranceListId) {
      List<InsuranceEntity> insuranceEntities = insuranceRepository.findByInsuranceList_InsuranceListId(insuranceListId);
      return insuranceEntities.stream()
              .map(insuranceMapper::toDTO)
              .collect(Collectors.toList());
   }

   @Override
   public InsuranceDTO getById(long insuranceId){
      InsuranceEntity fetchedInsurance = getInsuranceOrThrow(insuranceId);

      return insuranceMapper.toDTO(fetchedInsurance);
   }

   @Override
   public void edit(InsuranceDTO insuranceDTO){
      InsuranceEntity fetchedInsurance = getInsuranceOrThrow(insuranceDTO.getInsuranceId());

      insuranceMapper.updateInsuranceEntity(insuranceDTO, fetchedInsurance);
      insuranceRepository.save(fetchedInsurance);
   }

   @Override
   public void remove(long insuranceId){
      InsuranceEntity fetchedEntity = getInsuranceOrThrow(insuranceId);
      insuranceRepository.delete(fetchedEntity);
   }

   private InsuranceEntity getInsuranceOrThrow(long insuranceId){
      return insuranceRepository
              .findById(insuranceId)
              .orElseThrow(InsuranceNotFoundException::new);
   }
}
