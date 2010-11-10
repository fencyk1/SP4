import java.io.File;
import java.io.IOException;
import java.util.ArrayList;


public class Simulator {

	/**
	 * 
	 * @author Everett
	 * 
	 * @param objectFileName = the name of the object file to load
	 * @throws IOException 
	 */
	public static void main(File objectFileName) throws IOException {
		
		//class object imports
		ObjectInInterface objectFile = new ObjectIn();
		
		//Read object file
		objectFile.readObjectFile(objectFileName);
		
		//get object array
		ArrayList<ArrayList<String>> objectArray = objectFile.outputObjectArray();
		
		//get start location
		
		//load program
		

	}

}
