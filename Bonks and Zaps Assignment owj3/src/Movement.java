
public class Movement {
	
	public Movement() {
		
	}
	
	public Position moveLeft(Position position, int X, int Y) {
		Position newPosition;
		
		//System.out.println("moveLeft currentPosition: " + "(" + position.getColumnValue() + "," + position.getRowValue() +") ");
		
		if(position.getColumnValue() == 0){
			return position;
		} else {
			int col = position.getColumnValue();
			int row = position.getRowValue();
			col--;
			newPosition = new Position(col, row);
			//System.out.println("moveLeft newPosition: " + "(" + col + "," + row +") ");
			return newPosition;
		}
	}

	public Position moveRight(Position position, int X, int Y) {
		Position newPosition;
		
		if(position.getColumnValue() == X){
			return position;
		} else {
			int col = position.getColumnValue();
			int row = position.getRowValue();
			col++;
			newPosition = new Position(col, row);
			return newPosition;
		}
	}

	public Position moveUp(Position position, int X, int Y) {
		Position newPosition;
		
		if(position.getRowValue() == 0){
			return position;
		} else {
			int col = position.getColumnValue();
			int row = position.getRowValue();
			row--;
			newPosition = new Position(col, row);
			return newPosition;
		}
	}

	public Position moveDown(Position position, int X, int Y) {
		Position newPosition;
		
		if(position.getRowValue() == Y){
			return position;
		} else {
			int col = position.getColumnValue();
			int row = position.getRowValue();
			row++;
			newPosition = new Position(col, row);
			return newPosition;
		}
	}

	public Position moveDiagUpLeft(Position position, int X, int Y) {
		Position newPosition;
		
		if(position.getRowValue() == 0 || position.getColumnValue() == 0){
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

	public Position moveDiagUpRight(Position position, int X, int Y) {
		Position newPosition;
		
		if(position.getRowValue() == 0 || position.getColumnValue() == X){
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

	public Position moveDiagDownLeft(Position position, int X, int Y) {
	Position newPosition;
		
		if(position.getRowValue() == Y || position.getColumnValue() == 0){
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

	public Position moveDiagDownRight(Position position, int X, int Y) {
	Position newPosition;
		
		if(position.getRowValue() == Y || position.getColumnValue() == X){
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
