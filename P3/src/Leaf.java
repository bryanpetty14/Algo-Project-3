/**
 * 
 * @author Bryan Petty, Matt Passarelli, Sam Reinhart
 *
 */
public class Leaf extends Node{
	char character;
	String bits;
	/**
	 * creates a leaf node that holds how often it appears in a text file
	 * @param value how often the character appears in the text file
	 */
	public Leaf(int value) {
		super(value);
		bits = "";
	}
	
	/**
	 * sets the bits of the leaf node to the given string
	 */
	@Override
	public void addBit(String s) {
		this.bits += s;
	}
	/**
	 * sets the the character of the node
	 * @param c character of the node
	 */
	public void setChar(char c){
		character = c;
	}
	/**
	 * gets the character of the node
	 * @return character of the node
	 */
	public char getChar(){
		return character;
	}
}
