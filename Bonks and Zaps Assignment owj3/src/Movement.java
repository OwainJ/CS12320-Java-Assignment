
public class Movement {
	
	public Movement() {
		
	}
	
	public Position moveLeft(Position position) {
		Position newPosition;
		
		System.out.println("moveLeft currentPosition: " + "(" + position.getColumnValue() + "," + position.getRowValue() +") ");
		
		if(position.getColumnValue() == 0){
			return position;
		} else {
			int col = position.getColumnValue();
			int row = position.getRowValue();
			col--;
			newPosition = new Position(col, row);
			System.out.println("moveLeft newPosition: " + "(" + col + "," + row +") ");
			return newPosition;
		}
	}

	public Position moveRight(Position position) {
		Position newPosition;
		
		if(position.getColumnValue() == gridWorld.getGRID_WORLD_X_VALUE()){
			return position;
		} else {
			int col = position.getColumnValue();
			int row = position.getRowValue();
			col++;
			newPosition = new Position(col, row);
			return newPosition;
		}
	}

	public Position moveUp(Position position) {
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

	public Position moveDown(Position position) {
		Position newPosition;
		
		if(position.getRowValue() == app.gridWorldY){
			return position;
		} else {
			int col = position.getColumnValue();
			int row = position.getRowValue();
			row++;
			newPosition = new Position(col, row);
			return newPosition;
		}
	}

	public Position moveDiagUpLeft(Position position) {
		Position newPosition;
		
		if(position.getRowValue() == 0 && position.getColumnValue() == 0){
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

	public Position moveDiagUpRight(Position position) {
		Position newPosition;
		
		if(position.getRowValue() == 0 && position.getColumnValue() == app.gridWorldX){
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

	public Position moveDiagDownLeft(Position position) {
	Position newPosition;
		
		if(position.getRowValue() == app.gridWorldY && position.getColumnValue() == 0){
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

	public Position moveDiagDownRight(Position position) {
	Position newPosition;
		
		if(position.getRowValue() == app.gridWorldY && position.getColumnValue() == app.gridWorldX){
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
