package movie.model;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;

@Entity
public class UserRating {
	
	@EmbeddedId
	private CompositeId compositeId;
	private String userName;
	private int userRating;
	private String userComment;
	public UserRating() {
		super();
	}
	public UserRating(CompositeId compositeId, String userName, int userRating, String userComment) {
		super();
		this.compositeId = compositeId;
		this.userName = userName;
		this.userRating = userRating;
		this.userComment = userComment;
	}
	public CompositeId getCompositeId() {
		return compositeId;
	}
	public void setCompositeId(CompositeId compositeId) {
		this.compositeId = compositeId;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public int getUserRating() {
		return userRating;
	}
	public void setUserRating(int userRating) {
		this.userRating = userRating;
	}
	public String getUserComment() {
		return userComment;
	}
	public void setUserComment(String userComment) {
		this.userComment = userComment;
	}
	
}

