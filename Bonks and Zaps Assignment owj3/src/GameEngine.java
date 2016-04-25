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

				Bonk bonk = new Bonk(nameGen, position);
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
		System.err
				.println("ERROR! GridWorld has not been created!"
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

	public void startSimulation() throws CannotActException, InterruptedException  {
		System.out.println("=====SIMULATION STARTED=====");
		System.out.println(maxDayCount);

		while (dayCount <= maxDayCount) {			
			printGridWorldState();
			actZaps();			
			actBonks();
			dayCount++;			
			Thread.sleep(1000);
		}if (dayCount == 0) {
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

	}
}
