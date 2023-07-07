package cz.marek.insurance.data.repositories;

import cz.marek.insurance.data.entities.InsuranceEntity;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface InsuranceRepository extends CrudRepository<InsuranceEntity, Long> {

    List<InsuranceEntity> findByInsuredId(long insuredId);

}
