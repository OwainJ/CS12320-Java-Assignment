import java.util.Random;

/**
 * Controls the entire game,l how it runs and all that jazz.
 * 
 * @author Owain Jones
 * @version 1.0
 * 
 */
public class GameEngine {
	GridWorld gridWorld;
	Random rand;
	Bonk bonk;
	Zap zap;
	boolean babiesToAdd;
	boolean gridWorldCreated;

	int gridWorldX;
	int gridWorldY;

	int dayCount = 0;
	int maxDayCount;

	int bonkPopulation;
	int bonkStartPopulation;
	int bonksBorn;
	
	int zapStartPopulation;

	/**
	 * Creates a new GameEngine object
	 */
	public GameEngine() {

	}

	/**
	 * Creates a new GridWorld object.
	 * Passes in the X and Y of the gridWorld as int's.
	 * 
	 * @param i
	 * @param j
	 */
	public void createGridworld(int i, int j) {
		gridWorld = new GridWorld(i, j);
		gridWorldX = i;
		gridWorldY = j;
	}

	/**
	 * This method populates the gridWorld with a specified amount of Bonks.
	 * The amount of Bonks created is dictated by the int that is passed in.
	 * The Bonk's location and Gender are all randomly assigned.
	 * 
	 * @param bonkStartPop
	 * @return Returns an error if gridWorld has not been created.
	 */
	public void populateWithBonks(int bonkStartPop) {
		bonkStartPopulation = bonkStartPop;
		Position position;
		int x;
		int y;

		if (gridWorld != null) {
			int counter = bonkStartPop;
			int nameCount = 0;
			String nameGen;

			while (counter >= 0) {
				nameGen = "B" + nameCount;
				x = Utilities.randomInt(gridWorldX);
				y = Utilities.randomInt(gridWorldY);

				position = new Position(x, y);

				Gender gender = Utilities.randomGender();

				Bonk bonk = new Bonk(nameGen, position, true, gender,
						gridWorldX, gridWorldY);
				nameCount++;
				counter--;
				bonkPopulation++;

				gridWorld.addBonk(bonk);
				System.out.print("Created Bonk: ");
				System.out.print(bonk.getName());
				System.out.print(" At location: ");
				System.out.print(bonk.getLocation());
				System.out.print(" And is a: ");
				System.out.println(bonk.getGender());
			}
			return;
		}
		System.err.println("ERROR! GridWorld has not been created!"
						+ "\n Please select option '1' on the menu to create a GridWorld ");

	}

	/**
	 * This method populates the gridWorld with a specified amount of Zaps.
	 * The amount of Zaps created is dictated by the int that is passed in.
	 * The Zap's location are randomly assigned.
	 * 
	 * @param zapStartPop
	 * @return Returns an error if gridWorld has not been created.
	 */
	public void populateWithZaps(int zapStartPop) {
		zapStartPopulation = zapStartPop;
		Position position;
		int x;
		int y;

		if (gridWorld != null) {
			int counter = zapStartPop;
			int nameCount = 0;
			String nameGen;

			while (counter >= 0) {
				nameGen = "Z" + nameCount;
				x = Utilities.randomInt(gridWorldX);
				y = Utilities.randomInt(gridWorldY);

				position = new Position(x, y);

				Zap zap = new Zap(nameGen, position, gridWorldX, gridWorldY);
				nameCount++;
				counter--;

				gridWorld.addZap(zap);
				System.out.print("Created Zap: ");
				System.out.print(zap.getName());
				System.out.print(" At location: ");
				System.out.println(zap.getLocation());
			}
			return;
		}
		System.err
				.println("ERROR! GridWorld has not been created!"
						+ "\n Please select option '1' on the menu to create a GridWorld ");

	}

	/**
	 * Sets the maximum day count of the gridWorld. aka the amount of cycles the game
	 * runs through until it stops.
	 * 
	 * @param count
	 */
	public void setMaxDayCount(int count) {
		maxDayCount = count;
	}

	// ///////////////////SIMULATION CODE PAST THIS LINE/////////////////////

	/**
	 * This completely clears GridWorld by emptying it from Beings
	 * and resetting it's max size to 0. 
	 */
	public void resetSimulation() {
		gridWorld = null;
		bonk = null;
		zap = null;
		gridWorldX = 0;
		gridWorldY = 0;

		System.out.println("====GridWorld has been reset====");

	}

	/**
	 * This methods starts, runs and controls the simulation for ever how many
	 * cycles have been dictated in maxDayCount.
	 * 
	 * @throws CannotActException
	 * @throws InterruptedException
	 */
	public void startSimulation() throws CannotActException,
			InterruptedException {
		if (gridWorld != null) {

			System.out.println("=====SIMULATION STARTED=====");
			System.out.println(maxDayCount);

			while (dayCount <= maxDayCount) {
				printGridWorldState();
				actZaps();
				actBonks();
				populateNewBonkBabies();
				dayCount++;

				Thread.sleep(1000);
			}
			System.out.println("=====SIMULATION FINISHED=====");
			afterSimulationReport();
			return;
		} else {
			System.err.println("ERROR GridWorld not created, cannot start simulation");
		}
	}

	/**
	 * This method generates and prints a report on how the previous simulation went.
	 * It reports the GridWorld size, how many days (cycles) passed, how many Bonk(s) and Zap(s)
	 * started, how many Bonk(s) where born, how many Bonk(s) died and how many Bonk(s) where still
	 * alive at the end of the simulation.
	 * 
	 *  @return Returns a report on how the simulation went.
	 */
	public void afterSimulationReport() {
		int dbonks = countDeadBonks();
		int abonks = (bonkPopulation - dbonks);
		System.out.println("\n" + "====Post Simulation Report====");
		System.out.println("Simulation length:		 " + maxDayCount + " days"
				+ "\n" + "GridWorld size: 		 " + "[" + gridWorldX + "," + gridWorldY + "]"
				+ "\n" + "Starting Zap population:	 " + zapStartPopulation
				+ "\n" + "Starting Bonk population:	 " + bonkStartPopulation
				+ "\n" + "Number of new Bonks born:	 " + bonksBorn
				+ "\n" + "Number of Bonks still alive:	 " + abonks 
				+ "\n" + "Number of deceased Bonks:	 " + dbonks);
		System.out.println("===============================");

	}

	/**
	 * Controls the how the Bonk(s) act.
	 * Calls their act() and reproduction methods.
	 * 
	 * @throws CannotActException
	 */
	private void actBonks() throws CannotActException {
		Bonk newBabyBonk;
		for (Bonk b : gridWorld.getBonks()) {
			b.act();

			if (b.getIsBonkDead() == false) {
				newBabyBonk = b.doTheSex(gridWorld.getBonks());
				if (newBabyBonk != null) {
					gridWorld.addBonkBaby(newBabyBonk);
					babiesToAdd = true;
					bonksBorn++;
				}
			}
		}
	}

	/**
	 * Control's how the Zap(s) act during a cycle.
	 * Calls their act() and kill() methods.
	 * 
	 * @throws CannotActException
	 */
	private void actZaps() throws CannotActException {
		for (Zap z : gridWorld.getZaps()) {
			z.act();
			gridWorld.setBonks(z.kill(gridWorld.getBonks()));
		}
	}

	/**
	 * This methods populates GridWorld with all of the new Baby Bonks that have been
	 * born in the last cycle. It then clears the babiesToAdd array.
	 */
	private void populateNewBonkBabies() {
		if (babiesToAdd == true) {
			for (Bonk bBaby : gridWorld.getBonkBabies()) {
				gridWorld.addBonk(bBaby);
				bonkPopulation++;
			}
			gridWorld.clearBonkBabies();
			babiesToAdd = false;
		}
	}

	/**
	 * This method prints out the state of GridWorld at the end of each cycle.
	 * It print's what day (cycle) it is on and then the position of
	 * all of the Bonk(s) and Zap(s) in GridWorld
	 * 
	 *  @return prints out the state of GridWorld
	 */
	private void printGridWorldState() {

		System.out.println("===== Day: " + dayCount + " =====");

		Position posMaxCount;
		Position posCount;
		Position bonkPos;
		Position zapPos;

		posMaxCount = new Position(gridWorld.getGRID_WORLD_X_VALUE(),
				gridWorld.getGRID_WORLD_Y_VALUE());
		posCount = new Position(0, 0);

		while (posCount.getColumnValue() <= posMaxCount.getColumnValue()
				&& posCount.getRowValue() <= posMaxCount.getRowValue()) {
			System.out.print(posCount);
			System.out.print("[");

			for (Bonk b : gridWorld.getBonks()) {

				bonkPos = b.getLocation();

				if (bonkPos.getRowValue() == posCount.getRowValue()
						&& bonkPos.getColumnValue() == posCount
								.getColumnValue()) {
					System.out.print(b.getName() + ", ");
				}
			}

			for (Zap z : gridWorld.getZaps()) {

				zapPos = z.getLocation();

				if (zapPos.getRowValue() == posCount.getRowValue()
						&& zapPos.getColumnValue() == posCount.getColumnValue()) {
					System.out.print(z.getName() + ", ");
				}
			}

			System.out.println("]");

			if (posCount.getRowValue() == posMaxCount.getRowValue()) {
				posCount.plusColumnValueBy1();
				posCount.setRowValue(0);
			} else if (posCount.getRowValue() < posMaxCount.getRowValue()) {
				posCount.plusRowValueBy1();
			}
		}
		return;

	}

	/**
	 * This method is used to count the amount
	 * of Bonk(s) that have died in GridWorld.
	 * 
	 * @return the number of dead Bonk(s) as an int
	 */
	public int countDeadBonks() {
		int count = 0;
		for (Bonk b : gridWorld.getBonks()) {
			if (b.getIsBonkDead() == true) {
				count++;
			}
		}
		return count;
	}
}
