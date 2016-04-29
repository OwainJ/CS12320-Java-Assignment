import java.util.Random;


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
}
