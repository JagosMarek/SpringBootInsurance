package cz.marek.insurance.models.dto.mappers;

import cz.marek.insurance.data.entities.InsuredEntity;
import cz.marek.insurance.models.dto.InsuredDTO;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;

@Mapper(componentModel = "spring")
public interface InsuredMapper {

    InsuredEntity toEntity(InsuredDTO source);
    InsuredDTO toDTO(InsuredEntity source);

    void updateInsuredDTO(InsuredDTO source, @MappingTarget InsuredDTO target);
    void updateInsuredEntity(InsuredDTO source, @MappingTarget InsuredEntity target);
}
