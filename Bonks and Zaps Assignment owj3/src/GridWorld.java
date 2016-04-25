import java.util.ArrayList;
import java.util.Arrays;

//DOIT

public class GridWorld {

	private final int GRID_WORLD_X_VALUE; //The X value of GridWorld	
	private final int GRID_WORLD_Y_VALUE; //The Y value of GridWorld
	
	private ArrayList<Being>[][] gridWorld;
	private ArrayList<Bonk> bonks;
	private ArrayList<Zap> zaps;
	
	private int bonkPopulationCount;
	private int zapPopulationCount;
	
	
	public GridWorld(int x, int y){
		GRID_WORLD_X_VALUE = x; //Sets the X value of grid world
		GRID_WORLD_Y_VALUE = y; //Sets the Y value of grid world
		
		gridWorld = new ArrayList[GRID_WORLD_X_VALUE][GRID_WORLD_Y_VALUE];
		bonks = new ArrayList<Bonk>();
		zaps = new ArrayList<Zap>();
		System.out.println("GridWorld Generated!");
		
	}
	
	public Bonk addBonk(Bonk toAdd) {
		
		bonks.add(toAdd);
		
		return toAdd;	
	}
	
	public Zap addZap (Zap toAdd) {
		zaps.add(toAdd);
		
		return toAdd;
	}

	public int getBonkPopulationCount() {
		return bonkPopulationCount;
	}

	public void setBonkPopulationCount(int bonkPopulationCount) {
		this.bonkPopulationCount = bonkPopulationCount;
	}

	public int getZapPopulationCount() {
		return zapPopulationCount;
	}

	public void setZapPopulationCount(int zapPopulationCount) {
		this.zapPopulationCount = zapPopulationCount;
	}

	public ArrayList<Bonk> getBonks() {
		return bonks;
	}

	public ArrayList<Zap> getZaps() {
		return zaps;
	}

	public int getGRID_WORLD_X_VALUE() {
		return GRID_WORLD_X_VALUE;
	}

	public int getGRID_WORLD_Y_VALUE() {
		return GRID_WORLD_Y_VALUE;
	}

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
	
	public String gridWorldState() {
		return bonks + "\n zaps= " + zaps;
	}
	
}
