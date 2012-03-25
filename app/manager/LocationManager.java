package manager;

import java.util.List;

import javax.persistence.Entity;

import models.Location;

import play.db.jpa.Model;

public class LocationManager{
	
	public static List<Location> fetchVenues(float latitude, float longitude){
	    List<Location> locations = FoursquareManager.fetchVenues(latitude, longitude);
	    return locations;		
	}
}
