import java.util.ArrayList;
import java.util.StringTokenizer;


public class Tokenizer implements TokenizerInterface {
	private ArrayList<String> pipeArray;
	private ArrayList<String> spaceArray;

	@Override
	public void tokenizeBySpace(String line) {

		
		//create a new tokenizer using line
		StringTokenizer bySpace = new StringTokenizer(line);
		
		//set variable tokenCount to be the number of tokens produced
		int tokenCount = bySpace.countTokens();
		
		//constuct the holding array
		spaceArray = new ArrayList<String>(tokenCount);
		
		//add the tokens to the array
		for(int inc =0; inc < tokenCount; inc++)
		{
			pipeArray.add(inc, bySpace.nextToken());
		}
	}

	@Override
	public void tokenizeByPipe(String line) {
		
		//create a delimiter for the tokenizer
		String dlmtr = "|";
		
		//create a new tokenizer using dlmtr and line
		StringTokenizer byPipe = new StringTokenizer(line, dlmtr);
		
		//set variable tokenCount to be the number of tokens produced
		int tokenCount = byPipe.countTokens();
		
		//constuct the holding array
		pipeArray = new ArrayList<String>(tokenCount);
		
		//add the tokens to the array
		for(int inc =0; inc < tokenCount; inc++)
		{
			pipeArray.add(inc, byPipe.nextToken());
		}
		

	}

	@Override
	public ArrayList<String> tokenize(String line) {
		// TODO Auto-generated method stub
		return null;
	}

}
