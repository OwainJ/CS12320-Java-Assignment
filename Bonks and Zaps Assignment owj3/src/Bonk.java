
public class Bonk extends Mortals implements Being {
	String name;
	Position position;
	Boolean isBonkDead;
	Boolean isBonkAdult;
	int gridWorldX; // Column
	int gridWorldY; // Row

	public Bonk(String newName, Position p, Boolean age, int X, int Y) {
		name = newName;
		position = p;
		gridWorldX = X;
		gridWorldY = Y;
		isBonkDead = false;
		isBonkAdult = age;
	}

	@Override
	public String getName() {
		// TODO Auto-generated method stub
		return name;
	}

	@Override
	public void act() throws CannotActException {

		if (isBonkDead == false) {
			position = movement(position, gridWorldX, gridWorldY);
			
		} else {
			return;
		}
	}
	
	private void doTheSex() {
		
		
		
		
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
		return "/n [Bonk name=" + name + ", location=" + position + "]";
	}

}
