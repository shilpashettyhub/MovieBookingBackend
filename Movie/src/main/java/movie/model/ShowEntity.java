package movie.model;

import java.time.LocalDate;
import java.time.LocalTime;

import javax.persistence.Entity;
import javax.persistence.Id;

public class ShowEntity {

	private String showId;
	private String theatreId;
	private String movieName;
	private LocalDate date;
	private LocalTime time;
	private LocalTime duration;
	private Integer costPerSeat;
	public ShowEntity() {
		super();
	}
	public ShowEntity(String showId, String theatreId, String movieName, LocalDate date, LocalTime time,
			LocalTime duration, Integer costPerSeat) {
		super();
		this.showId = showId;
		this.theatreId = theatreId;
		this.movieName = movieName;
		this.date = date;
		this.time = time;
		this.duration = duration;
		this.costPerSeat = costPerSeat;
	}
	public String getShowId() {
		return showId;
	}
	public void setShowId(String showId) {
		this.showId = showId;
	}
	public String getTheatreId() {
		return theatreId;
	}
	public void setTheatreId(String theatreId) {
		this.theatreId = theatreId;
	}
	public String getMovieName() {
		return movieName;
	}
	public void setMovieName(String movieName) {
		this.movieName = movieName;
	}
	public LocalDate getDate() {
		return date;
	}
	public void setDate(LocalDate date) {
		this.date = date;
	}
	public LocalTime getTime() {
		return time;
	}
	public void setTime(LocalTime time) {
		this.time = time;
	}
	public LocalTime getDuration() {
		return duration;
	}
	public void setDuration(LocalTime duration) {
		this.duration = duration;
	}
	public Integer getCostPerSeat() {
		return costPerSeat;
	}
	public void setCostPerSeat(Integer costPerSeat) {
		this.costPerSeat = costPerSeat;
	}
	

}

