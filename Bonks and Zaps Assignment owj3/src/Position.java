
public class Position {
	
	private int columnValue;
	private int rowValue;
	
	public Position(int x, int y){
		columnValue = x;
		rowValue = y;
	}

	public int getColumnValue() {
		return columnValue;
	}

	public void setColumnValue(int columnValue) {
		this.columnValue = columnValue;
	}

	public int getRowValue() {
		return rowValue;
	}

	public void setRowValue(int rowValue) {
		this.rowValue = rowValue;
	}
	
	public void plusColumnValueBy1() {
		columnValue++;
	}
	
	public void plusRowValueBy1() {
		rowValue++;
	}

	@Override
	public String toString() {
		return "[ " + columnValue + ", " + rowValue + " ]";
	}
	
	

}
