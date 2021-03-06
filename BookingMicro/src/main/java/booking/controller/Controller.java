package booking.controller;
import java.util.ArrayList;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import booking.model.BookingEntity;
import booking.model.ShowEntity;
import booking.resource.BookingRepo;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
public class Controller {
	
	@Autowired
	BookingRepo bookingRepo;
	
	@GetMapping("/bookings/{userId}")
	public ArrayList<BookingEntity> getBookings(@PathVariable String userId){
		ArrayList<BookingEntity> bookings = (ArrayList<BookingEntity>) bookingRepo.findAll();
		ArrayList<BookingEntity> userBookings = new ArrayList<BookingEntity>();
		for(BookingEntity b: bookings) {
			if(b.getUserId().equals(userId)) {
				userBookings.add(b);
			}
		}
		return userBookings;
	}
	
	@PostMapping("/savebookings/{userid}/{nos}")
	public String createBooking(@RequestBody ShowEntity showEntity,@PathVariable String userid, @PathVariable Integer nos) {
		BookingEntity bookingEntity = new BookingEntity();
		bookingEntity.setUserId(userid);
		bookingEntity.setNoOfSeats(nos);
		bookingEntity.setCostPerSeat(showEntity.getCostPerSeat());
		bookingEntity.setDate(showEntity.getDate());
		bookingEntity.setMovieName(showEntity.getMovieName());
		bookingEntity.setShowId(showEntity.getShowId());
		bookingEntity.setTheatreId(showEntity.getTheatreId());
		bookingEntity.setTime(showEntity.getTime());
		bookingRepo.save(bookingEntity);
		return "Booking Done";
	}
	@GetMapping("/bookings/getcost/{bookingid}")
	public Integer getCost(@PathVariable String bookingid) {
		
		BookingEntity b = bookingRepo.findById(bookingid).get();
		Integer Cost = b.getCostPerSeat()*b.getNoOfSeats();
		return Cost;
	}
	
	@PostMapping("/savebooking")
	public void saveBooking(@RequestBody BookingEntity bookingEntity) {
		bookingEntity.setAmountPayable(bookingEntity.getCostPerSeat()*bookingEntity.getNoOfSeats());
		bookingRepo.save(bookingEntity);
		
		
	}
}
	