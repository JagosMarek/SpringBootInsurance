package cz.marek.insurance.data.repositories;

import cz.marek.insurance.data.entities.InsuredEntity;
import org.springframework.data.repository.CrudRepository;

public interface InsuredRepository extends CrudRepository<InsuredEntity, Long> {
}
