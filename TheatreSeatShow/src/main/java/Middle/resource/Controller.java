package Middle.resource;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Optional;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import Middle.model.CompositeId;
import Middle.model.SeatEntity;
import Middle.model.SeatUpdate;
import Middle.model.ShowEntity;
import Middle.model.TheatreEntity;
import Middle.resource.SeatService;
import Middle.resource.ShowService;
import Middle.resource.TheatreService;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
public class Controller {
	
	@Autowired
	SeatService seatRepo;
	
	@Autowired
	TheatreService theatreRepo;
	
	@Autowired
	ShowService showRepo;
	
	/*
	//Mappings
	//Getting all the theatres
	@GetMapping("/theatres")
	public ArrayList<TheatreEntity> getTheatres(){
		ArrayList<TheatreEntity> theatreList = (ArrayList<TheatreEntity>) theatreRepo.findAll();
		return theatreList;
	}*/
	//Getting all the shows
	@GetMapping("/shows")
	public ArrayList<ShowEntity> getShows(){
		ArrayList<ShowEntity> showList = (ArrayList<ShowEntity>) showRepo.findAll();
		return showList;
	}
	/*
	//Getting all the seats
	@GetMapping("/seats")
	public ArrayList<SeatEntity> getSeats(){
		ArrayList<SeatEntity> seatList = (ArrayList<SeatEntity>) seatRepo.findAll();
		return seatList;
	}
	
	//Posting the theatres
	@PostMapping("/theatres")
	public String saveTheatre(@RequestBody TheatreEntity theatreEntity) {
		theatreRepo.save(theatreEntity);
		return "Record Entered";
	}
	@PostMapping("/shows")
	public String saveShow(@RequestBody ShowEntity showEntity) {
		showRepo.save(showEntity);
		return "Record Entered";
	}
	@PostMapping("/seats")
	public String saveSeat(@RequestBody SeatEntity seatEntity) {
		seatRepo.save(seatEntity);
		return "Record Entered";
	}
	
	/*@GetMapping("/displayshows/{city}/{movie}")
	public ArrayList<ShowEntity> displayShows(@PathVariable String city, @PathVariable String movie)
	{
		String theatreId;
		ArrayList<ShowEntity> movieslist = showRepo.findByMovieName(movie);
		ArrayList<ShowEntity> finalList = new ArrayList<ShowEntity>();
		for(ShowEntity s:movieslist)
		{
			theatreId = s.getTheatreId();
			if(theatreRepo.findById(theatreId).get()).getTheatreCity().equals(city)|| theatreRepo.findById(theatreId).get().getTheatreLocation().equals(city))
				finalList.add(s);
			
		}
		return finalList;
	}
	*/
	/*@GetMapping("/displayseats/{theatreid}/seats")
	public ArrayList<SeatEntity> displaySeats(@PathVariable String theatreid){
		ArrayList<SeatEntity> seatList = (ArrayList<SeatEntity>) seatRepo.findAll();
		ArrayList<SeatEntity> finalSeats = new ArrayList<SeatEntity>();
		for(SeatEntity s: seatList) {
			if(s.getCompositeId().getTheatreId().equals(theatreid) && s.getIsOccupied().equals("False"))
				finalSeats.add(s);
				
		}
		return finalSeats;
	}
	
	@GetMapping("/ChangeSeatStatus/{theatreid}/{seatid}")
	public String changeSeatStatus(@PathVariable String theatreid, @PathVariable String seatid) {
		ArrayList<SeatEntity> seats = (ArrayList<SeatEntity>) seatRepo.findAll();
		for(SeatEntity s: seats) {
			if(s.getCompositeId().getTheatreId().equals(theatreid) && s.getCompositeId().getSeatNumber().equals(seatid)) {
				if(s.getIsOccupied().equals("True")) {
					s.setIsOccupied("False");
					seatRepo.save(s);}
				else {
					s.setIsOccupied("True");
					seatRepo.save(s);
		        }
			}
		}
		return "Seat Status Changed";
	}
	*/
	
	@PostMapping("/changeseatstatus")
	public void changeSeatStatus(@RequestBody SeatUpdate seatUpdate) {
		
		ArrayList<SeatEntity> s = new ArrayList<>();
		//employeeRepository.findById(new EmployeeIdentity("E-123", "D-457"));
		List<String> seatList = seatUpdate.getSeatList();
		for(String seatNumber: seatList) {
			
			CompositeId compositeId = new CompositeId(seatNumber, seatUpdate.getTheatreId(), seatUpdate.getShowId());
			SeatEntity seatEntity = seatRepo.findByCompositeId(compositeId);
			seatEntity.setIsOccupied("True");
			seatRepo.save(seatEntity);
	
		}
	}
	
	
	
	
	@GetMapping("/locations")
	public ArrayList<String> getLocations() {
		ArrayList<TheatreEntity> theatreList = (ArrayList<TheatreEntity>) theatreRepo.findAll();
		Set<String> hSet = new HashSet<String>();
		for(TheatreEntity s: theatreList) {
			hSet.add(s.getTheatreCity());
		}
		ArrayList<String> s =new ArrayList<String>();
		s.addAll(hSet);
		
		return s;
	}
	
	
	@GetMapping("/findtheatre/{location}")
	public ArrayList<TheatreEntity> getTheatresInLoc(@PathVariable String location){
		ArrayList<TheatreEntity> theatreList = (ArrayList<TheatreEntity>) theatreRepo.findByTheatreLocation(location);
		ArrayList<TheatreEntity> cityTheatreList = (ArrayList<TheatreEntity>) theatreRepo.findByTheatreCity(location);
		theatreList.addAll(cityTheatreList);
		return theatreList;
	}
	
	
	@GetMapping("/showsintheatre/{theatreid}")
	public ArrayList<ShowEntity> getShowsInTheatre(@PathVariable String theatreid){
		ArrayList<ShowEntity> showList = showRepo.findByTheatreId(theatreid);
		return showList;
	}
	
	@GetMapping("/getseats/{showid}")
	public ArrayList<SeatEntity> getseats(@PathVariable String showid){
		ArrayList<SeatEntity> seatlist = new ArrayList<SeatEntity>();
		ArrayList<SeatEntity> seat = (ArrayList<SeatEntity>) seatRepo.findAll();
		if(!seat.equals(null)) {
			for(SeatEntity ent: seat)
			{
				if(ent.getCompositeId().getShowId().equals(showid)) {
					seatlist.add(ent);
				}
				
			}
		}
		return seatlist;
	}
	@GetMapping("/gettheatreobject/{theatreid}")
	public TheatreEntity getTheatreName(@PathVariable String theatreid) {
		return theatreRepo.findById(theatreid).get();
	}
	
	
	@GetMapping("/getshowobject/{showid}")
	public ShowEntity getShowObject(@PathVariable String showid) {
		return showRepo.findById(showid).get();
	}
	
		
}

