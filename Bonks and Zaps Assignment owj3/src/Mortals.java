
public class Mortals {
	Movement movement = new Movement();

	public Mortals() {

	}

	public Position movement(Position p) {
		movement.moveLeft(p);
		movement.moveRight(p);
		movement.moveUp(p);
		movement.moveDown(p);
		movement.moveDiagUpLeft(p);
		movement.moveDiagUpRight(p);
		movement.moveDiagDownLeft(p);
		movement.moveDiagDownRight(p);

	}

}
