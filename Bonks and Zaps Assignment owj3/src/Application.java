import java.util.Scanner;

public class Application {

	private Scanner in;

	Bonk bonk = null;
	Zap zap = null;
	GridWorld gridWorld = null;

	int bonkStartPopulation = 20;
	int zapStartPopulation = 20;

	int gridWorldX = 20;
	int gridWorldY = 20;

	///////////// MAIN
	public static void main(String[] args) {
		// gridWorld.startGame(); //could use this to start
		Application app = new Application();
		app.callMenu();

	}

	public Application() {
		in = new Scanner(System.in);
	}

	public void callMenu() {
		String choice;
		System.out.println("***** BONKS AND ZAPS *****");
		do {
			printMenu();

			choice = in.next().toUpperCase();
			switch (choice) {

			case "1":
				gridWorld = createGridWorld(20, 20);
				break;

			case "2":
				populateWithBonks(bonkStartPopulation);
				break;

			case "3":
				System.err.println("==Not yet implemented ==");
				break;

			case "4":
				System.err.println("==Not yet implemented ==");
				break;

			case "5":
				System.err.println("==Not yet implemented ==");
				break;
				
			case "6":
				printGridWorld();
				break;

			case "Q":
				exitProgram();
				break;
				
				default:
					System.err.println("==Not a valid choice==");
			}
		} while (!choice.equals("Q"));
	}

	public void printMenu() {
		// TODO Auto-generated method stub
		System.out.println("\n ===Main Menu=== " 
				+ "\n 1	- Create GridWorld 	//Not yet implemented fully  "
				+ "\n 2	- Populate with Bonks 	//Not yet implemented fully  "
				+ "\n 3	- Populate with Zaps 	//Not yet implemented "
				+ "\n 4	- Start Simulation 	//Not yet implemented "
				+ "\n 5	- Clear GridWorld 	//Not yet implemented "
				+ "\n 6	- Print GridWorld 	==DEBUGGING=="
				+ "\n Q	- Quit" 
				+ "\n ===============");

	}

	private GridWorld createGridWorld(int i, int j) {
		System.out.println("CHOICE 1");
		GridWorld newGridWorld = new GridWorld(i, j);
		return newGridWorld;

	}

	private void populateWithBonks(int bonkStartPop) {
		
		if (gridWorld != null) {
			
		int counter = bonkStartPop;
		int nameCount = 0;
		String nameGen = "Test";

		while (counter >= 0) {
			nameGen = "B" + nameCount;
			Bonk bonk = new Bonk(nameGen);
			nameCount++;
			counter--;
			
			gridWorld.addBonk(bonk);
			System.out.print("Created Bonk: ");
			System.out.print(bonk.getName());
			System.out.println(" At location: ");
		}
		return;
		}
		System.err.println("ERROR! GridWorld has not been created!" 
				+ "\n Please select option '1' on the menu to create a GridWorld ");

	}

	private void populateWithZaps(int zapStartPop) {
		
	}
	
	private void printGridWorld(){
		System.out.println("CHOICE 6 - PRINTING...");
		System.out.println(gridWorld.toString());
		
	}
	
	private void exitProgram() {
		System.out.println("*** THANK YOU FOR USING BONKS AND ZAPS ***");
	}

}
