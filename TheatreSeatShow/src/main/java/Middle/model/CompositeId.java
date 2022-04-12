package Middle.model;

import java.io.Serializable;

import javax.persistence.Embeddable;
import javax.persistence.Id;

@Embeddable
public class CompositeId implements Serializable{

	private String seatNumber;
	private String theatreId;
	private String showId;
	public CompositeId() {
		super();
	}
	public CompositeId(String seatNumber, String theatreId, String showId) {
		super();
		this.seatNumber = seatNumber;
		this.theatreId = theatreId;
		this.showId = showId;
	}
	public String getSeatNumber() {
		return seatNumber;
	}
	public void setSeatNumber(String seatNumber) {
		this.seatNumber = seatNumber;
	}
	public String getTheatreId() {
		return theatreId;
	}
	public void setTheatreId(String theatreId) {
		this.theatreId = theatreId;
	}
	public String getShowId() {
		return showId;
	}
	public void setShowId(String showId) {
		this.showId = showId;
	}
	

}
