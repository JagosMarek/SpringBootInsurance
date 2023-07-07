package cz.marek.insurance.models.dto.mappers;

import cz.marek.insurance.data.entities.InsuranceEntity;
import cz.marek.insurance.models.dto.InsuranceDTO;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;

@Mapper(componentModel = "spring")
public interface InsuranceMapper {

    InsuranceEntity toEntity(InsuranceDTO source);

    InsuranceDTO toDTO(InsuranceEntity source);

    void updateInsuranceDTO(InsuranceDTO source, @MappingTarget InsuranceDTO target);
    void updateInsuranceEntity(InsuranceDTO source, @MappingTarget InsuranceEntity target);
}
