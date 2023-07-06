package cz.marek.insurance.models.dto.mappers;

import cz.marek.insurance.data.entities.InsuranceEntity;
import cz.marek.insurance.models.dto.InsuranceDTO;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2023-07-06T16:06:06+0200",
    comments = "version: 1.5.3.Final, compiler: javac, environment: Java 17.0.6 (Eclipse Adoptium)"
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
        insuranceEntity.setInsuredId( source.getInsuredId() );
        insuranceEntity.setInsuranceListId( source.getInsuranceListId() );
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
        insuranceDTO.setInsuredId( source.getInsuredId() );
        insuranceDTO.setInsuranceListId( source.getInsuranceListId() );
        insuranceDTO.setInsuranceLimit( source.getInsuranceLimit() );
        insuranceDTO.setBeginning( source.getBeginning() );
        insuranceDTO.setEnd( source.getEnd() );
        insuranceDTO.setSubjectOfInsurance( source.getSubjectOfInsurance() );

        return insuranceDTO;
    }
}
