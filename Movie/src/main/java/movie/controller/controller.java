package movie.controller;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import movie.model.MovieInfo;
import movie.model.MovieRating;
import movie.model.ShowEntity;
import movie.model.UserRating;
import movie.repo.MovieRepo;
import movie.repo.UserRatingRepo;


@RestController
@CrossOrigin(origins = "http://localhost:4200")
public class controller {
	
	@Autowired
	private MovieRepo movieRepo;
	
	@Autowired
	private UserRatingRepo userRatingRepo;
	
	
	@GetMapping("/getmoviedetails/{showId}")
	public MovieRating getMovieDetails(@PathVariable String showId) {
		
		
		RestTemplate restTemplate = new RestTemplate();
		String movieName = restTemplate.getForObject("http://localhost:8082/getmoviename/"+showId, String.class);
		MovieInfo movieInfo = movieRepo.findByMovieName(movieName);
		
		String movieId = movieInfo.getMovieId();
		ArrayList<UserRating> userRatings = new ArrayList<UserRating>();
		ArrayList<UserRating> userRatingss = (ArrayList<UserRating>) userRatingRepo.findAll();
		
		for(UserRating r: userRatingss) {
			
			if(r.getCompositeId().getMovieId().equals(movieId)) {
				userRatings.add(r);
			}
		}
		
		MovieRating movieRating = new MovieRating();
		movieRating.setMovieId(movieId);
		movieRating.setMovieName(movieName);
		movieRating.setMovieCast(movieInfo.getMovieCast());
		movieRating.setMovieCrew(movieInfo.getMovieCrew());
		movieRating.setMovieDescription(movieInfo.getMovieDescription());
		
		
		int rating = 0;
		
		for(UserRating u: userRatings) {
			
			rating = rating + u.getUserRating();
			
		}
		
		float overallRating = rating/userRatings.size();
		
		movieRating.setMovieOverallRating(overallRating);
		movieRating.setUserRatings(userRatings);
		
		return movieRating;
		
	}
}
