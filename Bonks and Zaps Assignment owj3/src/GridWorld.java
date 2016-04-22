import java.util.ArrayList;

public class GridWorld {

	private final int GRID_WORLD_X_VALUE; //The X value of GridWorld	
	private final int GRID_WORLD_Y_VALUE; //The Y value of GridWorld
	
	private ArrayList<Being>[][] gridWorld;
	
	public GridWorld(int x, int y){
		GRID_WORLD_X_VALUE = x; //Sets the X value of grid world
		GRID_WORLD_Y_VALUE = y; //Sets the Y value of grid world
		gridWorld = new ArrayList[GRID_WORLD_X_VALUE][GRID_WORLD_Y_VALUE];
		
	}
	
	
	
	
	
}
