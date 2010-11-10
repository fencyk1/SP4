import java.util.ArrayList;

/**
 * This class will take a string and separate it by white space and '|'
 * 
 * @author Everett
 *
 */
public interface TokenizerInterface {

	/**
	 * This will take a string and separate it into tokens by white space.
	 * 
	 * @param line = string to be separated
	 * @return ArrayList<String> of separated tokens
	 */
	ArrayList<String> tokenizeBySpace(String line);
	
	/**
	 * This will take a string and separate it into tokens by pipes.
	 * 
	 * @param line = string to be separated
	 * @return ArrayList<String> of separated tokens.
	 */
	ArrayList<String> tokenizeByPipe(String line);
}
