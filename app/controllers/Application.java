package controllers;

import play.*;
import play.db.DB;
import play.mvc.*;

import java.util.*;

import manager.UserManager;
import models.*;

public class Application extends Controller {

    public static void index() {
    	UserManager userManager = new UserManager();      
    	User user =  userManager.getFirstUser();
        System.out.println("User:"+user.getUserName());
       
        userManager.checkIn(user,null);
        //System.out.println("after:"+user.getUserName()+":"+user.getLocation().getName());
        render();
        //System.out.println("Connection ---: "+DB.getConnection());
        
    }

}