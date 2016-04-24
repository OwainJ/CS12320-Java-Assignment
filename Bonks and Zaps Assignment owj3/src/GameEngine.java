import java.util.Random;

public class GameEngine {
	GridWorld gridWorld;
	Random rand;
	Bonk bonk;
	Zap zap;
	
	int gridWorldX;
	int gridWorldY;

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
		System.err.println("ERROR! GridWorld has not been created!"
				+ "\n Please select option '1' on the menu to create a GridWorld ");

	}

	public void populateWithZaps(int zapStartPop) {

	}

	public int randomInt(int r) {
		rand = new Random();
		int a = rand.nextInt(r);
		return a;
	}

}
