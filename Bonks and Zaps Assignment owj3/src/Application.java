
public class Application {
	Bonk bonk = null;
	Zap zap = null;
	int gridWorldX = 20;
	int gridWorldY = 20;
	
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
		System.out.println("\n ===Main Menu=== "
				+ "\n 1	- Create GridWorld 		//Not yet implemented  "
				+ "\n 2	- Populate with Bonks 		//Not yet implemented  "
				+ "\n 3	- Populate with Zaps 		//Not yet implemented "
				+ "\n 4	- Start Simulation 		//Not yet implemented "
				+ "\n 5	- Clear GridWorld 		//Not yet implemented "
				+ "\n 6	- Quit 				//Not yet implemented "
				+ "\n ===============");
		
	}

	private static void createGridWorld(int i, int j) {
		GridWorld gridWorld = new GridWorld(i, j);
		
	}
	
	private static void populateWithBonks(int bonkStartPop) {
		int counter = bonkStartPop;
		
		while(counter >= 0){
			Bonk nameGen = new Bonk();
		}
		
		
	}
	
	private static void populateWithZaps(int zapStartPop) {
		
	}

}
