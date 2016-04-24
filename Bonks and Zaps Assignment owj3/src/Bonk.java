
public class Bonk implements Being{
	String name;
	Position location;
	
	public Bonk(String newName, Position p){
		name = newName;
		location = p;
	}
	

	@Override
	public String getName() {
		// TODO Auto-generated method stub
		return name;
	}

	@Override
	public void act() throws CannotActException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Position getLocation() {
		// TODO Auto-generated method stub
		return location;
	}

	@Override
	public void setLocation(Position location) {
		// TODO Auto-generated method stub
		
	}
	
}
