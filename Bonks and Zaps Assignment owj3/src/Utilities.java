import java.util.Random;

/**
 * This Utilities class contains frequently used methods that are used by
 * numerous different other classes.
 * 
 * @author Son of Darren
 * @version 1.0
 * 
 */
public final class Utilities {
	
	/**
	 * This method returns a random integer between 0 and 'r'.
	 * Where 'r' must be an integer that's greater than 0.
	 * 
	 * @param r
	 * @return
	 */
	public static int randomInt(int r) {
		Random rand = new Random();
		int a = rand.nextInt(r);
		return a;
	}
	
	/**
	 * This method returns a random Gender that is either Male or Female.
	 * It uses the randomInt method in Utilities to chose a random gender.
	 * 
	 * @return returns either MALE or FEMALE or an error message (null) if there is a problem
	 * with the randomInt.
	 */
	public static Gender randomGender() {
		int choice;
		choice = Utilities.randomInt(2);

		switch (choice) {
		case 0:
			Gender gen = Gender.MALE;
			return gen;

		case 1:
			Gender gen2 = Gender.FEMALE;
			return gen2;

		default:
			System.err
					.println("ERROR on randomGender() method of GameEngine class");
			return null;
		}
	}
}
