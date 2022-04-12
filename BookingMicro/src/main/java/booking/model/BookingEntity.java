package booking.model;

import java.time.LocalDate;
import java.time.LocalTime;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import org.hibernate.annotations.GenericGenerator;

@Entity
public class BookingEntity {
	
	
	@Id 
	@GeneratedValue(generator="system-uuid")
	@GenericGenerator(name="system-uuid", strategy = "uuid")
	private String bookingId;
	private String userId;
	private String theatreId;
	private String showId;
	private String movieName;
	private LocalDate date;
	private LocalTime time;
	private Integer costPerSeat;
	private Integer noOfSeats;
	private Integer amountPayable;
	
	
	public BookingEntity() {
		super();
	}


	public BookingEntity(String bookingId, String userId, String theatreId, String showId, String movieName,
			LocalDate date, LocalTime time, Integer costPerSeat, Integer noOfSeats) {
		super();
		this.bookingId = bookingId;
		this.userId = userId;
		this.theatreId = theatreId;
		this.showId = showId;
		this.movieName = movieName;
		this.date = date;
		this.time = time;
		this.costPerSeat = costPerSeat;
		this.noOfSeats = noOfSeats;
		this.amountPayable = costPerSeat*noOfSeats;
	}


	public String getBookingId() {
		return bookingId;
	}


	public void setBookingId(String bookingId) {
		this.bookingId = bookingId;
	}


	public String getUserId() {
		return userId;
	}


	public void setUserId(String userId) {
		this.userId = userId;
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


	public Integer getCostPerSeat() {
		return costPerSeat;
	}


	public void setCostPerSeat(Integer costPerSeat) {
		this.costPerSeat = costPerSeat;
	}


	public Integer getNoOfSeats() {
		return noOfSeats;
	}


	public void setNoOfSeats(Integer noOfSeats) {
		this.noOfSeats = noOfSeats;
	}


	public Integer getAmountPayable() {
		return amountPayable;
	}


	public void setAmountPayable(Integer amountPayable) {
		this.amountPayable = amountPayable;
	}
	
	

}
