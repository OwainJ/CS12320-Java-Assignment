import java.util.ArrayList;

/**
 * Represents a Bonk that is a Being
 * 
 * @author Owain Jones
 * @version 1.0
 * 
 */
public class Bonk extends Mortals implements Being {
	private Boolean isBonkDead; //checks if bonk is dead
	private Boolean isBonkAdult; //checks if bonk is an adult
	private Boolean hasReproduced; //checks if bonk has reproduced this cycle
	private int countUntilAdult = 1; //waits one cycle until Bonk becomes adult and can start breeding

	/**
	 * Constructor for a new Bonk
	 * Sets it's name and Position.
	 * Also sets the size of the GridWorld to the Zaps memory.
	 * 
	 * @param newName
	 * @param p
	 * @param X
	 * @param Y
	 */
	public Bonk(String newName, Position p, Boolean age, Gender g, int X, int Y) {
		name = newName;
		position = p;
		gridWorldX = X;
		gridWorldY = Y;
		isBonkDead = false;
		isBonkAdult = age;
		gender = g;
		hasReproduced = false;
	}

	/**
	 * When called the Bonk does its stuff, e.g. move.
	 * 
	 * @throws CannotActException
	 *             Thrown if the state of the Being prevents it from acting,
	 *             e.g. it is dead
	 */
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

	/**
	 * This checks whether there are any Bonks of the opposite sex in the same Position
	 * on PridWorld. If there are it reproduces with that Bonk and creates a Baby Bonk.
	 * A Bonk can only reproduce once per cycle.
	 * 
	 * @param copyOfBonks
	 * @return returns a new BabyBonk or null if no mate was found.
	 */
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
						&& b.getGender() == gen && b.getIsBonkDead() == false && b.getHasReproduced() == false) {
					// System.err.println(gen + " LOVER FOUND!");

					babyName = name + b.getName();

					/// ADD CREATE BABIES CODE
					babyBonk = new Bonk(babyName, position, false, Gender.MALE, gridWorldX, gridWorldY);
					hasReproduced = true;
					b.setHasReproduced(true);

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

	/**
	 * Every inhabitant on GridWorld must have a name given to them at birth or
	 * creation. It is fixed, but can be discovered via this method
	 * 
	 * @return The name
	 */
	@Override
	public String getName() {
		// TODO Auto-generated method stub
		if (isBonkAdult == true) {
			return name;
		} else {
			return name + "Baby";
		}
	}

	/**
	 * Returns the current Position of the Bonk (which Room it's in)
	 * 
	 * @return Returns a Position that encapsulates its coordinates in Grid
	 *         World
	 */
	@Override
	public Position getLocation() {
		// TODO Auto-generated method stub
		return position;
	}

	/**
	 * Allows the relocation of the Bonk to another Room in Grid World
	 * 
	 * @param location
	 */
	@Override
	public void setLocation(Position location) {
		// TODO Auto-generated method stub

	}
	
	

	public Boolean getHasReproduced() {
		return hasReproduced;
	}

	public void setHasReproduced(Boolean hasReproduced) {
		this.hasReproduced = hasReproduced;
	}

	/**
	 * Checks whether or not the Bonk is dead.
	 * It is fixed, once a Bonk is dead it stays dead, but can be discovered via this method.
	 * 
	 * @return Returns a boolean of true/false depending if the Bonk is dead or not.
	 */
	public Boolean getIsBonkDead() {
		return isBonkDead;
	}

	/**
	 * Checks whether or not the Bonk is an Adult.
	 * It is fixed, but can be discovered via this method
	 * 
	 * @return Returns a boolean of true/false depending if the Bonk is an Adult or not.
	 */
	public Boolean getIsBonkAdult() {
		return isBonkAdult;
	}

	/**
	 * Checks whether or not the Bonk is a Male or Female.
	 * It is fixed, but can be discovered via this method
	 * 
	 * @return Returns a Gender of Male/Female depending if the Bonk is a Male or Female.
	 */
	public Gender getGender() {
		return gender;
	}

	/**
	 * Print's out the Bonk's name and Position in GridWorld.
	 * 
	 * @return Returns the name of the Bonk and it's Position as a String
	 */
	@Override
	public String toString() {
		return "[Bonk name=" + name + ", location=" + position + ", Gender=" + gender + ", Adult=" + isBonkAdult
				+ ", isBonkDead=" + isBonkDead + "]";
	}

}
