import java.util.Random;

public class GameEngine {
	GridWorld gridWorld;
	Random rand;
	Bonk bonk;
	Zap zap;

	int gridWorldX;
	int gridWorldY;

	int dayCount = 0;
	int maxDayCount;

	public GameEngine() {

	}

	public void createGridworld(int i, int j) {
		System.out.println("CHOICE 1");
		gridWorld = new GridWorld(i, j);
		gridWorldX = i;
		gridWorldY = j;
	}

	public void populateWithBonks(int bonkStartPop) {
		Position position;
		int x;
		int y;

		if (gridWorld != null) {
			int counter = bonkStartPop;
			int nameCount = 0;
			String nameGen;

			while (counter >= 0) {
				nameGen = "B" + nameCount;
				x = randomInt(gridWorldX);
				y = randomInt(gridWorldY);

				position = new Position(x, y);
				
				Gender gender = randomGender();

				Bonk bonk = new Bonk(nameGen, position, true , gender, gridWorldX, gridWorldY);
				nameCount++;
				counter--;

				gridWorld.addBonk(bonk);
				System.out.print("Created Bonk: ");
				System.out.print(bonk.getName());
				System.out.print(" At location: ");
				System.out.println(bonk.getLocation());
			}
			return;
		}
		System.err.println("ERROR! GridWorld has not been created!"
				+ "\n Please select option '1' on the menu to create a GridWorld ");

	}

	public void populateWithZaps(int zapStartPop) {

	}

	public void setMaxDayCount(int count) {
		maxDayCount = count;
	}

	// ///////////////////SIMULATION CODE PAST THIS LINE/////////////////////

	public int randomInt(int r) {
		rand = new Random();
		int a = rand.nextInt(r);
		return a;
	}
	
	public Gender randomGender() {
		int choice;
		choice = randomInt(1);
		
		switch (choice) {
		case 0:
			Gender gen = Gender.MALE;
			return gen;
			
		case 1:
			Gender gen2 = Gender.FEMALE;
			return gen2;
			
			default:
				System.err.println("ERROR on randomGender() method of GameEngine class");
				return null;
		}
	}

	public void startSimulation() throws CannotActException, InterruptedException {
		System.out.println("=====SIMULATION STARTED=====");
		System.out.println(maxDayCount);

		while (dayCount <= maxDayCount) {
			printGridWorldState();
			actZaps();
			actBonks();
			dayCount++;
			Thread.sleep(1000);
		}
		if (dayCount == 0) {
			System.out.println("=====SIMULATION FINISHED=====");
			return;
		}

	}

	private void actBonks() throws CannotActException {
		for (Bonk b : gridWorld.getBonks()) {
			b.act();
		}
	}

	private void actZaps() {

	}

	private void printGridWorldState() {

		System.out.println("===== Day: " + dayCount + " =====");
		gridWorld.gridWorldState();

		Position posMaxCount;
		Position posCount;
		Position bonkPos;

		posMaxCount = new Position(gridWorld.getGRID_WORLD_X_VALUE(), gridWorld.getGRID_WORLD_Y_VALUE());
		posCount = new Position(0, 0);

		while (posCount.getColumnValue() <= posMaxCount.getColumnValue()
				&& posCount.getRowValue() <= posMaxCount.getRowValue()) {
			System.out.print(posCount);
			System.out.print("[");

			for (Bonk b : gridWorld.getBonks()) {
				
				bonkPos = b.getLocation();

				if (bonkPos.getRowValue() == posCount.getRowValue() && bonkPos.getColumnValue() == posCount.getColumnValue()) {
					System.out.print(b.getName() + ", ");
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
}
