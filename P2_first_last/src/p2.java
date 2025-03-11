import java.io.IOException;
import java.util.*;

public class p2 {

	public static void main(String[] args) {
		//make sure there are correct arguments
		if(args.length < 2) {
			System.out.println("Usage: java p2 --Stack|--Queue|--Opt filename");
			System.exit(-1);
		}
		
		//check which solver to use
		boolean useStack = Arrays.asList(args).contains("--Stack");
		boolean useQueue = Arrays.asList(args).contains("--Queue");
		boolean useOpt = Arrays.asList(args).contains("--Opt");
		boolean isCoordinateFormat = Arrays.asList(args).contains("--Incoordinate");
		
		//make sure only one solver is selected
		if((useStack ? 1 : 0) + (useQueue ? 1 : 0) + (useOpt ? 1 : 0) != 1) {
			System.out.println("Error: Specify exactly one of --Stack, --Queue, or --Opt.");
			System.exit(-1);
		}
		
		
		try {
			
			//load the maze
			Maze maze = new Maze(args[args.length - 1], isCoordinateFormat);
			
			//select the appropriate solver
			Solver solver = useStack ? new StackSolver(maze) :
							useQueue ? new QueueSolver(maze) :
							new OptimalSolver(maze);
			
			//calculate time
			long startTime = System.nanoTime();
			List<Position> solution = solver.findPath();
			long endTime = System.nanoTime();
			
			//print solution/failure
			if(solution.isEmpty()) {
				System.out.println("The Wolverine Store is closed.");
			} else {
				for (Position pos : solution) {
					System.out.println("+ " + pos.row + " " + pos.col);
				}
			}
			
			//print runtime if the flag is set
			if(Arrays.asList(args).contains("--Time")) {
				System.out.printf("Total Runtime: %.6f seconds\n", (endTime - startTime) / 1e9);
			}
				
		} catch(IOException e) {
			System.err.println("Error loading maze: " + e.getMessage());
		}
	}

}
