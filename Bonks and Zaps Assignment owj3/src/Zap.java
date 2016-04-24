
public class Zap implements Being{
	String name;
	Position location;
	
	public Zap(String newName, Position p){
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


	@Override
	public String toString() {
		return "Zap [name=" + name + ", location=" + location + "]";
	}
	
}