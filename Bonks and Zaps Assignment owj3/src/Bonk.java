import java.util.ArrayList;

public class Bonk extends Mortals implements Being {
	private Boolean isBonkDead; //checks if bonk is dead
	private Boolean isBonkAdult; //checks if bonk is an adult
	private Boolean hasReproduced; //checks if bonk has reproduced this cycle
	private int countUntilAdult = 1; //waits one cycle until Bonk becomes adult and can start breeding

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
			hasReproduced = false;
		} else {
			return;
		}

		if (countUntilAdult > 0) {
			countUntilAdult--;
		} else {
			isBonkAdult = true;
		}
	}

	public Bonk doTheSex(ArrayList<Bonk> copyOfBonks) {
		Position bonkPos;
		Gender gen;
		Bonk babyBonk;
		String babyName;
		
		if (isBonkAdult == true && hasReproduced == false) {
			switch (gender) {
			case MALE:
				gen = Gender.FEMALE;
				// System.err.println(gender + " LOOKING FOR FEMALE");
				break;

			case FEMALE:
				gen = Gender.MALE;
				// System.err.println(gender + " LOOKING FOR MALE");
				break;

			default:
				// System.err.println("ERROR on gender checking of doTheSex();
				// method of Bonk class");
				gen = Gender.MALE;
			}

			for (Bonk b : copyOfBonks) {
				bonkPos = b.getLocation();

				if (bonkPos.getRowValue() == position.getRowValue()
						&& bonkPos.getColumnValue() == position.getColumnValue() && b.getIsBonkAdult() == true
						&& b.getGender() == gen && b.getIsBonkDead() == false) {
					// System.err.println(gen + " LOVER FOUND!");

					babyName = name + b.getName();

					/// ADD CREATE BABIES CODE
					babyBonk = new Bonk(babyName, position, false, Gender.MALE, gridWorldX, gridWorldY);
					hasReproduced = true;

					return babyBonk;

				}
			}
			// System.err.println("LOVER NOT FOUND!");
		} else {
			return null;
		}
		return null;
	}

	public void bonkDeath() {
		if (isBonkDead == false) {
			isBonkDead = true;
			name = name + "DEAD";
		}
	}

	@Override
	public String getName() {
		// TODO Auto-generated method stub
		if (isBonkAdult == true) {
			return name;
		} else {
			return name + "Baby";
		}
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
		return "[Bonk name=" + name + ", location=" + position + ", Gender=" + gender + ", Adult=" + isBonkAdult
				+ ", isBonkDead=" + isBonkDead + "]";
	}

}
