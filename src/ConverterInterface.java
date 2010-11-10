/**
 * Converter for converting Binary to Hex, Hex to Binary, and Decimal to Hex.
 * 
 * @author Jeff & Austin
 *
 */
public interface ConverterInterface {
	
	/**
	 * Converts a binary input to hex.
	 * 
	 * @param binary The binary input to be turned into hex.
	 * @return The hex equivalent of the input in String format.
	 */
	String binaryToHex(String binary);
	
	/**
	 * Converts a hex input to binary.
	 * 
	 * @param hex The hex input to be converted to binary.
	 * @return The binary equivalent of the hex input in String format.
	 */
	String hexToBinary(String hex);
	
	/**
	 * Converts a decimal integer into hex.
	 * 
	 * @param decimal The decimal integer to be converted to hex.
	 * @return The hex equivalent of the decimal integer input in String format.
	 */
	String decimalToHex(String decimal);
	
	/**
	 * Converts a binary number into a decimal integer.
	 * 
	 * @param binary The binary number to be converted into decimal representation.
	 * @return The decimal equivalent of the binary input in int format.
	 */
	String binaryToDecimal(String binary);
	
	/**
	 * Converts a decimal integer into a binary number.
	 * 
	 * @param decimal The decimal integer to be converted into binary representation.
	 * @return The binary equivalent of the decimal input in String format.
	 */
	String decimalToBinary(String decimal);
	
	/**
	 * Converts an ascii string into its binary representation.
	 * 
	 * @param ascii The string to be converted into binary.
	 * @return The binary representation of an ascii string.
	 */
	String asciiToBinary(String ascii);
	
	/**
	 * Converts a two's complement string into an integer.
	 * 
	 * @param twos The two's complement representation of the integer in question.
	 * @return The integer representation of the two's complement value.
	 */
	String twosCompToInteger(String twos);

	/**
	 * Converts a hex string to a decimal string
	 * 
	 * @param hex string to be converted
	 * @return decimal equivalent
	 */
	String hexToDec(String hex);
	
	
}
