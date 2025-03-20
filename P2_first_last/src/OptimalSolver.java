import java.util.*;

public class OptimalSolver extends Solver {

    public OptimalSolver(Maze maze) {
        super(maze);
    }

    /*
     * uses an optimized BFS to find the shortest path from Wolverine's start position to the goal
     * @return Array of positions representing the shortest path, or an empty array if no path exists
     */
    @Override
    public List<Position> findPath() {
        Queue<Position> queue = new LinkedList<>();
        Position[][] parent = new Position[maze.rows][maze.cols]; //stores parent positions for path reconstruction

        queue.add(maze.start);
        visited[maze.start.row][maze.start.col] = true;

        int[][] directions = { {-1, 0}, {1, 0}, {0, -1}, {0, 1} }; // N, S, W, E (directions)

        while (!queue.isEmpty()) {
            Position current = queue.poll();

            //if we reach the goal, reconstruct and return the shortest path
            if (current.row == maze.goal.row && current.col == maze.goal.col) {
                return reconstructPath(parent, maze.start, current);
            }

            //explore all 4 directions
            for (int i = 0; i < 4; i++) {
                int newRow = current.row + directions[i][0];
                int newCol = current.col + directions[i][1];

                if (maze.isWalkable(newRow, newCol) && !visited[newRow][newCol]) {
                    queue.add(new Position(newRow, newCol));
                    visited[newRow][newCol] = true;
                    parent[newRow][newCol] = current; //track how we got here
                }
            }
        }

        //no path found
        return new ArrayList<>();
    }

    /*
     * reconstructs the shortest path from start to goal using the parent matrix
     * @param parent A 2D array storing previous positions
     * @param start The starting position
     * @param end The goal position
     * @return The reconstructed shortest path from start to goal
     */
    private List<Position> reconstructPath(Position[][] parent, Position start, Position end) {
        List<Position> path = new ArrayList<>();
        Position current = end;

        //fllow parent links to construct the path
        while (current != null && !(current.row == start.row && current.col == start.col)) {
            path.add(0, current); //insert at the beginning (avoids reversing later)
            current = parent[current.row][current.col];
        }

        //add the start position manually
        path.add(0, start);
        return path;
    }
}
