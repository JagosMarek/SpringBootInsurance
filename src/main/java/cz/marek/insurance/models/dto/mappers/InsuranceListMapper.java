package cz.marek.insurance.models.dto.mappers;

import cz.marek.insurance.data.entities.InsuranceListEntity;
import cz.marek.insurance.models.dto.InsuranceListDTO;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;

@Mapper(componentModel = "spring")
public interface InsuranceListMapper {

    InsuranceListEntity toEntity(InsuranceListDTO source);
    InsuranceListDTO toDTO(InsuranceListEntity source);
    void updateInsuranceListDTO(InsuranceListDTO source, @MappingTarget InsuranceListDTO target);
    void updateInsuranceListEntity(InsuranceListDTO source, @MappingTarget InsuranceListEntity target);
}
