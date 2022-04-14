package payments.repo;

import java.util.Optional;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import payments.model.CardDetailsEntity;

@Repository
public interface CardRepo extends CrudRepository<CardDetailsEntity, String> {

	void save(Optional<CardDetailsEntity> c);

}
