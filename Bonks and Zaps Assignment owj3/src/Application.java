import java.util.Scanner;

//DOIT

public class Application {
	
	GameEngine gameEngine = new GameEngine();

	private Scanner in;

	int bonkStartPopulation = 20;
	int zapStartPopulation = 20;

	int gridWorldX = 5; //Column
	int gridWorldY = 5; //Row
	
	int maxDayCount = 20;

	///////////// MAIN
	public static void main(String[] args) throws CannotActException, InterruptedException  {
		// gridWorld.startGame(); //could use this to start
		Application app = new Application();
		app.callMenu();

	}

	public Application() {
		in = new Scanner(System.in);
	}

	public void callMenu() throws CannotActException, InterruptedException  {
		String choice;
		System.out.println("***** BONKS AND ZAPS *****");
		do {
			printMenu();

			choice = in.next().toUpperCase();
			switch (choice) {

			case "1":
				gameEngine.createGridworld(gridWorldX, gridWorldY);
				break;

			case "2":
				gameEngine.populateWithBonks(bonkStartPopulation);
				break;

			case "3":
				System.err.println("==Not yet implemented ==");
				break;

			case "4":
				gameEngine.setMaxDayCount(maxDayCount);
				gameEngine.startSimulation();
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
				+ "\n 1	- Create GridWorld 	//Partially implemented  "
				+ "\n 2	- Populate with Bonks 	//Partially implemented "
				+ "\n 3	- Populate with Zaps 	//Not yet implemented "
				+ "\n 4	- Start Simulation 	//Partially implemented "
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
