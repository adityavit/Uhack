package manager;

import java.util.HashMap;
import java.util.List;

import javax.persistence.Entity;

import play.db.jpa.Model;

import models.Question;
import models.User;

public class ArenaManager{
	
	public static List<User> getUsersByLocation(User user){
		List<User> users = UserManager.getUsersByLocation(user);
		return users;
	}
	
	public static void challenge(User attacker,User attacked,Question question){
		if(attacker.getPower()>0){
			attacker.setEngaged(true);
			attacked.setEngaged(true);
			attacker.setPower(attacker.getPower()-1);
			//attacker.setAttacked(attacked.getId());
			attacked.setAttacker(attacker.getId());
			attacked.setQuestion(question);
			//attacked.refresh();
			//attacker.refresh();
			//System.out.println("before attacker="+attacker);
			//System.out.println("before  attacked="+attacked);
			attacker.save();
			attacked.save();
			//System.out.println("attacker="+attacker);
			//System.out.println("attacked="+attacked);
			
		}
	}
	
	public static User respond(User user,String answer,boolean correct){
		
		User attacker = UserManager.getUserById(user.getAttacker());
		user.setEngaged(false);
		user.setQuestion(null);
		
		if(!correct){
			user.setHealth(user.getHealth()-1);
			attacker.setPower(attacker.getPower()+2);
			if(user.getHealth()==0){
				user.setClan(attacker.getClan());
			}
		}
		user.setAttacker(null);
		return user;
	}		
	
}
