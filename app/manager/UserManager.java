package manager;
import java.util.List;

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
		
	
	public void checkIn(User user,Location location){			
		user.setLocation(location);
	}
	
	public List<User> getVictims(User user){	
		List<User> victims = User.find("byAttacker", user).fetch();
		System.out.println("Victims:"+victims);
		return victims;
	}
	
	
}
