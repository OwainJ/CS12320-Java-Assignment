import java.util.ArrayList;

/**
 * Represents a Zap that is a Being
 * 
 * @author Owain Jones
 * @version 1.0
 * 
 */
public class Zap extends Immortals implements Being {
	private String name; //stores zap's name
	private Position position; //stores zap's position
	
	private int gridWorldX; //Column
	private int gridWorldY; //Row

	/**
	 * Constructor for a new Zap.
	 * Sets it's name and Position.
	 * Also sets the size of the GridWorld to the Zaps memory.
	 * 
	 * @param newName
	 * @param p
	 * @param X
	 * @param Y
	 */
	public Zap(String newName, Position p, int X, int Y) {
		name = newName;
		position = p;
		gridWorldX = X;
		gridWorldY = Y;
	}
	
	/**
	 * When called the Zap does its stuff, e.g. move.
	 * 
	 * @throws CannotActException
	 *             Thrown if the state of the Being prevents it from acting,
	 *             e.g. it is dead
	 */
	@Override
	public void act() throws CannotActException {
		position = movement(position, gridWorldX, gridWorldY);
	}

	public ArrayList<Bonk> kill(ArrayList<Bonk> copyOfBonks) {
		Position bonkPos;
		for (Bonk b : copyOfBonks) {
			bonkPos = b.getLocation();

			if (bonkPos.getRowValue() == position.getRowValue()
					&& bonkPos.getColumnValue() == position.getColumnValue()) {
				b.bonkDeath();
			}
		}
		return copyOfBonks;
	}

	/**
	 * Every inhabitant on GridWorld must have a name given to them at birth or
	 * creation. It is fixed, but can be discovered via this method
	 * 
	 * @return The name
	 */
	@Override
	public String getName() {
		return name;
	}

	/**
	 * Returns the current Position of the Zap (which Room it's in)
	 * 
	 * @return Returns a Position that encapsulates its coordinates in GridWorld
	 */
	@Override
	public Position getLocation() {
		return position;
	}

	/**
	 * Allows the relocation of the Zap to another Room in GridWorld
	 * 
	 * @param location
	 */
	@Override
	public void setLocation(Position location) {
		this.position = location;
	}

	/**
	 * Print's out the Zap's name and Position in GridWorld.
	 * 
	 * @return Returns the name of the Zap and it's Position as a String
	 */
	@Override
	public String toString() {
		return "[Zapname=" + name + ", location=" + position + "]";
	}

}
