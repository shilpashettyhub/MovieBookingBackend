package booking.resource;

import java.util.ArrayList;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import booking.model.BookingEntity;

@Repository
public interface BookingRepo extends CrudRepository<BookingEntity, String>{

	

}
