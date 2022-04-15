package movie.repo;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import movie.model.MovieInfo;

@Repository
public interface MovieRepo extends CrudRepository<MovieInfo, String>{


	MovieInfo findByMovieName(String movieName);

}

