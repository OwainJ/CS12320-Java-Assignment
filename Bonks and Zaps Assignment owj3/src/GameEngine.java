import java.util.Random;

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

	public GameEngine() {

	}

	public void createGridworld(int i, int j) {
		gridWorld = new GridWorld(i, j);
		gridWorldX = i;
		gridWorldY = j;
	}

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

				Gender gender = randomGender();

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
		System.err
				.println("ERROR! GridWorld has not been created!"
						+ "\n Please select option '1' on the menu to create a GridWorld ");

	}

	public void populateWithZaps(int zapStartPop) {
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

	public void setMaxDayCount(int count) {
		maxDayCount = count;
	}

	public Gender randomGender() {
		int choice;
		choice = Utilities.randomInt(2);

		switch (choice) {
		case 0:
			Gender gen = Gender.MALE;
			return gen;

		case 1:
			Gender gen2 = Gender.FEMALE;
			return gen2;

		default:
			System.err
					.println("ERROR on randomGender() method of GameEngine class");
			return null;
		}
	}

	// ///////////////////SIMULATION CODE PAST THIS LINE/////////////////////

	public void resetSimulation() {
		gridWorld = null;
		bonk = null;
		zap = null;
		gridWorldX = 0;
		gridWorldY = 0;

		System.out.println("====GridWorld has been reset====");

	}

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

	public void afterSimulationReport() {
		int dbonks = countDeadBonks();
		int abonks = (bonkPopulation - dbonks);
		System.out.println("\n" + "====Post Simulation Report====");
		System.out.println("Simulation length:		 " + maxDayCount + " days"
				+ "\n" + "Starting Bonk population:	 " + bonkStartPopulation
				+ "\n" + "Number of new Bonks born:	 " + bonksBorn
				+ "\n" + "Number of Bonks still alive:	 " + abonks 
				+ "\n" + "Number of deceased Bonks:	 " + dbonks);
		System.out.println("===============================");

	}

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

	private void actZaps() throws CannotActException {
		for (Zap z : gridWorld.getZaps()) {
			z.act();
			gridWorld.setBonks(z.kill(gridWorld.getBonks()));
		}
	}

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

	private void printGridWorldState() {

		System.out.println("===== Day: " + dayCount + " =====");
		gridWorld.gridWorldState();

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
