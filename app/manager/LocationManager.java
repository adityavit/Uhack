package manager;

import java.util.List;

import javax.persistence.Entity;

import models.Location;

import play.db.jpa.Model;

@Entity
public class LocationManager extends Model{
	public List<Location> fetchVenues(Location location){
	    List<Location> locations = null;
	    return locations;		
	}
}
