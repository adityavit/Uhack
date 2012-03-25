package controllers;

import play.*;
import play.db.DB;
import play.mvc.*;

import java.util.*;

import manager.LocationManager;
import manager.UserManager;
import models.*;

public class AjaxController extends Controller {

    public static void getUserData(String userName) {
    	User user = UserManager.getUser(userName);
    	List<User> usersAtLocation = UserManager.getUsersByLocation(user);
    	Map userMap  = new HashMap();
    	userMap.put("user",getUserMap(user));
    	if(user.getAttacker() != (long)-1){
    		userMap.put("enemy",getUserMap(UserManager.getUserById(user.getAttacker())));
    	}
    	List checkedUsers = new ArrayList();
    	for(User userAtLocation : usersAtLocation){
    		checkedUsers.add(getUserMap(userAtLocation));
    	}
    	userMap.put("checkinUsers",checkedUsers);
        renderJSON(userMap);
    }
    
    public static Map getUserMap(User user){
    	Map userObj = new HashMap();
    	System.out.println("*************************user in getUserMap:"+user);
    	userObj.put("id",user.getId());
    	if(user.isEngaged() != false){
    	userObj.put("engaged", user.isEngaged());
    	}
    	userObj.put("power", user.getPower());
    	userObj.put("health", user.getHealth());
    	userObj.put("clan", user.getClan());
    	userObj.put("userName", user.getUserName());
    	if(user.getQuestion() != null){
    	userObj.put("question", user.getQuestion().getQuestion());
    	userObj.put("answer", user.getQuestion().getAnswer());
    	}
    	return userObj;
    }
}