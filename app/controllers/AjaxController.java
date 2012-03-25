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
    	if(user.getAttacker() != null){
    		userMap.put("enemy",getUserMap(user.getAttacker()));
    	}
    	if(user.getAttacked() != null){
    		userMap.put("victim",getUserMap(user.getAttacker()));
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
    	userObj.put("id",user.getId());
    	userObj.put("engaged", user.isEngaged());
    	userObj.put("power", user.getPower());
    	userObj.put("health", user.getHealth());
    	userObj.put("clan", user.getClan());
    	userObj.put("userName", user.getUserName());
    	return userObj;
    }
}