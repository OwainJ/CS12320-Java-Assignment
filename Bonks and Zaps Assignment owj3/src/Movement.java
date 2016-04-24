
public class Movement {
	
	public Movement() {
		
	}
	
	public Position moveLeft(Position position) {
		Position newPosition;
		
		if(position.getColumnValue() == 0){
			return position;
		} else {
			int col = position.getColumnValue();
			int row = position.getRowValue();
			col--;
			newPosition = new Position(col, row);
			return newPosition;
		}
	}

	public Position moveRight(Position position) {
		Position newPosition;
		
		if(position.getColumnValue() == app.gridWorldX){
			return position;
		} else {
			int col = position.getColumnValue();
			int row = position.getRowValue();
			col++;
			newPosition = new Position(col, row);
			return newPosition;
		}
	}

	public void moveUp() {
	

	}

	public void moveDown() {

	}

	public void moveDiagUpLeft() {

	}

	public void moveDiagUpRight() {

	}

	public void moveDiagDownLeft() {

	}

	public void moveDiagDownRight() {

	}

}
