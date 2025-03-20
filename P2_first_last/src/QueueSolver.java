import java.util.*;

public class QueueSolver extends Solver {

    public QueueSolver(Maze maze) {
        super(maze);
    }

    /*
     * uses BFS (queue-based) to find the shortest path from Wolverine's start position to the goal.
     * @return List of positions representing the shortest path, or an empty list if no path exists.
     */
    @Override
    public List<Position> findPath() {
        Queue<List<Position>> queue = new LinkedList<>(); // queue stores paths
        List<Position> startPath = new ArrayList<>();
        startPath.add(maze.start);
        queue.add(startPath);

        int[][] directions = { {-1, 0}, {1, 0}, {0, -1}, {0, 1} }; // N, S, W, E (directions)

        while (!queue.isEmpty()) {
            List<Position> path = queue.poll();
            Position current = path.get(path.size() - 1); // Get last position

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
                    queue.add(newPath);
                    visited[newRow][newCol] = true; //mark immediately to avoid re-processing
                }
            }
        }

        //no path found
        return new ArrayList<>();
    }
}

