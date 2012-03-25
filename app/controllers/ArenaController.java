package controllers;

import java.util.List;

import play.mvc.Controller;

import manager.ArenaManager;
import models.User;

public class ArenaController extends Controller {
	public static void renderArena(String userName){
		List<User> usersInLocation = ArenaManager.getUsersByLocation(userName);		
		render(usersInLocation);
	}
}
