package payments.model;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;

public class General {

	private BookingEntity bookingEntity;
	private CardDummy cardDetailsEntity;
	private List<String> selectedSeatList;
	public General() {
		super();
	}
	public BookingEntity getBookingEntity() {
		return bookingEntity;
	}
	public void setBookingEntity(BookingEntity bookingEntity) {
		this.bookingEntity = bookingEntity;
	}
	public CardDummy getCardDetailsEntity() {
		return cardDetailsEntity;
	}
	public void setCardDetailsEntity(CardDummy cardDetailsEntity) {
		this.cardDetailsEntity = cardDetailsEntity;
	}
	public List<String> getSelectedSeatList() {
		return selectedSeatList;
	}
	public void setSelectedSeatList(List<String> selectedSeatList) {
		this.selectedSeatList = selectedSeatList;
	}
	
//	public General(BookingEntity bookingEntity, CardDummy cardDetailsEntity, ArrayList<String> seatList) {
//		super();
//		this.bookingEntity = bookingEntity;
//		this.cardDetailsEntity = cardDetailsEntity;
//		this.selectedSeatList = seatList;
//	}

	
}
