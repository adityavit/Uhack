package manager;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

import play.*;
import play.jobs.*;
import play.test.*;
import models.*;
public class FoursquareManager {
	
	private static String fourSquareApi = "https://api.foursquare.com/v2/venues/explore?client_secret=JSV2M2W2RCLQARXVUPSURVSF2YFD3RWDNDN5C5NLBYFGJ2RU&client_id=BROS2FQB5KZIAAYBLXY5VMSMGJWZGBUC3NB02JFYB4P4TD4D&v=20120324&&limit=5&llAcc=50.0&ll=";

	
	public static List<Location> fetchVenues(float latitute,float longitude){
		JsonElement jse = null;
		String fourSquareUrl = fourSquareApi + latitute +","+longitude;
		List<Location> userLocations = null;
		try{
			URL source = new URL(fourSquareUrl);
			BufferedReader in = new BufferedReader(
					new InputStreamReader(source.openStream(), "UTF-8"));
			jse = new JsonParser().parse(in);
			in.close();
			JsonObject responseObject = jse.getAsJsonObject();
			JsonObject metaObj = (JsonObject) responseObject.get("meta");
			String responseCode = metaObj.get("code").getAsString();
			if(responseCode.equals("200")){
				JsonObject response = (JsonObject) responseObject.get("response");
				if(response != null){
					JsonArray groups = response.getAsJsonArray("groups");
					userLocations = new ArrayList();
					for(JsonElement group: groups){
						JsonArray items = group.getAsJsonObject().getAsJsonArray("items");
						for(JsonElement item : items){
							JsonObject venue = item.getAsJsonObject().getAsJsonObject("venue");
							String venueName = venue.get("name").getAsString();
							Location location = new Location(venueName,latitute,longitude);
							userLocations.add(location);
							System.out.println(venueName);
						}
					}
				}else{
					System.out.println("FourSquare Venue API gave error=" + "Empty Response");
				}
				
			}else{
				System.out.println("FourSquare Venue API gave error=" + metaObj.get("errorDetail").getAsString());
			}
			
		}catch (Exception e) {
			System.out.println("FourSquare Venue API gave error=" + e);
		}
		
		return userLocations;
	}
}
