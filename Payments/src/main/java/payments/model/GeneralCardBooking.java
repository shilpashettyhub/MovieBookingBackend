package payments.model;

import java.time.LocalDate;
import java.time.LocalTime;

public class GeneralCardBooking {
	
	
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
	private String cardName;
	private String cardNumber;
	private String cvv;
	private String cardType;
	private String expDate;
	public GeneralCardBooking() {
		super();
	}
	public GeneralCardBooking(String bookingId, String userId, String theatreId, String showId, String movieName,
			LocalDate date, LocalTime time, Integer costPerSeat, Integer noOfSeats, Integer amountPayable,
			String cardName, String cardNumber, String cvv, String cardType, String expDate) {
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
		this.amountPayable = amountPayable;
		this.cardName = cardName;
		this.cardNumber = cardNumber;
		this.cvv = cvv;
		this.cardType = cardType;
		this.expDate = expDate;
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
	public String getCardName() {
		return cardName;
	}
	public void setCardName(String cardName) {
		this.cardName = cardName;
	}
	public String getCardNumber() {
		return cardNumber;
	}
	public void setCardNumber(String cardNumber) {
		this.cardNumber = cardNumber;
	}
	public String getCvv() {
		return cvv;
	}
	public void setCvv(String cvv) {
		this.cvv = cvv;
	}
	public String getCardType() {
		return cardType;
	}
	public void setCardType(String cardType) {
		this.cardType = cardType;
	}
	public String getExpDate() {
		return expDate;
	}
	public void setExpDate(String expDate) {
		this.expDate = expDate;
	}
	
}



