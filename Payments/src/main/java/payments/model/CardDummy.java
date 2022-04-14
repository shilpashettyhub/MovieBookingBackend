package payments.model;

import java.time.LocalDate;
import java.util.Date;

import javax.persistence.Id;

public class CardDummy {
	private String cardName;
	private String cardType;
	private String cardNumber;
	private String expDate;
	private String cvv;
	public CardDummy() {
		super();
	}
	public CardDummy(String cardName, String cardType, String cardNumber, String expDate, String cvv) {
		super();
		this.cardName = cardName;
		this.cardType = cardType;
		this.cardNumber = cardNumber;
		this.expDate = expDate;
		this.cvv = cvv;
	}
	public String getCardName() {
		return cardName;
	}
	public void setCardName(String cardName) {
		this.cardName = cardName;
	}
	public String getCardType() {
		return cardType;
	}
	public void setCardType(String cardType) {
		this.cardType = cardType;
	}
	public String getCardNumber() {
		return cardNumber;
	}
	public void setCardNumber(String cardNumber) {
		this.cardNumber = cardNumber;
	}
	public String getExpDate() {
		return expDate;
	}
	public void setExpDate(String expDate) {
		this.expDate = expDate;
	}
	public String getCvv() {
		return cvv;
	}
	public void setCvv(String cvv) {
		this.cvv = cvv;
	}
	
	
	
}
