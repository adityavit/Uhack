package manager;
import play.*;
import play.jobs.*;
import play.test.*;
import models.*;
public class UserManager {

	public void doJob() {
		// Check if the database is empty
		if(User.count() == 0) {
			Fixtures.load("model.yml");
		}
	}

}
