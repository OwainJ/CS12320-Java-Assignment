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

	private Label[] labels = new Label[5];
	private boolean doRun;
	private Thread runGame;

	GameApplication app = new GameApplication();

	public static void main(String[] args) throws CannotActException, InterruptedException {

		// String text = args[0];

		// if (text == "-t") {
		//GameApplication app = new GameApplication();
		//app.callMenu();
		// } else {
		launch(args);
		// }
	}

	public void start(Stage stage) throws CannotActException, InterruptedException, Exception {
		Border border = new Border(
				new BorderStroke(Color.GRAY, BorderStrokeStyle.SOLID, CornerRadii.EMPTY, new BorderWidths(1)));
		BorderPane borderPane = new BorderPane();
		borderPane.setPadding(new Insets(25, 25, 25, 25));

		stage.setTitle("*****CS12320 INDIVIDUAL ASSIGNMENT - OWAIN JONES - owj3@aber.ac.uk*****");

		labels[2] = new Label(); // right
		labels[2].setPrefSize(100, 700);
		labels[2].setBorder(border);

		labels[3] = new Label(); // left
		labels[3].setPrefSize(100, 700);
		labels[3].setBorder(border);

		borderPane.setRight(labels[2]);
		borderPane.setLeft(labels[3]);

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
		
		/////Middle Console Panel/////
		
		//////////////////////////////

		Scene scene = new Scene(borderPane);
		
		scene.getStylesheets().add(GameApplication.class.getResource("styling.css").toExternalForm());
		
		stage.setScene(scene);
		stage.setOnCloseRequest(e->{doRun = false; Platform.exit();});
		
		stage.setMaxWidth(1000);
		stage.setMaxHeight(700);

		stage.show();
	}

	private void stopSimulation() {
		doRun = false;
	}

	private void menu(String choice) {

		runGame = new Thread() {
			public void run() {
				doRun = true;

				while (doRun) {
					Platform.runLater(new Runnable() {
						public void run() {
							try {
								app.guiMenuSelector(choice);
								doRun = false;
							} catch (CannotActException | InterruptedException e) {
								// TODO Auto-generated catch block
								e.printStackTrace();
							}
						}
					});
					try {
						Thread.sleep(1000);
					} catch (InterruptedException e) {
					}
				}
			}
		};
		runGame.start();
	}

}
