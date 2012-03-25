package controllers;

import java.util.List;

import play.mvc.Controller;

import manager.ArenaManager;
import manager.QuestionManager;
import models.Question;
import models.User;

public class ArenaController extends Controller {
	public static void renderArena(String userName){
		List<User> usersInLocation = ArenaManager.getUsersByLocation(userName);		
		render(usersInLocation);
	}
	
	public static void getQuestion(){
		Question question = QuestionManager.getQuestion();
		renderJSON(question);
	}
}
