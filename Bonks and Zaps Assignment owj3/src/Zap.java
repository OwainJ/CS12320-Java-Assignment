import java.util.ArrayList;

public class Zap extends Mortals implements Being {
	private String name;
	private Position position;
	private int gridWorldX; // Column
	private int gridWorldY; // Row

	public Zap(String newName, Position p, int X, int Y) {
		name = newName;
		position = p;
		gridWorldX = X;
		gridWorldY = Y;
	}

	public void act(ArrayList<Zap> copyOfBonks) throws CannotActException {
		//kill();
		position = movement(position, gridWorldX, gridWorldY);
	}
	
	@Override
	public void act() throws CannotActException {
		
	}

	public void kill() {
		
	}

	
	@Override
	public String getName() {
		// TODO Auto-generated method stub
		return name;
	}
	
	public void setName(String name) {
		// TODO Auto-generated method stub
		this.name = name;
	}

	@Override
	public Position getLocation() {
		// TODO Auto-generated method stub
		return position;
	}

	@Override
	public void setLocation(Position location) {
		// TODO Auto-generated method stub

	}

	@Override
	public String toString() {
		return "[Zapname=" + name + ", location=" + position + "]";
	}

}
