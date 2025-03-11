import java.util.*;

public class StackSolver extends Solver {
	
	public StackSolver(Maze maze) {
		super(maze);
	}
	
	
    /*
     * uses a stack (LIFO) to find a path from wolverine's start position to the goal
     * @return list of positions representing the path, or empty if no path exists
     */
	@Override
	public List<Position> findPath(){
		Stack<Position> stack = new Stack<>();
		stack.push(maze.start);
		visited[maze.start.row][maze.start.col] = true;
		
		
		while(!stack.isEmpty()) {
			Position current = stack.pop();
			
			//TODO: implement DFS logic for pathfinding
			
		}
		
		return path;
	}
	
	
}
