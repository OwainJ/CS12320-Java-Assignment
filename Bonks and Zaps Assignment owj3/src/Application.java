import java.util.Scanner;

/**
 * Controls the menu system, settings and the initiation of the game and GameEngine.
 * 
 * @author Owain Jones
 * @version 1.0
 *
 */
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

	/**
	 * The main method that runs first and creates a new Application object.
	 * It then calls the main menu.
	 * 
	 * @param args
	 * @throws CannotActException
	 * @throws InterruptedException
	 */
	public static void main(String[] args) throws CannotActException, InterruptedException {
		// gridWorld.startGame(); //could use this to start
		Application app = new Application();
		app.callMenu();

	}

	/**
	 * Constructor for Application that creates a new Scanner.
	 */
	public Application() {
		in = new Scanner(System.in);
	}

	/**
	 * This method controls the main menu by running printMenu() to print the main menu
	 * and then waiting for the user to input their choice and acting on that choice.
	 * It also sets the game to it's default settings and prints the default settings
	 * when it is first run.
	 * Also runs status();
	 * 
	 * @throws CannotActException
	 * @throws InterruptedException
	 */
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
				createGridWorld();
				break;

			case "2":
				startGridWorld();
				break;

			case "3":
				changeSettings();
				break;

			case "4":
				resetSimulation();
				break;

			case "5":
				printCurrentSettings();
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

	/**
	 * Prints out the menu to the screen
	 * 
	 */
	public void printMenu() {
		System.out.println("\n ===Main Menu=== " 
				+ "\n 1	- Generate GridWorld "
				+ "\n 2	- Start Simulation " 
				+ "\n 3	- Change Settings " 
				+ "\n 4	- Reset GridWorld to defaults "
				+ "\n 5	- Display current settings " 
				+ "\n Q	- Quit" + "\n ===============");
	}
	
	/**
	 * Creates a new GridWorld with the chosen X and Y and populates it with the chosen
	 * amount of Bonk(s) and Zap(s) by calling the appropriate methods in the GameEngine.
	 * Also sets isGridWorldGenerated and hasBeingsSpawned to true to indicate that they
	 * have been created.
	 */
	private void createGridWorld() {
		gameEngine.createGridworld(gridWorldX, gridWorldY);
		isGridWorldGenerated = true;
		
		System.out.println("Creating " + bonkStartPopulation + " Bonk's and " + zapStartPopulation + " Zap's");
		gameEngine.populateWithBonks(bonkStartPopulation);
		gameEngine.populateWithZaps(zapStartPopulation);
		hasBeingsSpawned = true;
	}
	
	/**
	 * This starts the simulation by setting the maximum day count in GameEngine
	 * and then calling the startSimulation() method in GameEngine.
	 * It throws an error message if GridWorld hasn't been created yet.
	 * 
	 * @throws CannotActException
	 * @throws InterruptedException
	 */
	private void startGridWorld() throws CannotActException, InterruptedException {
		if (isGridWorldGenerated == true && hasBeingsSpawned == true) {
		gameEngine.setMaxDayCount(maxDayCount);
		gameEngine.startSimulation();
		} else {
			System.err.println("ERROR - GridWorld and/or Beings have not been created.");
			return;
		}
	}

	/**
	 * This method is primarily used for debugging and is therefore not listed on the menu, but can
	 * be accessed by typing "6".
	 * It prints out toString for GridWorld which shows the entire state of GridWorld and the toStrings of
	 * all of it's inhabitants. (quite messy but useful for debugging).
	 */
	private void printGridWorld() {
		System.out.println("FOR DEBUG ONLY - PRINTING...");
		if (isGridWorldGenerated == true) {
			System.out.println(gameEngine.gridWorld.toString());
		} else {
			System.err.println("ERROR! GridWorld has not been created!"
					+ "\n Please select option '1' on the menu to create a GridWorld ");
		}
	}

	/**
	 * Prints out a status showing whether or not GridWorld has been generated
	 * and whether or not beings have been added to GridWorld.
	 * Used as an aid to the user, so they know whether GridWorld has been created 
	 * and populated.
	 */
	private void status() {
		System.out.print("\n" + "GridWorld = ");
		if (isGridWorldGenerated == true) {
			System.out.print(" Generated ");
		} else {
			System.out.print(" Not Generated ");
		}

		System.out.print("	Beings = ");
		if (hasBeingsSpawned == true) {
			System.out.print(" Generated ");
		} else {
			System.out.print(" Not Generated ");
		}
	}

	/**
	 * Sets the game to it's default settings. Which are:
	 * "bonkStartPopulation = 20;"
	 * "zapStartPopulation = 5;"
	 * "gridWorldX = 5;"
	 * "gridWorldY = 5;"
	 * "maxDayCount = 20;"
	 * "settingsName = "Default";"
	 */
	private void defaultSettings() {
		bonkStartPopulation = 20;
		zapStartPopulation = 5;
		gridWorldX = 5; // Column
		gridWorldY = 5; // Row
		maxDayCount = 20;
		settingsName = "Default";
	}

	/**
	 * This method allows the user to change the settings of the game.
	 * It set's the GridWorld maximum X and Y sizes, the Bonk and Zap start populations,
	 * and also the simulation length in days/cycles
	 */
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

	/**
	 * This prints out the current settings.
	 * Prints the current max X and Y of GridWorld, the Bonk and Zap start populations,
	 * and also the simulation length in days/cycles
	 */
	private void printCurrentSettings() {
		System.out.println("\n" + "Current Settings: " + settingsName + "\n" + "GridWorld Size: [" + gridWorldX + ", "
				+ gridWorldY + "]" + "\n" + "Bonks start population: " + bonkStartPopulation + "\n"
				+ "Zap start population: " + zapStartPopulation + "\n" + "GridWorld day count: " + maxDayCount);
	}

	/**
	 * This resets the game to it's default settings by loading the defaults and resetting
	 * GridWorld.
	 */
	private void resetSimulation() {
		defaultSettings();
		System.out.println("===Default settings loaded===");
		printCurrentSettings();
		gameEngine.createGridworld(gridWorldX, gridWorldY);
		hasBeingsSpawned = false;
		isGridWorldGenerated = false;
	}

	/**
	 * This method exit's the program.
	 */
	private void exitProgram() {
		System.out.println("*** THANK YOU FOR USING BONKS AND ZAPS ***");
	}

}
