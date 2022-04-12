package Middle.resource;

import java.util.ArrayList;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import Middle.model.ShowEntity;


@Repository
public interface ShowService extends CrudRepository<ShowEntity, String>{

	ArrayList<ShowEntity> findByMovieName(String movie);

	ArrayList<ShowEntity> findByTheatreId(String theatreid);

}
