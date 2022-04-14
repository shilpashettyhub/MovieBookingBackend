package Middle.model;

import java.util.ArrayList;
import java.util.List;

public class SeatUpdate {
	
	private String theatreId;
	private String showId;
	private List<String> seatList;
	public SeatUpdate() {
		super();
	}
	public SeatUpdate(String theatreId, String showId, List<String> seatList) {
		super();
		this.theatreId = theatreId;
		this.showId = showId;
		this.seatList = seatList;
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
	public List<String> getSeatList() {
		return seatList;
	}
	public void setSeatList(List<String> seatList) {
		this.seatList = seatList;
	}
}
