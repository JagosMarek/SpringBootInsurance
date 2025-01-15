package cz.marek.insurance.models.dto.mappers;

import cz.marek.insurance.data.entities.InsuranceEntity;
import cz.marek.insurance.models.dto.InsuranceDTO;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2025-01-15T21:50:57+0100",
    comments = "version: 1.5.3.Final, compiler: javac, environment: Java 21.0.5 (Oracle Corporation)"
)
@Component
public class InsuranceMapperImpl implements InsuranceMapper {

    @Override
    public InsuranceEntity toEntity(InsuranceDTO source) {
        if ( source == null ) {
            return null;
        }

        InsuranceEntity insuranceEntity = new InsuranceEntity();

        insuranceEntity.setInsuranceId( source.getInsuranceId() );
        insuranceEntity.setInsuranceLimit( source.getInsuranceLimit() );
        insuranceEntity.setBeginning( source.getBeginning() );
        insuranceEntity.setEnd( source.getEnd() );
        insuranceEntity.setSubjectOfInsurance( source.getSubjectOfInsurance() );

        return insuranceEntity;
    }

    @Override
    public InsuranceDTO toDTO(InsuranceEntity source) {
        if ( source == null ) {
            return null;
        }

        InsuranceDTO insuranceDTO = new InsuranceDTO();

        insuranceDTO.setInsuranceId( source.getInsuranceId() );
        insuranceDTO.setInsuranceLimit( source.getInsuranceLimit() );
        insuranceDTO.setBeginning( source.getBeginning() );
        insuranceDTO.setEnd( source.getEnd() );
        insuranceDTO.setSubjectOfInsurance( source.getSubjectOfInsurance() );

        return insuranceDTO;
    }

    @Override
    public void updateInsuranceDTO(InsuranceDTO source, InsuranceDTO target) {
        if ( source == null ) {
            return;
        }

        target.setInsuranceId( source.getInsuranceId() );
        target.setInsuredId( source.getInsuredId() );
        target.setInsuranceListId( source.getInsuranceListId() );
        target.setInsuranceLimit( source.getInsuranceLimit() );
        target.setBeginning( source.getBeginning() );
        target.setEnd( source.getEnd() );
        target.setSubjectOfInsurance( source.getSubjectOfInsurance() );
    }

    @Override
    public void updateInsuranceEntity(InsuranceDTO source, InsuranceEntity target) {
        if ( source == null ) {
            return;
        }

        target.setInsuranceId( source.getInsuranceId() );
        target.setInsuranceLimit( source.getInsuranceLimit() );
        target.setBeginning( source.getBeginning() );
        target.setEnd( source.getEnd() );
        target.setSubjectOfInsurance( source.getSubjectOfInsurance() );
    }
}
