package movie.model;

import java.awt.Image;
import java.util.ArrayList;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class MovieInfo {
	
	@Id
	private String movieId;
	private String movieName;
	private String movieCast;
	private String movieCrew;
	private String movieDescription;
	
	public MovieInfo() {
		super();
	}

	public MovieInfo(String movieId, String movieName, String movieCast, String movieCrew, String movieDescription) {
		super();
		this.movieId = movieId;
		this.movieName = movieName;
		this.movieCast = movieCast;
		this.movieCrew = movieCrew;
		this.movieDescription = movieDescription;
	}

	public String getMovieId() {
		return movieId;
	}

	public void setMovieId(String movieId) {
		this.movieId = movieId;
	}

	public String getMovieName() {
		return movieName;
	}

	public void setMovieName(String movieName) {
		this.movieName = movieName;
	}

	public String getMovieCast() {
		return movieCast;
	}

	public void setMovieCast(String movieCast) {
		this.movieCast = movieCast;
	}

	public String getMovieCrew() {
		return movieCrew;
	}

	public void setMovieCrew(String movieCrew) {
		this.movieCrew = movieCrew;
	}

	public String getMovieDescription() {
		return movieDescription;
	}

	public void setMovieDescription(String movieDescription) {
		this.movieDescription = movieDescription;
	}

	

}