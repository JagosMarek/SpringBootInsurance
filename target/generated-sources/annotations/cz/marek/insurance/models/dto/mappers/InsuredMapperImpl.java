package cz.marek.insurance.models.dto.mappers;

import cz.marek.insurance.data.entities.InsuredEntity;
import cz.marek.insurance.models.dto.InsuredDTO;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2025-01-08T22:37:08+0100",
    comments = "version: 1.5.3.Final, compiler: javac, environment: Java 21.0.5 (Oracle Corporation)"
)
@Component
public class InsuredMapperImpl implements InsuredMapper {

    @Override
    public InsuredEntity toEntity(InsuredDTO source) {
        if ( source == null ) {
            return null;
        }

        InsuredEntity insuredEntity = new InsuredEntity();

        insuredEntity.setInsuredId( source.getInsuredId() );
        insuredEntity.setBirthNumber( source.getBirthNumber() );
        insuredEntity.setFirstName( source.getFirstName() );
        insuredEntity.setLastName( source.getLastName() );
        insuredEntity.setEmail( source.getEmail() );
        insuredEntity.setPhone( source.getPhone() );
        insuredEntity.setStreet( source.getStreet() );
        insuredEntity.setCity( source.getCity() );
        insuredEntity.setPsc( source.getPsc() );

        return insuredEntity;
    }

    @Override
    public InsuredDTO toDTO(InsuredEntity source) {
        if ( source == null ) {
            return null;
        }

        InsuredDTO insuredDTO = new InsuredDTO();

        insuredDTO.setInsuredId( source.getInsuredId() );
        insuredDTO.setBirthNumber( source.getBirthNumber() );
        insuredDTO.setFirstName( source.getFirstName() );
        insuredDTO.setLastName( source.getLastName() );
        insuredDTO.setEmail( source.getEmail() );
        insuredDTO.setPhone( source.getPhone() );
        insuredDTO.setStreet( source.getStreet() );
        insuredDTO.setCity( source.getCity() );
        insuredDTO.setPsc( source.getPsc() );

        return insuredDTO;
    }

    @Override
    public void updateInsuredDTO(InsuredDTO source, InsuredDTO target) {
        if ( source == null ) {
            return;
        }

        target.setInsuredId( source.getInsuredId() );
        target.setBirthNumber( source.getBirthNumber() );
        target.setFirstName( source.getFirstName() );
        target.setLastName( source.getLastName() );
        target.setEmail( source.getEmail() );
        target.setPhone( source.getPhone() );
        target.setStreet( source.getStreet() );
        target.setCity( source.getCity() );
        target.setPsc( source.getPsc() );
    }

    @Override
    public void updateInsuredEntity(InsuredDTO source, InsuredEntity target) {
        if ( source == null ) {
            return;
        }

        target.setInsuredId( source.getInsuredId() );
        target.setBirthNumber( source.getBirthNumber() );
        target.setFirstName( source.getFirstName() );
        target.setLastName( source.getLastName() );
        target.setEmail( source.getEmail() );
        target.setPhone( source.getPhone() );
        target.setStreet( source.getStreet() );
        target.setCity( source.getCity() );
        target.setPsc( source.getPsc() );
    }
}
