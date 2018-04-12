
public class InternalNode extends Node{
	
	Node left, right;
	
	public InternalNode(int value, Node l, Node r) {
		super(value);
		left = l;
		right = r;
	}

	@Override
	public void addBit(String s) {
		// TODO Auto-generated method stub
		left.addBit(s);
		right.addBit(s);
	}

}
