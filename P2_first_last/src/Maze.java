import java.io.*;
import java.util.*;
public class Maze {
	
	public char[][] grid; //2D array storing the maze structure
	public int rows, cols; //maze dimensions
	public Position start, goal, walkway; //important positions in maze
	
	
	/*
	 * @param filename: the name of the input file
	 * @param isCoordinateFormat: whether the file uses a coordinate format
	 * @throws IOException if there is an issue reading file
	 */
	public Maze(String filename, boolean isCoordinateFormat) throws IOException { //throw exception if there is an issue reading file
		if(isCoordinateFormat) {
			loadFromCoordinates(filename);
		}else {
			loadFromText(filename);
		}
	}
	
	
	/*
	 * loads the maze from a text based file
	 * TODO: implement actual file reading logic
	 * @param filename: the name of the input file
	 * @throws IOException if there is an issue reading file
	 */
	private void loadFromText(String filename) throws IOException {
		//read file and parse the text-based maze representation
		Scanner scanner = new Scanner(new File(filename));
		
		//read the first line for the sauce
		rows = scanner.nextInt();
		cols = scanner.nextInt();
		int numMazes = scanner.nextInt(); //not used yet
		scanner.nextLine(); //move to the next line
		
		//init the maze grid
		grid = new char[rows][cols];
		
		//read the maze line by line
		for(int i = 0; i < rows; i++) {
			
			String line = scanner.nextLine();
			
			for(int j = 0; j < cols; j++) {
				
				grid[i][j] = line.charAt(j);
					
                //store important positions
                if (grid[i][j] == 'W') {
                    start = new Position(i, j);
                } else if (grid[i][j] == '$') {
                    goal = new Position(i, j);
                } else if (grid[i][j] == '|') {
                    walkway = new Position(i, j);
                }
			}
		}
		
		scanner.close();
	}
	
	
    /*
     * loads the maze from a coordinate-based file
     * TODO: implement actual file reading logic
     * @param filename: the name of the input file
     * @throws IOException if there is an issue reading the file
     */
    private void loadFromCoordinates(String filename) throws IOException {
        Scanner scanner = new Scanner(new File(filename));

        //read the first line for the sauce
        rows = scanner.nextInt();
        cols = scanner.nextInt();
        int numMazes = scanner.nextInt(); //not used yet
        scanner.nextLine(); //move to the next line

        //initialize the grid with empty spaces
        grid = new char[rows][cols];
        for (char[] row : grid) Arrays.fill(row, '.');

        //read each coordinate line
        while (scanner.hasNext()) {
            char symbol = scanner.next().charAt(0);
            int row = scanner.nextInt();
            int col = scanner.nextInt();
            int mazeLevel = scanner.nextInt(); //not used yet

            //place the symbol in the grid
            grid[row][col] = symbol;

            //store important positions
            if (symbol == 'W') {
                start = new Position(row, col);
            } else if (symbol == '$') {
                goal = new Position(row, col);
            } else if (symbol == '|') {
                walkway = new Position(row, col);
            }
        }

        scanner.close();
    }
	
	
    /*
     * checks if a given position is walkable
     * @param x: row index
     * @param y: column index
     * @return true if the position is not a wall ('@') and within bounds
     */
	public boolean isWalkable(int x, int y) {
		return (x >= 0) && (x < rows) && (y >= 0) && (y < cols) && (grid[x][y] != '@');
	}
	
	
    /*
     * marks the found path in the maze using '+'
     * @param path The list of positions forming the solution path
     */
    public void markPath(List<Position> path) {
        for (Position pos : path) {
            if (grid[pos.row][pos.col] != 'W' && grid[pos.row][pos.col] != '$') {
                grid[pos.row][pos.col] = '+'; //mark the path
            }
        }
    }

    /*
     * prints the maze to the console for visualization
     */
    public void printMaze() {
        for (char[] row : grid) {
            System.out.println(new String(row));
        }
    }
	

}
