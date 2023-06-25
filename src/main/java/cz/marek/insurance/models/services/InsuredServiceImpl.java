package cz.marek.insurance.models.services;

import cz.marek.insurance.data.entities.InsuredEntity;
import cz.marek.insurance.data.repositories.InsuredRepository;
import cz.marek.insurance.models.dto.InsuredDTO;
import cz.marek.insurance.models.dto.mappers.InsuredMapper;
import cz.marek.insurance.models.exceptions.InsuredNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.StreamSupport;

@Service
public class InsuredServiceImpl implements InsuredService{

    @Autowired
    private InsuredMapper insuredMapper;

    @Autowired
    private InsuredRepository insuredRepository;

    @Override
    public void create(InsuredDTO insuredDTO){
        InsuredEntity newInsured = insuredMapper.toEntity(insuredDTO);

        insuredRepository.save(newInsured);
    }

    @Override
    public List<InsuredDTO> getAll(){
        return StreamSupport.stream(insuredRepository.findAll().spliterator(), false)
                .map(i -> insuredMapper.toDTO(i))
                .toList();
    }

    @Override
    public InsuredDTO getById(long insuredId){
        InsuredEntity fetchedInsured = getInsuredOrThrow(insuredId);

        return insuredMapper.toDTO(fetchedInsured);
    }

    @Override
    public void edit(InsuredDTO insuredDTO){
        InsuredEntity fetchedInsured = getInsuredOrThrow(insuredDTO.getInsuredId());

        insuredMapper.updateInsuredEntity(insuredDTO, fetchedInsured);
        insuredRepository.save(fetchedInsured);
    }

    @Override
    public void remove(long insuredId){
        InsuredEntity fetchedEntity = getInsuredOrThrow(insuredId);
        insuredRepository.delete(fetchedEntity);
    }

    private InsuredEntity getInsuredOrThrow(long insuredId){
        return insuredRepository
                .findById(insuredId)
                .orElseThrow(InsuredNotFoundException::new);
    }
}
