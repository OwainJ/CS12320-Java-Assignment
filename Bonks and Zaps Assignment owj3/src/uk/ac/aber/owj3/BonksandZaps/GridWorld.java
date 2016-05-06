package uk.ac.aber.owj3.BonksandZaps;
import java.util.ArrayList;
import java.util.Arrays;

import uk.ac.aber.owj3.BonksandZaps.beings.Being;
import uk.ac.aber.owj3.BonksandZaps.beings.Bonk;
import uk.ac.aber.owj3.BonksandZaps.beings.Zap;

/**
 * Represents and controls GridWorld
 * 
 * @author Owain Jones
 * @version 1.0
 */
public class GridWorld {

	private final int GRID_WORLD_X_VALUE; //The X value of GridWorld	
	private final int GRID_WORLD_Y_VALUE; //The Y value of GridWorld
	
	private ArrayList<Being>[][] gridWorld;
	private ArrayList<Bonk> bonks;
	private ArrayList<Bonk> bonkBabies;
	private ArrayList<Zap> zaps;
	
	private int bonkPopulationCount;
	private int zapPopulationCount;
	
	/**
	 * Constructor for creating a new GridWorld and setting it's X and Y sizes.
	 * Also creates the GridWorld ArrayList(S) and the bonks, bonkbabies and zaps ArrayList(S)
	 * 
	 * @param x
	 * @param y
	 */
	public GridWorld(int x, int y){
		GRID_WORLD_X_VALUE = x; //Sets the X value of grid world
		GRID_WORLD_Y_VALUE = y; //Sets the Y value of grid world
		
		gridWorld = new ArrayList[GRID_WORLD_X_VALUE][GRID_WORLD_Y_VALUE];
		bonks = new ArrayList<Bonk>();
		bonkBabies = new ArrayList<Bonk>();
		zaps = new ArrayList<Zap>();
		System.out.println("GridWorld of size [" + GRID_WORLD_X_VALUE + ", " + GRID_WORLD_Y_VALUE + "] Generated!");
		
	}
	
	/**
	 * This method adds a Bonk to GridWorld and adds 1 to the bonk population.
	 * It adds whatever Bonk has been passed in.
	 * 
	 * @param toAdd
	 */
	public void addBonk(Bonk toAdd) {
		
		bonks.add(toAdd);
		bonkPopulationCount++;		
		return;	
	}
	
	/**
	 * This method adds a Zap to GridWorld and adds 1 to the zap population.
	 * It adds whatever Zap has been passed in.
	 * 
	 * @param toAdd
	 */
	public void addZap (Zap toAdd) {
		zaps.add(toAdd);
		zapPopulationCount++;		
		return;
	}

	/**
	 * This method returns the size of the Bonk population as an int.
	 * 
	 * @return bonkPopulationCount as an int.
	 */
	public int getBonkPopulationCount() {
		return bonkPopulationCount;
	}

	/**
	 * This method sets the size of the Bonk population as whatever int
	 * was passed in.
	 * 
	 * @param bonkPopulationCount
	 */
	public void setBonkPopulationCount(int bonkPopulationCount) {
		this.bonkPopulationCount = bonkPopulationCount;
	}

	/**
	 *  This method returns the size of the Zap population as an int.
	 *  
	 * @return zapPopulationCount as an int.
	 */
	public int getZapPopulationCount() {
		return zapPopulationCount;
	}

	/**
	 * This method sets the size of the Zap population as whatever int
	 * was passed in.
	 * 
	 * @param zapPopulationCount
	 */
	public void setZapPopulationCount(int zapPopulationCount) {
		this.zapPopulationCount = zapPopulationCount;
	}

	/**
	 * This returns the entire Bonk arraylist
	 * 
	 * @return The Bonk ArrayList
	 */
	public ArrayList<Bonk> getBonks() {
		return bonks;
	}

	/**
	 * This sets the entire Bonk ArrayList to whatever Bonk
	 * ArrayList was passed in.
	 *  
	 * @param bonks
	 */
	public void setBonks(ArrayList<Bonk> bonks) {
		this.bonks = bonks;
	}

	/**
	 * This returns the entire Zap ArrayList.
	 * 
	 * @return The Zap ArrayList
	 */
	public ArrayList<Zap> getZaps() {
		return zaps;
	}
	
	/**
	 * This sets the entire Zap ArrayList to whatever Zap
	 * ArrayList was passed in.
	 * 
	 * @param zaps
	 */
	public void setZaps(ArrayList<Zap> zaps) {
		this.zaps = zaps;
	}

	/**
	 * This returns the entire Bonk Babies ArrayList.
	 * 
	 * @return The Bonk Babies ArrayList
	 */
	public ArrayList<Bonk> getBonkBabies() {
		return bonkBabies;
	}
	
	/**
	* This adds a Bonk Baby to the Bonk Babies ArrayList.
	* 
	* @param toAdd
	*/
	public void addBonkBaby(Bonk toAdd) {
		bonkBabies.add(toAdd);	
		return;
	}
	
	/**
	 * This clears the entire Bonk Babies ArrayList.
	 */
	public void clearBonkBabies() {
		bonkBabies.clear();
	}

	/**
	 * This sets the entire Bonk Babies  ArrayList to whatever Bonk Babies 
	 * ArrayList was passed in.
	 * 
	 * @param bonkBabies 
	 */
	public void setBonkBabies(ArrayList<Bonk> bonkBabies) {
		this.bonkBabies = bonkBabies;
	}

	/**
	 * This returns the GridWorld X value as an int.
	 * @return GRID_WORLD_X_VALUE as an int
	 */
	public int getGRID_WORLD_X_VALUE() {
		return GRID_WORLD_X_VALUE;
	}

	/**
	 * This returns the GridWorld Y value as an int.
	 * @return GRID_WORLD_Y_VALUE as an int
	 */
	public int getGRID_WORLD_Y_VALUE() {
		return GRID_WORLD_Y_VALUE;
	}

	/**
	 * This prints out the state of GridWorld.
	 * It prints the X and Y value of GridWorld plus all of the details
	 * of every Zap and Bonk present in GridWorld.
	 * 
	 *  @return returns a String about the state of GridWorld
	 */
	@Override
	public String toString() {
		System.out.println("GridWorld toString:");
		return "====GridWorld===="
				+ "\n GRID_WORLD_X_VALUE= " + GRID_WORLD_X_VALUE 
				+ "\n GRID_WORLD_Y_VALUE= " + GRID_WORLD_Y_VALUE
				+ "\n gridWorld= " + Arrays.toString(gridWorld) 
				+ "\n bonks= " + bonks 
				+ "\n zaps= " + zaps;		
	}	
}
