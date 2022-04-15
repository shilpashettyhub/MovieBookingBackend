package movie.repo;

import java.util.ArrayList;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import movie.model.CompositeId;
import movie.model.UserRating;

@Repository
public interface UserRatingRepo extends CrudRepository<UserRating, CompositeId>{

	

}