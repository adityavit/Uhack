package manager;

import java.util.HashMap;

import javax.persistence.Entity;

import play.db.jpa.Model;

import models.Question;
import models.User;

@Entity
public class ArenaManager extends Model {
	public void challenge(User attacker,User attacked,Question question){
		if(attacker.getPower()>0){
			attacker.setEngaged(true);
			attacked.setEngaged(true);
			attacker.setPower(attacker.getPower()-1);
			attacker.setAttacked(attacked);
			attacked.setAttacker(attacker);
			attacked.setQuestion(question);
		}
	}
	
	public User respond(User user,String answer,boolean correct){
		
		User attacker = user.getAttacker();
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
