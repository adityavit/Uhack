package models;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;

import play.db.jpa.Model;

@Entity
public class Location extends Model{
	String name;
	float latitude;
	float longitude;
	String fourSquareId;
	
	@OneToMany(mappedBy="location",cascade = CascadeType.ALL)    
	List<User> users;
		
	public Location(String name, float latitude, float longitude,
			String fourSquareId) {
		super();
		this.name = name;
		this.latitude = latitude;
		this.longitude = longitude;
		this.fourSquareId = fourSquareId;
	}
		
	public List<User> getUsers() {
		return users;
	}

	public void setUsers(List<User> users) {
		this.users = users;
	}

	public String getFourSquareId() {
		return fourSquareId;
	}


	public void setFourSquareId(String fourSquareId) {
		this.fourSquareId = fourSquareId;
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
	public String toString(){
		return this.name;
	}
}
