
public abstract class Node 
	extends java.lang.Object
	implements java.lang.Comparable<Node> {
	
	protected int weight;
	
	public Node(int value) {
		weight = value;
	}
	
	public abstract void addBit(String s);
	
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
