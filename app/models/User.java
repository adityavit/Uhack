package models;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;

import play.db.jpa.Model;

@Entity
public class User extends Model{
	String userName;
	int power;
	int health;	
	User attacker;	
	User attacked;
	
	@ManyToOne
	Location location;
	
	@OneToOne
	Question question;
	
	Clan clan;
	boolean engaged;
	public static enum Clan{
		Vampire, Lycan, Human
	}
	
	
	
	public User(String userName, int power, int health, User attacker,
			User attacked, Location location, Question question, Clan clan,
			boolean engaged) {
		super();
		this.userName = userName;
		this.power = power;
		this.health = health;
		this.attacker = attacker;
		this.attacked = attacked;
		this.location = location;
		this.question = question;
		this.clan = clan;
		this.engaged = engaged;
	}
	
	public Clan getClan() {
		return clan;
	}

	public void setClan(Clan clan) {
		this.clan = clan;
	}

	public boolean isEngaged() {
		return engaged;
	}

	public void setEngaged(boolean engaged) {
		this.engaged = engaged;
	}

	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public int getPower() {
		return power;
	}
	public void setPower(int power) {
		this.power = power;
	}
	public int getHealth() {
		return health;
	}
	public void setHealth(int health) {
		this.health = health;
	}
	public User getAttacker() {
		return attacker;
	}
	public void setAttacker(User attacker) {
		this.attacker = attacker;
	}
	public User getAttacked() {
		return attacked;
	}
	public void setAttacked(User attacked) {
		this.attacked = attacked;
	}
	
	
	public Location getLocation() {
		return location;
	}
	public void setLocation(Location location) {
		this.location = location;
	}
	public Question getQuestion() {
		return question;
	}
	public void setQuestion(Question question) {
		this.question = question;
	}
	
	
}
