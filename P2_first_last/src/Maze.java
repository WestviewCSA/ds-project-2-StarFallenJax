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
	}
	
	
    /*
     * loads the maze from a coordinate-based file
     * TODO: implement actual file reading logic
     * @param filename: the name of the input file
     * @throws IOException if there is an issue reading the file
     */
	private void loadFromCoordinates(String filename) throws IOException {
		//read file and parse coordinate-based maze representation
	}
	
	
    /*
     * checks if a given position is walkable.
     * @param x: row index.
     * @param y: column index.
     * @return true if the position is not a wall ('@') and within bounds.
     */
	public boolean isWalkable(int x, int y) {
		return (x >= 0) && (x < rows) && (y >= 0) && (y < cols) && (grid[x][y] != '@');
	}
	
	
    /*
     * prints the maze to the console for debugging
     */
	public void printMaze() {
		for(char[] row : grid) {
			System.out.println(new String(row));
		}
	}
	

}
