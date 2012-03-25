package controllers;

import java.util.List;

import play.mvc.Controller;

import manager.ArenaManager;
import manager.UserManager;
import models.User;

public class ArenaController extends Controller {
	
	public static void renderArena(String username,String location){
		User user = UserManager.createUser(username, Long.valueOf(location));
		List<User> usersInLocation = ArenaManager.getUsersByLocation(user);
		render(usersInLocation,user);
	}
}
