package controllers;

import java.util.List;

import play.mvc.Controller;

import manager.ArenaManager;
import manager.UserManager;
import models.User;

public class ArenaController extends Controller {
	
	public static void renderArena(String username){
		User user = UserManager.createUser(username);
		List<User> usersInLocation = ArenaManager.getUsersByLocation(username);
		render(usersInLocation,user);
	}
}
