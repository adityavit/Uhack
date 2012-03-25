package Utility;

import java.util.List;

import play.jobs.*;
import play.test.*;
import models.*;

@OnApplicationStart
public class BootStrap extends Job {
    
    public void doJob() {
    	System.out.println("Loading All Questions...");
		if(Question.count() == 0) {
			Fixtures.load("initial-data.yml");
		}
		List<Question> questions = Question.all().fetch();
		System.out.println("questions:"+questions);
	
    }
    
}
