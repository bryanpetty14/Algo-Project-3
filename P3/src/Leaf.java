
public class Leaf extends Node{
	char character;
	String bits;
	public Leaf(int value) {
		super(value);
		bits = "";
	}
	
	@Override
	public void addBit(String s) {
		this.bits += s;
	}
	public void setChar(char c){
		character = c;
	}
	public char getChar(){
		return character;
	}
}
