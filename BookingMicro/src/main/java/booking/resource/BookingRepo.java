package booking.resource;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import booking.model.BookingEntity;

@Repository
public interface BookingRepo extends CrudRepository<BookingEntity, String>{

}
