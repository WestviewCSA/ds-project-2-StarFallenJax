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
	public List<Position> findPath() {
        Stack<List<Position>> stack = new Stack<>(); //stack stores paths
        List<Position> startPath = new ArrayList<>();
        startPath.add(maze.start);
        stack.push(startPath);

        int[][] directions = { {-1, 0}, {1, 0}, {0, -1}, {0, 1} }; // N, S, W, E (directions)

        while (!stack.isEmpty()) {
            List<Position> path = stack.pop();
            Position current = path.get(path.size() - 1); //get last position

            //if we reach the goal, return the path
            if (current.row == maze.goal.row && current.col == maze.goal.col) {
                return path;
            }

            //mark position as visited
            visited[current.row][current.col] = true;

            //explore all 4 directions
            for (int i = 0; i < 4; i++) {
                int newRow = current.row + directions[i][0];
                int newCol = current.col + directions[i][1];

                if (maze.isWalkable(newRow, newCol) && !visited[newRow][newCol]) {
                    List<Position> newPath = new ArrayList<>(path);
                    newPath.add(new Position(newRow, newCol));
                    stack.push(newPath);
                }
            }
        }

        //no path found
        return new ArrayList<>();
    }
	
	
}
