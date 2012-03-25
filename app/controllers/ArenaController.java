package controllers;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import play.mvc.Controller;

import manager.ArenaManager;

import manager.QuestionManager;
import models.Question;
import manager.UserManager;
import models.User;

public class ArenaController extends Controller {
	
	public static void renderArena(String username,String location){
		User user = UserManager.createUser(username, Long.valueOf(location));
		List<User> usersInLocation = ArenaManager.getUsersByLocation(user);
		render(usersInLocation,user);
	}
	
	public static void getQuestion(Long userId,Long victimId){
		Question question = QuestionManager.getQuestion();
		User attackerUser = UserManager.getUserById(userId);
		User victimUser = UserManager.getUserById(victimId);
		ArenaManager.challenge(attackerUser, victimUser, question);
		renderJSON(getQuestionMap(question));
	}
	
	public static Map getQuestionMap(Question question){
		Map questionMap = new HashMap();
		questionMap.put("question", question.getQuestion());
		questionMap.put("answer", question.getAnswer());
		return questionMap;
	}
}
