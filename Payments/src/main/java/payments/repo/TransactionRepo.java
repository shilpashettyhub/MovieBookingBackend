package payments.repo;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import payments.model.TransactionEntity;

@Repository
public interface TransactionRepo extends CrudRepository<TransactionEntity, String>{
	
	

}
