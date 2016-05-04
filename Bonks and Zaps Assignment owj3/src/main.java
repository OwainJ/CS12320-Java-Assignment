import javafx.application.Application;
import javafx.application.Platform;
import javafx.geometry.HPos;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
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
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.TilePane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

/**
 * This main class starts the program and also controls all of the GUI.
 * If the program is launched with the "-t" argument then control is handed
 * stright to the GameApplication class, which will then run a text only version
 * of the game
 * 
 * @author Owain Jones
 * @version 1.0
 *
 */
public class main extends Application {

	private Label[] labels = new Label[20];
	private boolean doRun;
	private Thread runGame;

	GameApplication app = new GameApplication();

	public static void main(String[] args) throws CannotActException, InterruptedException {

		// String text = args[0];

		//if (text == "-t") {
		 GameApplication app = new GameApplication();
		 app.callMenu();
		//} else {
		 //launch(args);
		//}
	}

	public void start(Stage stage) throws CannotActException, InterruptedException, Exception {
		Border border = new Border(
				new BorderStroke(Color.GRAY, BorderStrokeStyle.SOLID, CornerRadii.EMPTY, new BorderWidths(1)));
		BorderPane borderPane = new BorderPane();
		borderPane.setPadding(new Insets(25, 25, 25, 25));

		stage.setTitle("*****CS12320 INDIVIDUAL ASSIGNMENT - OWAIN JONES - owj3@aber.ac.uk*****");

		labels[0] = new Label(); // right
		labels[0].setPrefSize(100, 700);
		labels[0].setBorder(border);

		labels[1] = new Label(); // left
		labels[1].setPrefSize(100, 700);
		labels[1].setBorder(border);

		//borderPane.setRight(labels[0]);
		borderPane.setLeft(labels[1]);

		/////// Top Title Panel///////
		VBox titlePanel = new VBox();
		titlePanel.setAlignment(Pos.BASELINE_CENTER);
		titlePanel.setPadding(new Insets(1, 25, 25, 25));

		Label title = new Label("***** BONKS AND ZAPS SIMULATION *****"); // top
		title.setPrefSize(810, 20);
		title.setAlignment(Pos.BASELINE_CENTER);
		title.setId("title");
		//title.setBorder(border);

		Label subTitle = new Label("*****CS12320 INDIVIDUAL ASSIGNMENT - OWAIN JONES - owj3@aber.ac.uk*****"); // top
		subTitle.setPrefSize(810, 20);
		subTitle.setAlignment(Pos.BASELINE_CENTER);
		subTitle.setId("title");
		//subTitle.setBorder(border);

		titlePanel.getChildren().add(title);
		titlePanel.getChildren().add(subTitle);

		borderPane.setTop(titlePanel);
		/////////////////////////////

		/////Bottom Button Panel/////
		HBox buttonPanel = new HBox();
		Button startSimulation = new Button("Start Simulation");
		startSimulation.setOnAction(e -> menu("2"));
		startSimulation.setPrefSize(120, 50);
		startSimulation.setId("btnlabel");
		
		Button pauseSimulation = new Button("Pause Simulation");
		pauseSimulation.setOnAction(e -> stopSimulation());
		pauseSimulation.setPrefSize(120, 50);
		
		Button createGridWorld = new Button("Create GridWorld");
		createGridWorld.setOnAction(e -> menu("1"));
		createGridWorld.setPrefSize(120, 50);
		createGridWorld.setId("btnlabel");
		
		Button changeSettings = new Button("Change Settings");
		changeSettings.setOnAction(e -> menu("3"));
		changeSettings.setPrefSize(120, 50);
		
		Button reset = new Button("Reset GridWorld to defaults");
		reset.setOnAction(e -> menu("4"));
		reset.setPrefSize(170, 50);
		
		Button displaySettings = new Button("Display current settings");
		displaySettings.setOnAction(e -> menu("5"));
		displaySettings.setPrefSize(160, 50);
		
		Button quit = new Button("Quit");
		quit.setOnAction(e -> menu("Q"));
		quit.setPrefSize(120, 50);

		buttonPanel.getChildren().add(startSimulation);
		buttonPanel.getChildren().add(pauseSimulation);
		buttonPanel.getChildren().add(createGridWorld);
		buttonPanel.getChildren().add(changeSettings);
		buttonPanel.getChildren().add(reset);
		buttonPanel.getChildren().add(displaySettings);
		buttonPanel.getChildren().add(quit);

		borderPane.setBottom(buttonPanel);
		/////////////////////////////
			
		/////Right Console Panel//////
		GridPane grid = new GridPane();
		
		labels[2] = new Label("Current Settings"); // left
		labels[2].setPrefSize(150, 80);
		labels[2].setBorder(border);
		
		labels[3] = new Label("SettingsName"); // left
		labels[3].setPrefSize(150, 80);
		labels[3].setBorder(border);
		
		labels[4] = new Label("GridWorld Size:"); // left
		labels[4].setPrefSize(150, 80);
		labels[4].setBorder(border);
		
		labels[5] = new Label("[X, Y]"); // left
		labels[5].setPrefSize(50, 80);
		labels[5].setBorder(border);
		
		labels[6] = new Label("Bonk start population:"); // left
		labels[6].setPrefSize(150, 80);
		labels[6].setBorder(border);
		
		labels[7] = new Label("num"); // left
		labels[7].setPrefSize(50, 80);
		labels[7].setBorder(border);
		
		labels[8] = new Label("Zap start population:"); // left
		labels[8].setPrefSize(150, 80);
		labels[8].setBorder(border);
		
		labels[9] = new Label("num"); // left
		labels[9].setPrefSize(50, 80);
		labels[9].setBorder(border);
		
		labels[10] = new Label("GridWorld day count:"); // left
		labels[10].setPrefSize(150, 80);
		labels[10].setBorder(border);
		
		labels[11] = new Label("num"); // left
		labels[11].setPrefSize(50, 80);
		labels[11].setBorder(border);
		
		grid.add(labels[2], 0, 0);
		grid.add(labels[3], 0, 1);
		grid.add(labels[4], 0, 2);
		grid.add(labels[5], 1, 2);
		grid.add(labels[6], 0, 3);
		grid.add(labels[7], 1, 3);
		grid.add(labels[8], 0, 4);
		grid.add(labels[9], 1, 4);
		grid.add(labels[10], 0, 5);
		grid.add(labels[11], 1, 5);
		
		borderPane.setRight(grid);	
		//////////////////////////////
		
		
		/////Middle Console Panel/////
		
		//////////////////////////////

		Scene scene = new Scene(borderPane);
		
		scene.getStylesheets().add(GameApplication.class.getResource("styling.css").toExternalForm());
		
		stage.setScene(scene);
		stage.setOnCloseRequest(e->{doRun = false; Platform.exit();});
		
		stage.setMaxWidth(1000);
		stage.setMaxHeight(700);

		stage.show();
		
		updateSettingsGUI();
	}

	private void stopSimulation() {
		doRun = false;
	}

	private void menu(String choice) {

		runGame = new Thread() {
			public void run() {
				doRun = true;

				//while (doRun) {
					Platform.runLater(new Runnable() {
						public void run() {
							try {
								app.guiMenuSelector(choice);
								updateSettingsGUI();
								doRun = false;
								return;
							} catch (CannotActException | InterruptedException e) {
								// TODO Auto-generated catch block
								e.printStackTrace();
							}
						}
					});
					try {
						Thread.sleep(1000);
					} catch (InterruptedException e) {
				//	}
				}
			}
		};
		runGame.start();
	}
	
	private void updateSettingsGUI() {
		labels[3].setText(app.getSettingsName());
		labels[5].setText(app.getGridWorldXY());
		labels[7].setText(String.valueOf(app.getBonkStartPopulation()));
		labels[9].setText(String.valueOf(app.getZapStartPopulation()));
		labels[11].setText(String.valueOf(app.getMaxDayCount()));
		
		
	}

}
