/**
 * Super Class for all mortals in the game.
 * Controls their movement and gives them basic requires parameters.
 * 
 * @author Owain Jones
 * @version 1.0
 *
 */

public class Mortals {
	Movement movement = new Movement();

	String name; // stores mortal's name
	Position position; // stores mortal's position
	Gender gender; // stores mortal's gender
	int gridWorldX; // Column
	int gridWorldY; // Row

	public Mortals() {

	}

	/**
	 * This movement method chooses a random direction to move
	 * then calls the appropriate method from the Movement class.
	 * It takes inputs gridWorlds X and Y and the mortal's current position
	 * then passes them into the appropriate method in Movement.
	 * 
	 * To pick a random direction it utilises the randomInt() method
	 * in the utilities class.
	 * 
	 * @param p
	 * @param X
	 * @param Y
	 * @return newPosition (or 'p' if not moving)
	 */
	public Position movement(Position p, int X, int Y) {
		gridWorldX = X;
		gridWorldY = Y;
		Position newPosition;
		int choice;

		choice = Utilities.randomInt(9);
		switch (choice) {

		case 0: // Move left
			newPosition = movement.moveLeft(p, gridWorldX, gridWorldY);
			return newPosition;

		case 1: // Move right
			newPosition = movement.moveRight(p, gridWorldX, gridWorldY);
			return newPosition;

		case 2: // Move up
			newPosition = movement.moveUp(p, gridWorldX, gridWorldY);
			return newPosition;

		case 3: // Move down
			newPosition = movement.moveDown(p, gridWorldX, gridWorldY);
			return newPosition;

		case 4: // Move diagonally up left
			newPosition = movement.moveDiagUpLeft(p, gridWorldX, gridWorldY);
			return newPosition;

		case 5: // Move diagonally up right
			newPosition = movement.moveDiagUpRight(p, gridWorldX, gridWorldY);
			return newPosition;

		case 6: // Move diagonally down left
			newPosition = movement.moveDiagDownLeft(p, gridWorldX, gridWorldY);
			return newPosition;

		case 7: // Move diagonally down right
			newPosition = movement.moveDiagDownRight(p, gridWorldX, gridWorldY);
			return newPosition;

		case 8: // Don't Move, stay where you are
			return p;

		default:
			System.err.println("Error in random number in movement() method of Mortals class");
			return p;
		}
	}
}
