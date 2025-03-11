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
		boolean isCoordinateFormat = Arrays.asList(args).contains("--InCoordinate");
	}

}
