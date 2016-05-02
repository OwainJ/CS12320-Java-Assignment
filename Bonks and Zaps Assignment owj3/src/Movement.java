/**
 * Controls the movement of Being(s) in GridWorld
 * 
 * @author Owain Jones
 * @version 1.0
 *
 */

public class Movement {

	/**
	 * Creates a new Movement object
	 */
	public Movement() {

	}

	/**This returns a Position that is to the left of the input Position.
	 * If moving would mean moving outside of GridWorld, it will not move
	 * and instead return the input Position.
	 * 
	 * @param position
	 * @param X
	 * @param Y
	 * @return newPosition (or 'Position' if it can't move)
	 */
	public Position moveLeft(Position position, int X, int Y) {
		Position newPosition;

		if (position.getColumnValue() == 0) {
			return position;
		} else {
			int col = position.getColumnValue();
			int row = position.getRowValue();
			col--;
			newPosition = new Position(col, row);
			return newPosition;
		}
	}

	/**This returns a Position that is to the right of the input Position.
	 * If moving would mean moving outside of GridWorld, it will not move
	 * and instead return the input Position.
	 * 
	 * @param position
	 * @param X
	 * @param Y
	 * @return newPosition (or 'Position' if it can't move)
	 */
	public Position moveRight(Position position, int X, int Y) {
		Position newPosition;

		if (position.getColumnValue() == X) {
			return position;
		} else {
			int col = position.getColumnValue();
			int row = position.getRowValue();
			col++;
			newPosition = new Position(col, row);
			return newPosition;
		}
	}

	/**This returns a Position that is above the input Position.
	 * If moving would mean moving outside of GridWorld, it will not move
	 * and instead return the input Position.
	 * 
	 * @param position
	 * @param X
	 * @param Y
	 * @return newPosition (or 'Position' if it can't move)
	 */
	public Position moveUp(Position position, int X, int Y) {
		Position newPosition;

		if (position.getRowValue() == 0) {
			return position;
		} else {
			int col = position.getColumnValue();
			int row = position.getRowValue();
			row--;
			newPosition = new Position(col, row);
			return newPosition;
		}
	}

	/**This returns a Position that below the input Position.
	 * If moving would mean moving outside of GridWorld, it will not move
	 * and instead return the input Position.
	 * 
	 * @param position
	 * @param X
	 * @param Y
	 * @return newPosition (or 'Position' if it can't move)
	 */
	public Position moveDown(Position position, int X, int Y) {
		Position newPosition;

		if (position.getRowValue() == Y) {
			return position;
		} else {
			int col = position.getColumnValue();
			int row = position.getRowValue();
			row++;
			newPosition = new Position(col, row);
			return newPosition;
		}
	}

	/**This returns a Position that is diagonally up and to the left of the input Position.
	 * If moving would mean moving outside of GridWorld, it will not move
	 * and instead return the input Position.
	 * 
	 * @param position
	 * @param X
	 * @param Y
	 * @return newPosition (or 'Position' if it can't move)
	 */
	public Position moveDiagUpLeft(Position position, int X, int Y) {
		Position newPosition;

		if (position.getRowValue() == 0 || position.getColumnValue() == 0) {
			return position;
		} else {
			int col = position.getColumnValue();
			int row = position.getRowValue();
			row--;
			col--;
			newPosition = new Position(col, row);
			return newPosition;
		}
	}

	/**This returns a Position that is diagonally up and to the right of the input Position.
	 * If moving would mean moving outside of GridWorld, it will not move
	 * and instead return the input position.
	 * 
	 * @param position
	 * @param X
	 * @param Y
	 * @return newPosition (or 'Position' if it can't move)
	 */
	public Position moveDiagUpRight(Position position, int X, int Y) {
		Position newPosition;

		if (position.getRowValue() == 0 || position.getColumnValue() == X) {
			return position;
		} else {
			int col = position.getColumnValue();
			int row = position.getRowValue();
			row--;
			col++;
			newPosition = new Position(col, row);
			return newPosition;
		}
	}

	/**This returns a Position that is diagonally down and to the left of the input Position.
	 * If moving would mean moving outside of GridWorld, it will not move
	 * and instead return the input position.
	 * 
	 * @param position
	 * @param X
	 * @param Y
	 * @return newPosition (or 'Position' if it can't move)
	 */
	public Position moveDiagDownLeft(Position position, int X, int Y) {
		Position newPosition;

		if (position.getRowValue() == Y || position.getColumnValue() == 0) {
			return position;
		} else {
			int col = position.getColumnValue();
			int row = position.getRowValue();
			row++;
			col--;
			newPosition = new Position(col, row);
			return newPosition;
		}
	}

	/**This returns a Position that is diagonally down and to the right of the input Position.
	 * If moving would mean moving outside of GridWorld, it will not move
	 * and instead return the input position.
	 * 
	 * @param position
	 * @param X
	 * @param Y
	 * @return newPosition (or 'Position' if it can't move)
	 */
	public Position moveDiagDownRight(Position position, int X, int Y) {
		Position newPosition;

		if (position.getRowValue() == Y || position.getColumnValue() == X) {
			return position;
		} else {
			int col = position.getColumnValue();
			int row = position.getRowValue();
			row++;
			col++;
			newPosition = new Position(col, row);
			return newPosition;
		}
	}
}
