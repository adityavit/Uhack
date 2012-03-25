package manager;
import java.util.List;
import java.util.Random;

import javax.persistence.Entity;
import javax.persistence.Query;

import Utility.Utility;

import play.*;
import play.db.jpa.JPA;
import play.db.jpa.Model;
import play.jobs.*;
import play.test.*;
import models.*;

public class UserManager{	
	
	public User getFirstUser(){
		if(User.count() == 0) {
			Fixtures.load("dependencies.yml");
		}
		System.out.println("User count:"+User.count());
		User user = User.all().first();
		return user;
	}
	
	public static User createUser(String userName,Long location){
		User user = User.find("byUserName", userName).first();
		if(user == null){
		User.Clan clan = getClan();
		Location userLocation = LocationManager.getLocation(location);
		user = new User(userName, 10, 100, null, null, userLocation, null,clan, false);
		user.save();
		}else{
			Location userLocation = LocationManager.getLocation(location);
			user.setLocation(userLocation);
			user.save();
		}
		return user;
	}
	public static User.Clan getClan(){
		Random randomGenerator = new Random();
		int randomInt = Utility.getRandomNumber(User.Clan.values().length);
	    return User.Clan.values()[randomInt];
	}
	
	public static User getUser(String userName){		
		User user = User.find("byUserName",userName).first();
		return user;
	}
	
	public static List<User> getUsersByLocation(User user){		
		List<User> users = User.find("byLocation", user.getLocation()).fetch();
		users.remove(user);
		return users;
	}
	
	public void checkIn(User user,Location location){			
		user.setLocation(location);
	}
	
	public List<User> getVictims(User user){	
		List<User> victims = User.find("byAttacker", user).fetch();
		System.out.println("Victims:"+victims);
		return victims;
	}
	
	
}
