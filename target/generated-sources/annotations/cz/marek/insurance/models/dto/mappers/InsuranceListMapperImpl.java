package cz.marek.insurance.models.dto.mappers;

import cz.marek.insurance.data.entities.InsuranceListEntity;
import cz.marek.insurance.models.dto.InsuranceListDTO;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2025-01-15T22:36:01+0100",
    comments = "version: 1.5.3.Final, compiler: javac, environment: Java 21.0.5 (Oracle Corporation)"
)
@Component
public class InsuranceListMapperImpl implements InsuranceListMapper {

    @Override
    public InsuranceListEntity toEntity(InsuranceListDTO source) {
        if ( source == null ) {
            return null;
        }

        InsuranceListEntity insuranceListEntity = new InsuranceListEntity();

        insuranceListEntity.setInsuranceListId( source.getInsuranceListId() );
        insuranceListEntity.setInsuranceName( source.getInsuranceName() );
        insuranceListEntity.setInsuranceDescription( source.getInsuranceDescription() );
        insuranceListEntity.setInsuranceCompany( source.getInsuranceCompany() );

        return insuranceListEntity;
    }

    @Override
    public InsuranceListDTO toDTO(InsuranceListEntity source) {
        if ( source == null ) {
            return null;
        }

        InsuranceListDTO insuranceListDTO = new InsuranceListDTO();

        insuranceListDTO.setInsuranceListId( source.getInsuranceListId() );
        insuranceListDTO.setInsuranceName( source.getInsuranceName() );
        insuranceListDTO.setInsuranceDescription( source.getInsuranceDescription() );
        insuranceListDTO.setInsuranceCompany( source.getInsuranceCompany() );

        return insuranceListDTO;
    }

    @Override
    public void updateInsuranceListDTO(InsuranceListDTO source, InsuranceListDTO target) {
        if ( source == null ) {
            return;
        }

        target.setInsuranceListId( source.getInsuranceListId() );
        target.setInsuranceName( source.getInsuranceName() );
        target.setInsuranceDescription( source.getInsuranceDescription() );
        target.setInsuranceCompany( source.getInsuranceCompany() );
    }

    @Override
    public void updateInsuranceListEntity(InsuranceListDTO source, InsuranceListEntity target) {
        if ( source == null ) {
            return;
        }

        target.setInsuranceListId( source.getInsuranceListId() );
        target.setInsuranceName( source.getInsuranceName() );
        target.setInsuranceDescription( source.getInsuranceDescription() );
        target.setInsuranceCompany( source.getInsuranceCompany() );
    }
}
