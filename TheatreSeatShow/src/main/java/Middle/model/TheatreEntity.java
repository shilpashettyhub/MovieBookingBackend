package Middle.model;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class TheatreEntity {
	@Id
	private String theatreId;
	private String theatreName;
	private String theatreLocation;
	private String theatreCity;
	public TheatreEntity() {
		super();
	}
	public TheatreEntity(String theatreId, String theatreName, String location, String city) {
		super();
		this.theatreId = theatreId;
		this.theatreName = theatreName;
		this.theatreLocation = location;
		this.theatreCity= city;
	}
	public String getTheatreId() {
		return theatreId;
	}
	public void setTheatreId(String theatreId) {
		this.theatreId = theatreId;
	}
	public String getTheatreName() {
		return theatreName;
	}
	public void setTheatreName(String theatreName) {
		this.theatreName = theatreName;
	}
	public String getTheatreLocation() {
		return theatreLocation;
	}
	public void setTheatreLocation(String location) {
		this.theatreLocation = location;
	}
	public String getTheatreCity() {
		return theatreCity;
	}
	public void setTheatreCity(String city) {
	}
	
	

}
