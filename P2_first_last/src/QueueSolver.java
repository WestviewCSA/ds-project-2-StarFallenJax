import java.util.*;

public class QueueSolver extends Solver {
	
	public QueueSolver(Maze maze) {
		super(maze);
	}
	
	
    /*
     * uses a queue (FIFO) to find a path from wolverine's start position to the goal
     * @return list of positions representing the path, or empty if no path exists
     */
	@Override
	public List<Position> findPath(){
		Queue<Position> queue = new LinkedList<>();
		queue.add(maze.start);
		visited[maze.start.row][maze.start.col] = true;
		
		
		while(!queue.isEmpty()) {
			Position current = queue.poll();
			
			//TODO: implement BFS logic for pathfinding
			
		}
		
		return path;
	}
	
	
}
