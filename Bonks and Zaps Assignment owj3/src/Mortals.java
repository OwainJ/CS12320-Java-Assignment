import java.util.Random;

public class Mortals {
	Movement movement = new Movement();
	int gridWorldX; //Column
	int gridWorldY; //Row
	Random rand;

	public Mortals() {

	}

	public Position movement(Position p, int X, int Y) {
		gridWorldX = X;
		gridWorldY = Y;
		Position newPosition;
		int choice;
		
		choice = randomInt(7);
		switch (choice) {
		
		case 0:
			newPosition = movement.moveLeft(p, gridWorldX, gridWorldY);
			return newPosition;
			
		case 1:
			newPosition = movement.moveRight(p, gridWorldX, gridWorldY);
			return newPosition;
			
		case 2:
			newPosition = movement.moveUp(p, gridWorldX, gridWorldY);
			return newPosition;
		
		case 3:
			newPosition = movement.moveDown(p, gridWorldX, gridWorldY);
			return newPosition;
			
		case 4:
			newPosition = movement.moveDiagUpLeft(p, gridWorldX, gridWorldY);
			return newPosition;
			
		case 5:
			newPosition = movement.moveDiagUpRight(p, gridWorldX, gridWorldY);
			return newPosition;
			
		case 6:
			newPosition = movement.moveDiagDownLeft(p, gridWorldX, gridWorldY);
			return newPosition;
		
		case 7:
			newPosition = movement.moveDiagDownRight(p, gridWorldX, gridWorldY);
			return newPosition;
			
			default:
				System.err.println("Error in random number in movement() method of Mortals class");
				return p;
		}
	}
	
	public int randomInt(int r) {
		rand = new Random();
		int a = rand.nextInt(r);
		return a;
	}

}
