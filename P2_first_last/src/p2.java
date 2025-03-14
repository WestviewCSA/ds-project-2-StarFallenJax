import java.io.IOException;
import java.util.Scanner;
import java.util.*;

public class p2 {

	public static void main(String[] args) {
	
        Scanner scanner = new Scanner(System.in);

        //ask the user to choose a solver
        System.out.println("Choose a solver method: (1) Stack (DFS), (2) Queue (BFS), (3) Optimal (Shortest Path)");
        int solverChoice;
        while (true) {
            System.out.print("Enter choice (1/2/3): ");
            if (scanner.hasNextInt()) {
                solverChoice = scanner.nextInt();
                if (solverChoice >= 1 && solverChoice <= 3) {
                	break;
                }
            }
            scanner.nextLine(); //clear invalid input
            System.out.println("Invalid input. Please enter 1, 2, or 3.");
        }

        //ask if the input file uses coordinate format
        System.out.print("Is the input file in coordinate format? (yes/no): ");
        boolean isCoordinateFormat = scanner.next().trim().equalsIgnoreCase("yes");

        //ask for the filename
        System.out.print("Enter the maze filename: ");
        String filename = scanner.next();
		

		
		
        try {
            //load the maze
            Maze maze = new Maze(filename, isCoordinateFormat);
            System.out.println("Maze loaded successfully!");

            //choose the appropriate solver
            Solver solver = switch (solverChoice) {
                case 1 -> new StackSolver(maze);  //DFS
                case 2 -> new QueueSolver(maze);  //BFS
                case 3 -> new OptimalSolver(maze); //Shortest Path
                default -> throw new IllegalStateException("Unexpected value: " + solverChoice);
            };

            //measure execution time
            long startTime = System.nanoTime();
            var solution = solver.findPath();
            long endTime = System.nanoTime();

            //display results
            if (solution.isEmpty()) {
                System.out.println("The Wolverine Store is closed.");
            } else {
                System.out.println("Solution Path:");
                for (Position pos : solution) {
                    System.out.println("+ " + pos.row + " " + pos.col);
                }
            }

            //print runtime
            System.out.printf("Total Runtime: %.6f seconds\n", (endTime - startTime) / 1e9);
            
            if (solution.isEmpty()) {
                System.out.println("The Wolverine Store is closed.");
            } else {
                maze.markPath(solution); // Mark the path in the maze
                System.out.println("\nSolved Maze:");
                maze.printMaze(); // Print the updated maze with '+'
            }

            
    

        } catch (IOException e) {
            System.err.println("Error loading maze: " + e.getMessage());
        }

        scanner.close(); 
        
        
      
    }

}
