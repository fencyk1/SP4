import java.io.File;
import java.io.IOException;
import java.util.ArrayList;


public class Simulator {
	//create global variable to act as memory
	static String[] MEM = new String[65536];

	
	
	/**
	 * 
	 * @author Everett
	 * 
	 * @param objectFileName = the name of the object file to load
	 * @throws IOException 
	 */
	public static void main(String[] args) throws IOException {
		String[] REG = new String[16];
		boolean isHalt = false;
		int LC = 0;
		int PC = 0;
		int NIC = 0;
		int EFFADDR =0;
		String IWR = null;
		
		
		
		
		//class object imports
		ObjectInInterface objectFile = new ObjectIn();
		
		//make objecFileName from args
		File objectFileName = new File(args[0]);

		
		//Read object file
		objectFile.readObjectFile(objectFileName);
		
		//initialize MEM array
		for(int inc = 0; inc < 65536; inc++)
		{
			
			//create string containing halt in hex
			String hexCode = "200";
			
			//create hex code for position
			String pos = Converter.decimalToHex(Integer.toString(inc));
			
			// extend pos to 5 hex digits by prepending 0s
			while(pos.length() < 5)
			{
				pos = "0" + pos;
			}
			
			//complete hex code
			hexCode = hexCode + pos;
			
			//add hexcode to MEM at inc
			MEM[inc] = hexCode;
			
		}
		
		//print Initial MEM content
		System.out.println("Intial MEM contents:");
		for(int inc = 0; inc < 65536; inc += 8)
		{
			
			//output 4 sets of hexcode
			System.out.print(MEM[inc] + "\t" + MEM[inc+1] + "\t");
			System.out.print(MEM[inc+2] + "\t" + MEM[inc+3] + "\t");
			System.out.print(MEM[inc+4] + "\t" + MEM[inc+5] + "\t");
			System.out.println(MEM[inc+6] + "\t" + MEM[inc+7] + "\t");
		}
		
		
		
		//get object array
		ArrayList<ArrayList<String>> objectArray = objectFile.outputObjectArray();

		
		//load MEM
		for(int inc = 0; inc < objectArray.size(); inc++)
		{
			
			//create ArrayList<String> that is the line
			ArrayList<String> line = objectArray.get(inc);
			
			//check line has length greater than 1	
			if (line.size() > 1)
			{
				
				if(line.get(0).equalsIgnoreCase("LT"))
				{
					
					//create address variable
					int address = Integer.parseInt(Converter.hexToDec(line.get(1)));
					
					//load MEM
					MEM[address] = line.get(2);
					
				}
				
			}
			
			//else there is an improper object file conversion
			else
			{				
				//print error message
				System.out.println("There is an improper object file.");
			}
			
		}
		
		
		/**
		//get execution start address
		String startHex = objectArray.get(0).get(1);
		
		//convert start address to decimal
		int execStart = Integer.parseInt(converter.hexToDec(startHex));
		
		
		
		//start exec. case select by opcode
		while( !isHalt )
		{
			
			
			
			
			
			
			
		}
		
		**/
		
		//get opcode and convert to integer
		
		//start case select
		
		

		
		/**
		//print final MEM content
		System.out.println("Final MEM contents:");
		for(int inc = 0; inc < 65536; inc += 8)
		{
			
			//output 4 sets of hexcode
			System.out.print(MEM[inc] + "\t" + MEM[inc+1] + "\t");
			System.out.print(MEM[inc+2] + "\t" + MEM[inc+3] + "\t");
			System.out.print(MEM[inc+4] + "\t" + MEM[inc+5] + "\t");
			System.out.println(MEM[inc+6] + "\t" + MEM[inc+7] + "\t");
		}
		**/
		
		
		
	}
	
	/**
	 * This is a function to get the effaddr of a instruction
	 * 
	 * @param code = binary code of instruction
	 */
	static int EFFADDR(String code)
	{
		
		Integer effaddr = 0;
		
		//check the address code
		//if direct or relative
		if ( code.substring(6, 8).equals("00") || code.substring(6, 8).equals("10"))
		{
			
			//get s field into effaddr
			effaddr =  Integer.parseInt(Converter.binaryToDecimal(code.substring(16, 32)));
			
			//add in index register			
			effaddr = effaddr + Integer.parseInt(Converter.binaryToDecimal(code.substring(11, 14)));
			
		}
		
		//if indirect
		else if ( code.substring(7, 8).equals("01"))
		{
			
			//get s field into effaddr
			effaddr =  Integer.parseInt(Converter.binaryToDecimal(code.substring(16, 32)));
			
			//get mem contents at sfield
			effaddr = Integer.parseInt(Converter.hexToDec(MEM[effaddr]));
			
			//add in index register			
			effaddr = effaddr + Integer.parseInt(Converter.binaryToDecimal(code.substring(11, 14)));
		}
		
		// if immediate get decimal equivalent to mem address
		else if ( code.substring(7, 8).equals("11") )
		{
			effaddr =  Integer.parseInt(Converter.binaryToDecimal(code.substring(16, 32)));
		}
		
		
		//QUESTION: SHould we check out of bounds here or in program?
		
		return effaddr;
	}
	

}



