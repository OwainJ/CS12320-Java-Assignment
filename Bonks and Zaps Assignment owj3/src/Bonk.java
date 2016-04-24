
public class Bonk extends Mortals implements Being {
	String name;
	Position position;
	
	public Bonk(String newName, Position p){
		name = newName;
		position = p;
	}
	

	@Override
	public String getName() {
		// TODO Auto-generated method stub
		return name;
	}

	@Override
	public void act() throws CannotActException {
		// TODO Auto-generated method stub
		movement(position);
		
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
		return "Bonk [name=" + name + ", location=" + position + "]";
	}
	
}
