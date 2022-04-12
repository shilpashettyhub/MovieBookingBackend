package Middle.model;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class SeatEntity {
	
	@EmbeddedId
	private CompositeId compositeId;
	private String isOccupied;
	public SeatEntity() {
		super();
	}
	public SeatEntity(CompositeId compositeId, String isOccupied) {
		super();
		this.compositeId = compositeId;
		this.isOccupied = isOccupied;
	}
	public CompositeId getCompositeId() {
		return compositeId;
	}
	public void setCompositeId(CompositeId compositeId) {
		this.compositeId = compositeId;
	}
	public String getIsOccupied() {
		return isOccupied;
	}
	public void setIsOccupied(String isOccupied) {
		this.isOccupied = isOccupied;
	}
	
	

}
