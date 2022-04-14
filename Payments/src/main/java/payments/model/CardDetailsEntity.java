package payments.model;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class CardDetailsEntity {
	
	private String cardHolderName;
	private String cardType;
	@Id
	private String cardNumber;
	private String cardExpiryDate;
	private String securityCode;
	private Integer cardBalance;
	public CardDetailsEntity() {
		super();
	}
	public CardDetailsEntity(String cardHolderName, String cardType, String cardNumber, String cardExpiryDate,
			String securityCode, Integer cardBalance) {
		super();
		this.cardHolderName = cardHolderName;
		this.cardType = cardType;
		this.cardNumber = cardNumber;
		this.cardExpiryDate = cardExpiryDate;
		this.securityCode = securityCode;
		this.cardBalance = cardBalance;
	}
	public String getCardHolderName() {
		return cardHolderName;
	}
	public void setCardHolderName(String cardHolderName) {
		this.cardHolderName = cardHolderName;
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
	public String getCardExpiryDate() {
		return cardExpiryDate;
	}
	public void setCardExpiryDate(String cardExpiryDate) {
		this.cardExpiryDate = cardExpiryDate;
	}
	public String getSecurityCode() {
		return securityCode;
	}
	public void setSecurityCode(String securityCode) {
		this.securityCode = securityCode;
	}
	public Integer getCardBalance() {
		return cardBalance;
	}
	public void setCardBalance(Integer cardBalance) {
		this.cardBalance = cardBalance;
	}
	
	
}
