package movie.model;

import java.io.Serializable;

import javax.persistence.Embeddable;

@Embeddable
public class CompositeId implements Serializable{
	
	private String userEmail;
	private String movieId;
	public CompositeId() {
		super();
	}
	public CompositeId(String userEmail, String movieId) {
		super();
		this.userEmail = userEmail;
		this.movieId = movieId;
	}
	public String getUserEmail() {
		return userEmail;
	}
	public void setUserEmail(String userEmail) {
		this.userEmail = userEmail;
	}
	public String getMovieId() {
		return movieId;
	}
	public void setMovieId(String movieId) {
		this.movieId = movieId;
	}
	

}