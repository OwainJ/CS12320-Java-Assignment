
public class Application {
	
	public static void main(String[] args) {
		//gridWorld.startGame(); //could use this to start
		callMenu();
		
	}

	private static void callMenu() {
		printMenu();
		createGridWorld(20, 20);
	}

	private static void printMenu() {
		// TODO Auto-generated method stub
		
	}

	private static void createGridWorld(int i, int j) {
		GridWorld gridWorld = new GridWorld(i, j);
		
	}
	
	private static void populateWithBonks(int bonkStartPop) {
		
	}
	
	private static void populateWithZaps(int zapStartPop) {
		
	}

}
