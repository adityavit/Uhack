package controllers;

import play.*;
import play.mvc.*;

import java.util.*;

import manager.FoursquareManager;
import models.*;

public class Application extends Controller {

    public static void index() {
    	List<Location> ll = FoursquareManager.fetchVenues((float)40.72, (float)-73.99);
        render();
    }

}