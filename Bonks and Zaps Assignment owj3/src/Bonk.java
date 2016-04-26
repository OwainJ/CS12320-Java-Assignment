
public class Bonk extends Mortals implements Being {
	private String name;
	private Position position;
	private Boolean isBonkDead;
	private Boolean isBonkAdult;
	private Gender gender;
	private int gridWorldX; // Column
	private int gridWorldY; // Row

	public Bonk(String newName, Position p, Boolean age, Gender g, int X, int Y) {
		name = newName;
		position = p;
		gridWorldX = X;
		gridWorldY = Y;
		isBonkDead = false;
		isBonkAdult = age;
		gender = g;
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
		
		for (Bonk b : gridWorld.getBonks()) {
			
		}
		
		
		
	}
	
	@Override
	public String getName() {
		// TODO Auto-generated method stub
		return name;
	}
	
	@Override
	public String setName(String name) {
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
	
	public Boolean getIsBonkDead() {
		return isBonkDead;
	}

	public void setIsBonkDead(Boolean isBonkDead) {
		this.isBonkDead = isBonkDead;
	}

	public Boolean getIsBonkAdult() {
		return isBonkAdult;
	}

	public void setIsBonkAdult(Boolean isBonkAdult) {
		this.isBonkAdult = isBonkAdult;
	}

	public Gender getGender() {
		return gender;
	}

	public void setGender(Gender gender) {
		this.gender = gender;
	}

	@Override
	public String toString() {
		return "[Bonk name=" + name + ", location=" + position + ", Gender=" + gender 
				+ ", Adult=" + isBonkAdult + ", isBonkDead=" + isBonkDead + "]";
	}

}
