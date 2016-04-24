import java.util.Scanner;

//DOIT

public class Application {
	
	GameEngine gameEngine = new GameEngine();

	private Scanner in;

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
				gameEngine.createGridworld(20, 20);
				break;

			case "2":
				gameEngine.populateWithBonks(bonkStartPopulation);
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
	
	private void printGridWorld(){
		System.out.println("CHOICE 6 - PRINTING...");
		System.out.println(gameEngine.gridWorld.toString());
		
	}
	
	private void exitProgram() {
		System.out.println("*** THANK YOU FOR USING BONKS AND ZAPS ***");
	}

}
