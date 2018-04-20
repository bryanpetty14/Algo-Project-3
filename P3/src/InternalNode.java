/**
 * 
 * @author Bryan Petty, Matt Passarelli, Sam Reinhart
 *
 */
public class InternalNode extends Node {

	Node left, right;

	/**
	 * creates an internal node to be used for Huffman encoding. Has a right and
	 * left node and its weight is the combination of the right and left node
	 * weight
	 * 
	 * @param value
	 *            combination of the left and right node
	 * @param l
	 *            left node
	 * @param r
	 *            right node
	 */
	public InternalNode(int value, Node l, Node r) {
		super(value);
		left = l;
		right = r;
	}

	/**
	 * Overridden from Node, adds the appropriate bit in addition to the
	 * previous string, to each sub node
	 */
	@Override
	public void addBit(String s) {
		// TODO Auto-generated method stub
		left.addBit(s + '0');
		right.addBit(s + '1');
	}

}
