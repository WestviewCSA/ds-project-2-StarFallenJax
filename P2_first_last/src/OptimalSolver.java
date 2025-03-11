import java.util.*;

public class OptimalSolver extends Solver {
	
	public OptimalSolver(Maze maze) {
		super(maze);
	}
	
	
    /*
     * uses an optimal pathfinding algorithm to find the shortest path
     * @return list of positions representing the shortest path, or none
     */
	@Override
	public List<Position> findPath(){
		// TODO: implement the shortest path algorithm
		return path;
	}
	
	
}
