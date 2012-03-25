package models;

import javax.persistence.Entity;

import play.db.jpa.Model;

@Entity
public class Location extends Model{
	String name;
	float latitude;
	float longitude;
	
	

	public Location(String name, float latitude, float longitude) {
		super();
		this.name = name;
		this.latitude = latitude;
		this.longitude = longitude;
	}

	public double getLatitude() {
		return latitude;
	}

	public void setLatitude(float latitude) {
		this.latitude = latitude;
	}

	public double getLongitude() {
		return longitude;
	}

	public void setLongitude(float longitude) {
		this.longitude = longitude;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
}
