package movie.model;

import java.awt.Image;
import java.awt.image.BufferedImage;
import java.util.ArrayList;

public class MovieRating {
	
	private String movieId;
	private String movieName;
	private String movieCast;
	private String movieCrew;
	private String movieDescription;
	private float movieOverallRating;
	private ArrayList<UserRating> userRatings;
	public MovieRating() {
		super();
	}
	public MovieRating(String movieId, String movieName, String movieCast, String movieCrew, String movieDescription,
			float movieOverallRating, ArrayList<UserRating> userRatings) {
		super();
		this.movieId = movieId;
		this.movieName = movieName;
		this.movieCast = movieCast;
		this.movieCrew = movieCrew;
		this.movieDescription = movieDescription;
		this.movieOverallRating = movieOverallRating;
		this.userRatings = userRatings;
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
	public float getMovieOverallRating() {
		return movieOverallRating;
	}
	public void setMovieOverallRating(float movieOverallRating) {
		this.movieOverallRating = movieOverallRating;
	}
	public ArrayList<UserRating> getUserRatings() {
		return userRatings;
	}
	public void setUserRatings(ArrayList<UserRating> userRatings) {
		this.userRatings = userRatings;
	}
	
	
}