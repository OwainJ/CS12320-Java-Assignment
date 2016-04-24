
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

	@Override
	public String toString() {
		return "Position [columnValue=" + columnValue + ", rowValue=" + rowValue + "]";
	}
	
	

}
