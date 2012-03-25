package manager;
import java.util.List;
import java.util.Random;

import javax.persistence.Entity;
import javax.persistence.Query;

import play.*;
import play.db.jpa.JPA;
import play.db.jpa.Model;
import play.jobs.*;
import play.test.*;
import models.*;



@Entity
public class UserManager extends Model{	
	
	public User getFirstUser(){
		if(User.count() == 0) {
			Fixtures.load("dependencies.yml");
		}
		System.out.println("User count:"+User.count());
		User user = User.all().first();
		return user;
	}
	public static User createUser(String userName){
		User.Clan clan = getClan();
		User user = new User(userName, 10, 100, null, null, null, null,clan, false);
		user.save();
		return user;
	}
	public static User.Clan getClan(){
		Random randomGenerator = new Random();
		int randomInt = 0;
	    for (int idx = 1; idx <= 10; ++idx){
	      randomInt = randomGenerator.nextInt(3);	      
	    }
	    return User.Clan.values()[randomInt];
	}
	public static User getUser(String userName){		
		
		User user = User.find("byUserName",userName).first();
		if(user==null){
			user = createUser(userName);
			user.save();
		}
		return user;
	}
	
	public static List<User> getUsersByLocation(Location location){		
		List<User> users = User.find("byLocation", location).fetch();
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
