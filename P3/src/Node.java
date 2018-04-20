/**
 * 
 * @author Bryan Petty, Matt Passarelli, Sam Reinhart
 *
 */
public abstract class Node 
	extends java.lang.Object
	implements java.lang.Comparable<Node> {
	
	protected int weight;
	
	/**
	 * creates a node with a weight of how often the character of sub nodes appear
	 * @param value how often the character or sub nodes appear
	 */
	public Node(int value) {
		weight = value;
	}
	
	/**
	 * called in the sub classes to set the bit string of the leaf nodes
	 * @param s
	 */
	public abstract void addBit(String s);
	
	/**
	 * used to compare two nodes weights for sorting
	 */
	public int compareTo(Node that){
		if(that.weight == this.weight){
			return 0;
		}else if(that.weight > this.weight){
			return -1;
		}
		return 1;
	}
	public void incWeight(){
		weight++;
	}
}
