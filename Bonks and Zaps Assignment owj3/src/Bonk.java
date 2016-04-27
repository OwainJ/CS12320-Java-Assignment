import java.util.ArrayList;

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

	public void act(ArrayList<Bonk> copyOfBonks) throws CannotActException {

		if (isBonkDead == false) {
			doTheSex(copyOfBonks);
			position = movement(position, gridWorldX, gridWorldY);
			
		} else {
			return;
		}
	}
	
	@Override
	public void act() throws CannotActException {
		// TODO Auto-generated method stub
		
	}

	private void doTheSex(ArrayList<Bonk> copyOfBonks) {
		Position bonkPos;
		Gender gen;
		
		switch (gender) {
		case MALE:
			gen = Gender.FEMALE;
			System.err.println(gender + " LOOKING FOR FEMALE");
			break;
			
		case FEMALE:
			gen = Gender.MALE;
			System.err.println(gender + " LOOKING FOR MALE");
			break;
			
			default:
				System.err.println("ERROR on gender checking of doTheSex(); method of Bonk class");
				gen = Gender.MALE;
		}
		
		for (Bonk b : copyOfBonks) {		
			bonkPos = b.getLocation();
			
			if (bonkPos.getRowValue() == position.getRowValue() && bonkPos.getColumnValue() == position.getColumnValue() 
					&& b.getIsBonkAdult() == true && b.getGender() == gen) {
				System.err.println(gen + " LOVER FOUND!");
				
				///ADD CREATE BABIES CODE
				
				return;
				
			}
			//System.err.println("LOVER NOT FOUND!");
		}
		
		
		
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
