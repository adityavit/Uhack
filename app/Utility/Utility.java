package Utility;

import java.util.Random;

public class Utility {

	public static int getRandomNumber(int range){
		int randomInt = 0;
		Random randomGenerator = new Random();
	    for (int idx = 1; idx <= 10; ++idx){
	      randomInt = randomGenerator.nextInt(range);      
	    }
	    return randomInt;
	}
}
