import java.util.*;

//abstract class for different maze-solving strategies	
public abstract class Solver {
	protected Maze maze; //reference to the maze
	protected boolean[][] visited; //tracks visited positions
	protected List<Position> path; //stores final path
		
	/*
	 * constructor to init a solver
	 * @param maze: the maze to be solved
	 */
	public Solver(Maze maze) {
		this.maze = maze;
		this.visited = new boolean[maze.rows][maze.cols];
		this.path = new ArrayList<>();
	}
	
    /**
     * abstract method to find a path to the goal
     * @return list of positions forming the path
     */
    public abstract List<Position> findPath();
		
		
}


