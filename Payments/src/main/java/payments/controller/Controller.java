package payments.controller;


import java.awt.PageAttributes.MediaType;
import java.net.http.HttpHeaders;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import payments.model.BookingEntity;
import payments.model.CardDetailsEntity;
import payments.model.GeneralCardBooking;
import payments.model.SeatUpdate;
import payments.model.TransactionEntity;
import payments.repo.CardRepo;
import payments.repo.TransactionRepo;
import payments.model.General;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
public class Controller {
	
	@Autowired
	CardRepo cardRepo;
	
	@Autowired
	TransactionRepo transactionRepo;
	
	@GetMapping("/getcarddetails/{cardnumber}")
	public Optional<CardDetailsEntity> getCardDetails(@PathVariable String cardnumber) {
		
		return cardRepo.findById(cardnumber);		
		
	}
	
	/*@PostMapping("/checkcarddetails")
	public GeneralCardBooking checkCredentials(@RequestBody GeneralCardBooking generalCardBooking) throws Exception {
		
		
		 Optional<CardDetailsEntity> e = cardRepo.findById(generalCardBooking.getCardNumber());
		 if(!e.equals(null)) {
			 System.out.println("Coming here: inside is object null");
			 if(e.get().getCardHolderName().equals(generalCardBooking.getCardName()) && e.get().getCardType().equals(generalCardBooking.getCardType()) && e.get().getSecurityCode().equals(generalCardBooking.getCvv()) && e.get().getCardBalance()>= generalCardBooking.getAmountPayable() && e.get().getCardExpiryDate().equals(generalCardBooking.getExpDate())) {
				 
				 System.out.println("Coming here inside checking of credentials");
				 String expirationDate1 = generalCardBooking.getExpDate();
				 expirationDate1 = expirationDate1 + "-28";
				 
				  DateTimeFormatter format = DateTimeFormatter.ofPattern("yyyy-MM-dd");
				  //convert String to LocalDate
				  LocalDate expirationDate = LocalDate.parse(expirationDate1, format);
				 
				 LocalDate today = LocalDate.now(ZoneId.systemDefault());
				 if(today.isBefore(expirationDate)) {
					 
					 System.out.println("Coming here inside checking of expiry date");
					 
					 BookingEntity b = new BookingEntity();
					 b.setBookingId(generalCardBooking.getBookingId());
					 b.setUserId(generalCardBooking.getUserId());
					 b.setTheatreId(generalCardBooking.getTheatreId());
					 b.setShowId(generalCardBooking.getShowId());
					 b.setMovieName(generalCardBooking.getMovieName());
					 b.setDate(generalCardBooking.getDate());
					 b.setTime(generalCardBooking.getTime());
					 b.setCostPerSeat(generalCardBooking.getCostPerSeat());
					 b.setNoOfSeats(generalCardBooking.getNoOfSeats());
					 b.setAmountPayable(generalCardBooking.getAmountPayable());
					 
					 
					 
					 RestTemplate restTemplate = new RestTemplate();
					 restTemplate.postForLocation("http://localhost:8080/savebooking", b);
	                  
					 System.out.println("booked");
					 
					 TransactionEntity t = new TransactionEntity();
					 
					 CardDetailsEntity c = cardRepo.findById(generalCardBooking.getCardNumber()).get();
					 c.setCardBalance(c.getCardBalance()- (generalCardBooking.getCostPerSeat()* generalCardBooking.getNoOfSeats()));
					 cardRepo.save(c);
					 
					 /*
					 t.setTransactionType("Card Scan");
					 t.setTransactionStatus("");
					 theatreId;
					 theatreName;
					 userId;
					 userName;
					cardNumber;
					 Amount;
					 transactionRepo.save();
					 
					 return generalCardBooking;
					 
				 }
				 else
					 throw new Exception("Card Expired");
			 }
			 else
				 throw new Exception("Invalid Credentials!!");
				 
		 }
		 else 
			 throw new Exception("Card does not Exist!!!");
		
	}
	*/
	
	@PostMapping("/checkcarddetails")
	public General checkCredentials(@RequestBody General general) throws Exception{
		System.out.println("inside general :" + general.getSelectedSeatList());
		System.out.println("This is general object expiry date in string"+general.getCardDetailsEntity().getExpDate());
		
		System.out.println("Coming inside function");
		Optional<CardDetailsEntity> e = cardRepo.findById(general.getCardDetailsEntity().getCardNumber());
		System.out.println("This is e"+e);
		if(e.isPresent()) {
			
			System.out.println(general.getCardDetailsEntity().getExpDate());
			
			 System.out.println("Coming here: inside is object null");
			 if(general.getCardDetailsEntity().getCardName().equals(e.get().getCardHolderName()) &&
			    general.getCardDetailsEntity().getCardNumber().equals(e.get().getCardNumber()) &&
			    general.getCardDetailsEntity().getCvv().equals(e.get().getSecurityCode()) &&
			    general.getCardDetailsEntity().getCardType().equals(e.get().getCardType()) &&
			    general.getCardDetailsEntity().getExpDate().equals(e.get().getCardExpiryDate()) &&
			    e.get().getCardBalance() >= general.getBookingEntity().getAmountPayable()) {
				 
				 System.out.println("Coming here inside checking of credentials");
				 
				 String parseDate = general.getCardDetailsEntity().getExpDate();
				 parseDate = parseDate + "-28";
				 DateTimeFormatter format = DateTimeFormatter.ofPattern("yyyy-MM-dd");
				  //convert String to LocalDate
				 LocalDate expirationDate = LocalDate.parse(parseDate, format);
				 LocalDate today = LocalDate.now(ZoneId.systemDefault());
				 
				 if(today.isBefore(expirationDate)) {
					 
					 System.out.println("Coming here inside checking of expiry date");
					 
					 BookingEntity b = new BookingEntity();
					 b.setBookingId(general.getBookingEntity().getBookingId());
					 b.setUserId(general.getBookingEntity().getUserId());
					 b.setTheatreId(general.getBookingEntity().getTheatreId());
					 b.setShowId(general.getBookingEntity().getShowId());
					 b.setMovieName(general.getBookingEntity().getMovieName());
					 b.setDate(general.getBookingEntity().getDate());
					 b.setTime(general.getBookingEntity().getTime());
					 b.setCostPerSeat(general.getBookingEntity().getCostPerSeat());
					 b.setNoOfSeats(general.getBookingEntity().getNoOfSeats());
					 b.setAmountPayable(general.getBookingEntity().getCostPerSeat()*general.getBookingEntity().getNoOfSeats());
					 
					 
					 RestTemplate restTemplate= new RestTemplate();
					 restTemplate.postForLocation("http://localhost:8080/savebooking", b);
					 
					 System.out.println("Booked");

					 
					 CardDetailsEntity c = cardRepo.findById(general.getCardDetailsEntity().getCardNumber()).get();
					 c.setCardBalance(c.getCardBalance()-(general.getBookingEntity().getCostPerSeat()*general.getBookingEntity().getNoOfSeats()));
					 cardRepo.save(c);
					 
					 System.out.println("Updated Card Table");
					 
					TransactionEntity t = new TransactionEntity();
					t.setTransactionId(null);
					t.setCardNumber(c.getCardNumber());
					t.setAmount(b.getAmountPayable());
					t.setTheatreId(b.getTheatreId());
					t.setTransactionType("Credit Card Transaction");
					t.setTransactionStatus("Success");
					transactionRepo.save(t);
					
					System.out.println("Updated transaction table");
					
				    SeatUpdate seatUpdate = new SeatUpdate(); 
				    seatUpdate.setTheatreId(b.getTheatreId());
				    seatUpdate.setShowId(b.getShowId());
				    seatUpdate.setSeatList(general.getSelectedSeatList());
				    
				    System.out.println("inside seat Update "+seatUpdate.getSeatList());
				    
				    restTemplate.postForLocation("http://localhost:8082/changeseatstatus", seatUpdate);
				    
				    System.out.println("Seat Status updated");
					
					
					 return general;					
					 
				 }
				 else
					 throw new Exception("Card Expired!!!");
				 
				
				 }
			 else
				 throw new Exception("Invalid Credentials");			 
				 
			 }
		else
			throw new Exception("Card does not exist!!");
			
		
	}
	
	@GetMapping("/getgeneralobject")
	public General getGeneralObject() {
		return new General();
	}
	
	
	
}


