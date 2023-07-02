package cz.marek.insurance.data.repositories;

import cz.marek.insurance.data.entities.InsuranceListEntity;
import org.springframework.data.repository.CrudRepository;

public interface InsuranceListRepository extends CrudRepository<InsuranceListEntity, Long> {
}
