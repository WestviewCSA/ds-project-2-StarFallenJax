
public class Position {
	
	public int row, col; //row and col indexes
	
	public Position(int row, int col) {
		this.row = row;
		this.col = col;
	}
	
	
	//checks if two positions are equal
	//returns true if they are the same position
	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}
		
		if(!(obj instanceof Position)) {
			return false;
		}
		
		Position other = (Position) obj;
		return this.row == other.row && this.col == other.col;
	}
	
	//returns a string representation of the position
	@Override
	public String toString() {
		return "(" + row + ", " + col + ")";
	}
	
	

}
