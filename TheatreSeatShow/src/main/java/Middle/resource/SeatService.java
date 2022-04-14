package Middle.resource;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import Middle.model.CompositeId;
import Middle.model.SeatEntity;

@Repository
public interface SeatService extends CrudRepository<SeatEntity, String>{

	//SeatEntity findById(CompositeId compositeId);

	SeatEntity findByCompositeId(CompositeId compositeId);


}
