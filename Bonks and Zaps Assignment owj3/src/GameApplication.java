import java.util.Scanner;
import javafx.application.Application;
import javafx.application.Platform;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.Border;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.BorderStroke;
import javafx.scene.layout.BorderStrokeStyle;
import javafx.scene.layout.BorderWidths;
import javafx.scene.layout.CornerRadii;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

/**
 * Controls the menu system, settings and the initiation of the game and GameEngine.
 * 
 * @author Owain Jones
 * @version 1.0
 *
 */
public class GameApplication extends Application {
	
	private Label[] labels = new Label[5];
	private boolean doRun;

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
		
		launch(args);
		//GameApplication app = new Application();
		//app.callMenu();
	}
	
	@Override
	public void start(Stage stage) throws Exception {
		Border border = new Border(new BorderStroke(Color.GRAY, BorderStrokeStyle.SOLID, CornerRadii.EMPTY, new BorderWidths(1)));
		BorderPane borderPane = new BorderPane();
		borderPane.setPadding(new Insets(25,25,25,25)); 
		stage.setTitle("*****CS12320 INDIVIDUAL ASSIGNMENT - OWAIN JONES - owj3@aber.ac.uk*****");
		
		
		labels[2] = new Label(); //right
		labels[2].setPrefSize(100, 700);
		labels[2].setBorder(border);
		
		
		labels[3] = new Label(); //left
		labels[3].setPrefSize(100, 700);
		labels[3].setBorder(border);
	
		borderPane.setRight(labels[2]);
		borderPane.setLeft(labels[3]);
		
		///////Top Title Panel///////
		VBox titlePanel = new VBox();
		
		Label title = new Label("***** BONKS AND ZAPS SIMULATION *****"); //top
		title.setPrefSize(810, 20);
		//labels[0].setBorder(border);
		
		Label subTitle = new Label("*****CS12320 INDIVIDUAL ASSIGNMENT - OWAIN JONES - owj3@aber.ac.uk*****"); //top
		subTitle.setPrefSize(810, 20);
		//labels[1].setBorder(border);
		
		titlePanel.getChildren().add(title);
		titlePanel.getChildren().add(subTitle);
		
		title.setId("title");
		subTitle.setId("title");
		
		borderPane.setTop(titlePanel);	
		/////////////////////////////
		
		
		/////Bottom Button Panel/////
		HBox buttonPanel = new HBox();
		Button startSimulation = new Button("Start Simulation");
		startSimulation.setOnAction(e -> printMenu());
		startSimulation.setPrefSize(120,50);
		startSimulation.setId("btnlabel");
		Button pauseSimulation = new Button("Pause Simulation");
		pauseSimulation.setOnAction(e -> printMenu());
		pauseSimulation.setPrefSize(120,50);
		Button changeSettings = new Button("Change Settings");
		changeSettings.setOnAction(e -> printMenu());
		changeSettings.setPrefSize(120,50);
		Button reset = new Button("Reset GridWorld to defaults");
		reset.setOnAction(e -> printMenu());
		reset.setPrefSize(170,50);
		Button displaySettings = new Button("Display current settings");
		displaySettings.setOnAction(e -> printMenu());
		displaySettings.setPrefSize(160,50);
		Button quit = new Button("Quit");
		quit.setOnAction(e -> printMenu());
		quit.setPrefSize(120,50);
			
		buttonPanel.getChildren().add(startSimulation);
		buttonPanel.getChildren().add(pauseSimulation);
		buttonPanel.getChildren().add(changeSettings);
		buttonPanel.getChildren().add(reset);
		buttonPanel.getChildren().add(displaySettings);
		buttonPanel.getChildren().add(quit);
		
		borderPane.setBottom(buttonPanel);
		/////////////////////////////
		
		Scene scene = new Scene(borderPane);
		stage.setScene(scene);
		
		scene.getStylesheets().add(GameApplication.class.getResource("styling.css").toExternalForm());
		
		stage.setOnCloseRequest(e->{doRun = false; Platform.exit();});
		
		stage.setMaxWidth(1000);
		stage.setMaxHeight(700);
		
		stage.show();	
			
		
	}

	/**
	 * Constructor for Application that creates a new Scanner.
	 */
	public GameApplication() {
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
