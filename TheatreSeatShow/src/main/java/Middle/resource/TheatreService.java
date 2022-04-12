package Middle.resource;

import java.util.ArrayList;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import Middle.model.TheatreEntity;

@Repository
public interface TheatreService extends CrudRepository<TheatreEntity, String>{

	ArrayList<TheatreEntity> findByTheatreLocation(String location);

	ArrayList<TheatreEntity> findByTheatreCity(String location);

}
