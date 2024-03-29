package uk.ac.aber.owj3.BonksandZaps;
import java.util.Scanner;

import javafx.application.Platform;
import uk.ac.aber.owj3.BonksandZaps.utilities.CannotActException;

/**
 * Controls the menu system, settings and the initiation of the game and GameEngine.
 * 
 * @author Owain Jones
 * @version 1.0
 *
 */
public class GameApplication {
	
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

	/**
	 * Constructor for Application that creates a new Scanner.
	 */
	public GameApplication() {
		in = new Scanner(System.in);
		defaultSettings();
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
		System.out.println("====================================================================================================");
		System.out.println("__________               __                _____              .___ __________                    "
						+"\n\\______   \\ ____   ____ |  | __  ______   /  _  \\   ____    __| _/ \\____    /____  ______  ______"
						+"\n |    |  _//  _ \\ /    \\|  |/ / /  ___/  /  /_\\  \\ /    \\  / __ |    /     /\\__  \\ \\____ \\/  ___/"
						+"\n |    |   (  <_> )   |  \\    <  \\___ \\  /    |    \\   |  \\/ /_/ |   /     /_ / __ \\|  |_> >___ \\" 
						+"\n |______  /\\____/|___|  /__|_ \\/____  > \\____|__  /___|  /\\____ |  /_______ (____  /   __/____  >"
							   +"\n        \\/            \\/     \\/     \\/          \\/     \\/      \\/          \\/    \\/|__|       \\/"
						+"\n ");
		System.out.println("		CS12320 INDIVIDUAL ASSIGNMENT - OWAIN JONES - owj3@aber.ac.uk");
		System.out.println("====================================================================================================");
		defaultSettings();
		printCurrentSettings();
		do {
			status();
			printMenu();

			choice = in.next().toUpperCase();
			switch (choice) {

			case "1":
				startGridWorld();
				break;

			case "2":
				createGridWorld();
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
	 * This method is used by the GUI. When a GUI menu button is pressed it passes an int to this
	 * method which then activates the corresponding option.
	 * 
	 * @param choice
	 * @throws CannotActException
	 * @throws InterruptedException
	 */
	public void guiMenuSelector(String choice) throws CannotActException, InterruptedException {
			switch (choice) {
			case "1":
				createGridWorld();
				return;
			case "2":
				try {
					startGridWorld();
				} catch (CannotActException | InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				return;
			case "3":
				changeSettings();
				return;
			case "4":
				resetSimulation();
				return;
			case "5":
				printCurrentSettings();
				return;
			case "6":
				printGridWorld();
				return;
			case "Q":
				exitProgram();
				return;
			default:
				System.err.println("==Not a valid choice==");
			}  while (!choice.equals("Q"));
	}

	/**
	 * Prints out the menu to the screen
	 * 
	 */
	public void printMenu() {
		System.out.println("==========================================================");
		System.out.println(     " ___  ___      _        ___  ___                 "
							+ "\n |  \\/  |     (_)       |  \\/  |"                 
							+ "\n | .  . | __ _ _ _ __   | .  . | ___ _ __  _   _" 
							+ "\n | |\\/| |/ _` | | '_ \\  | |\\/| |/ _ \\ '_ \\| | | |"
							+ "\n | |  | | (_| | | | | | | |  | |  __/ | | | |_| |"
							+ "\n \\_|  |_/\\__,_|_|_| |_| \\_|  |_/\\___|_| |_|\\__,_|");	
		System.out.println("==========================================================");
		System.out.println(" 1	- Start Simulation "
				+ "\n 2	- Generate GridWorld " 
				+ "\n 3	- Change Settings " 
				+ "\n 4	- Reset GridWorld to defaults "
				+ "\n 5	- Display current settings " 
				+ "\n Q	- Quit");
		System.out.println("==========================================================");
	}
	
	/**
	 * Creates a new GridWorld with the chosen X and Y and populates it with the chosen
	 * amount of Bonk(s) and Zap(s) by calling the appropriate methods in the GameEngine.
	 * Also sets isGridWorldGenerated and hasBeingsSpawned to true to indicate that they
	 * have been created.
	 */
	public void createGridWorld() {
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
	public void startGridWorld() throws CannotActException, InterruptedException {
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
	public void printGridWorld() {
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
	public void status() {
		System.out.print("\n" + "GridWorld = ");
		if (isGridWorldGenerated == true) {
			System.out.print(" Generated ");
		} else {
			System.out.print(" Not Generated ");
		}

		System.out.print("	Beings = ");
		if (hasBeingsSpawned == true) {
			System.out.println(" Generated ");
		} else {
			System.out.println(" Not Generated ");
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
	public void defaultSettings() {
		bonkStartPopulation = 20;
		zapStartPopulation = 5;
		gridWorldX = 20; // Column
		gridWorldY = 20; // Row
		maxDayCount = 20;
		settingsName = "Default";
	}

	/**
	 * This method allows the user to change the settings of the game.
	 * It set's the GridWorld maximum X and Y sizes, the Bonk and Zap start populations,
	 * and also the simulation length in days/cycles
	 */
	public void changeSettings() {
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
		return;
	}

	/**
	 * This prints out the current settings.
	 * Prints the current max X and Y of GridWorld, the Bonk and Zap start populations,
	 * and also the simulation length in days/cycles
	 */
	public void printCurrentSettings() {
		System.out.println("\n" + "Current Settings: " + settingsName + "\n" + "GridWorld Size: [" + gridWorldX + ", "
				+ gridWorldY + "]" + "\n" + "Bonks start population: " + bonkStartPopulation + "\n"
				+ "Zap start population: " + zapStartPopulation + "\n" + "GridWorld day count: " + maxDayCount);
	}

	/**
	 * This resets the game to it's default settings by loading the defaults and resetting
	 * GridWorld.
	 */
	public void resetSimulation() {
		defaultSettings();
		System.out.println("===Default settings loaded===");
		printCurrentSettings();
		gameEngine.createGridworld(gridWorldX, gridWorldY);
		hasBeingsSpawned = false;
		isGridWorldGenerated = false;
	}
	
	

	public int getBonkStartPopulation() {
		return bonkStartPopulation;
	}

	public void setBonkStartPopulation(int bonkStartPopulation) {
		this.bonkStartPopulation = bonkStartPopulation;
	}

	public int getZapStartPopulation() {
		return zapStartPopulation;
	}

	public void setZapStartPopulation(int zapStartPopulation) {
		this.zapStartPopulation = zapStartPopulation;
	}

	public int getGridWorldX() {
		return gridWorldX;
	}

	public void setGridWorldX(int gridWorldX) {
		this.gridWorldX = gridWorldX;
	}

	public int getGridWorldY() {
		return gridWorldY;
	}

	public void setGridWorldY(int gridWorldY) {
		this.gridWorldY = gridWorldY;
	}
	
	public String getGridWorldXY(){
		String xy = "[" + getGridWorldX() + ", " + getGridWorldY() + "]";
		return xy;
	}

	public int getMaxDayCount() {
		return maxDayCount;
	}

	public void setMaxDayCount(int maxDayCount) {
		this.maxDayCount = maxDayCount;
	}

	public String getSettingsName() {
		return settingsName;
	}

	public void setSettingsName(String settingsName) {
		this.settingsName = settingsName;
	}

	/**
	 * This method exit's the program.
	 */
	public void exitProgram() {
		System.out.println("*** THANK YOU FOR USING BONKS AND ZAPS ***");
		System.exit(0);
	}

}
