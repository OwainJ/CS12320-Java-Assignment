package uk.ac.aber.owj3.BonksandZaps.beings;
/**
 * This class stores and controls the position of Being(s) in GridWorld
 * 
 * @author Owain Jones
 * @version 1.0
 * 
 */
public class Position {
	
	private int columnValue;
	private int rowValue;
	
	/**
	 * Creates a new Position object and sets it's X and Y
	 * from what int's are inputed.
	 * 
	 * @param x
	 * @param y
	 */
	public Position(int x, int y){
		columnValue = x;
		rowValue = y;
	}

	/**
	 * Returns the Column value (X) of the Being as a int
	 * @return  Returns the Column value as a int
	 */
	public int getColumnValue() {
		return columnValue;
	}

	/**
	 * Sets the Column value (X) of the Being to whatever int value
	 * was passed through.
	 * @param columnValue
	 */
	public void setColumnValue(int columnValue) {
		this.columnValue = columnValue;
	}

	/**
	 * Returns the Row value (X) of the Being as a int
	 * @return  Returns the Row value as a int
	 */
	public int getRowValue() {
		return rowValue;
	}

	/**
	 * Sets the Row value (X) of the Being to whatever int value
	 * was passed through.
	 * @param rowValue
	 */
	public void setRowValue(int rowValue) {
		this.rowValue = rowValue;
	}
	
	/**
	 * This method simply increases the column value of the Being
	 * by 1.
	 */
	public void plusColumnValueBy1() {
		columnValue++;
	}
	
	/**
	 * This method simply increases the row value of the Being
	 * by 1.
	 */
	public void plusRowValueBy1() {
		rowValue++;
	}

	/**
	 * This prints out the position of the Being in GidWorld.
	 * 
	 * @return Returns the Position of the Being as a String
	 */
	@Override
	public String toString() {
		return "[ " + columnValue + ", " + rowValue + " ]";
	}
	
	

}
