import java.util.Scanner;

//DOIT

public class Application {

	GameEngine gameEngine = new GameEngine();

	private Scanner in;

	private int bonkStartPopulation;
	private int zapStartPopulation;

	private int gridWorldX; // Column
	private int gridWorldY; // Row

	private int maxDayCount;

	private String settingsName;

	private boolean isGridWorldGenerated = false;
	private boolean hasBeingsSpawned = false;

	///////////// MAIN
	public static void main(String[] args) throws CannotActException, InterruptedException {
		// gridWorld.startGame(); //could use this to start
		Application app = new Application();
		app.callMenu();

	}

	public Application() {
		in = new Scanner(System.in);
	}

	public void callMenu() throws CannotActException, InterruptedException {
		String choice;
		System.out.println("***** BONKS AND ZAPS SIMULATION *****");
		System.out.println("*****CS12320 INDIVIDUAL ASSIGNMENT - OWAIN JONES - owj3@aber.ac.uk*****");
		defaultSettings();
		printCurrentSettings();
		do {
			status();
			printMenu();

			choice = in.next().toUpperCase();
			switch (choice) {

			case "1":
				gameEngine.createGridworld(gridWorldX, gridWorldY);
				isGridWorldGenerated = true;
				break;

			case "2":
				System.out.println("Creating " + bonkStartPopulation + " Bonk's and " + zapStartPopulation + " Zap's");
				gameEngine.populateWithBonks(bonkStartPopulation);
				gameEngine.populateWithZaps(zapStartPopulation);
				hasBeingsSpawned = true;
				break;

			case "3":
				gameEngine.setMaxDayCount(maxDayCount);
				gameEngine.startSimulation();
				break;

			case "4":
				changeSettings();
				break;

			case "5":
				resetSimulation();
				break;

			case "6":
				printCurrentSettings();
				break;

			case "7":
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
		System.out.println("\n ===Main Menu=== " + "\n 1	- Create GridWorld " + "\n 2	- Populate with Bonks "
				+ "\n 3	- Start Simulation " + "\n 4	- Change Settings " + "\n 5	- Reset GridWorld to defaults "
				+ "\n 6	- Display current settings " + "\n Q	- Quit" + "\n ===============");

	}

	private void printGridWorld() {
		System.out.println("FOR DEBUG ONLY - PRINTING...");
		if (isGridWorldGenerated == true) {
			System.out.println(gameEngine.gridWorld.toString());
		} else {
			System.err.println("ERROR! GridWorld has not been created!"
					+ "\n Please select option '1' on the menu to create a GridWorld ");
		}
	}

	private void status() {
		System.out.print("\n" + "GridWorld = ");
		if (isGridWorldGenerated == true) {
			System.out.print(" Generated ");
		} else {
			System.out.print(" Not Generated ");
		}

		System.out.print("	Beings = ");
		if (hasBeingsSpawned == true) {
			System.out.println(" Created ");
		} else {
			System.out.println(" Not Created ");
		}
	}

	private void defaultSettings() {
		bonkStartPopulation = 20;
		zapStartPopulation = 5;
		gridWorldX = 5; // Column
		gridWorldY = 5; // Row
		maxDayCount = 20;
		settingsName = "Default";
	}

	private void changeSettings() {
		System.out.println("===Edit Settings===");
		System.out.println("Please type Grid World X (column) value: ");
		gridWorldX = in.nextInt(); // Column
		System.out.println("Please type Grid World Y (row) value: ");
		gridWorldY = in.nextInt(); // Row
		System.out.println("Please type the simulation length (in days): ");
		maxDayCount = in.nextInt();
		System.out.println("Please type the Bonk's starting population: ");
		bonkStartPopulation = in.nextInt();
		System.out.println("Please type the Zap's starting population: ");
		zapStartPopulation = in.nextInt();
		settingsName = "Custom";
		System.out.println("===Custom Settings Accepted===");
	}

	private void printCurrentSettings() {
		System.out.println("\n" + "Current Settings: " + settingsName + "\n" + "GridWorld Size: [" + gridWorldX + ", "
				+ gridWorldY + "]" + "\n" + "Bonks start population: " + bonkStartPopulation + "\n"
				+ "Zap start population: " + zapStartPopulation + "\n" + "GridWorld day count: " + maxDayCount);
	}

	private void resetSimulation() {
		defaultSettings();
		System.out.println("===Default settings loaded===");
		printCurrentSettings();
		gameEngine.createGridworld(gridWorldX, gridWorldY);
		hasBeingsSpawned = false;
		isGridWorldGenerated = false;
	}

	private void exitProgram() {
		System.out.println("*** THANK YOU FOR USING BONKS AND ZAPS ***");
	}

}
