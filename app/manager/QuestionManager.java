package manager;

import java.util.List;

import models.Question;
import Utility.Utility;

public class QuestionManager {
	public static Question getQuestion(){
		int randomInt = Utility.getRandomNumber((int)Question.count());
		List<Question> questions = Question.all().fetch();
		return questions.get(randomInt);
	}
}
