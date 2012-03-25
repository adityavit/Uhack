package controllers;

import play.*;
import play.db.DB;
import play.mvc.*;

import java.util.*;

import manager.LocationManager;
import models.*;

public class Application extends Controller {

    public static void index() {
        render();
    }
    
    public static void renderVenues(String username,float latitude, float longitude){
    	 
    	List<Location> locations = LocationManager.fetchVenues(latitude, longitude);
    	render(locations,username);
    }

}
