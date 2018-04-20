import java.util.ArrayList;
import java.util.HashMap;
import java.util.PriorityQueue;

/**
 * 
 * @author Bryan Petty, Matt Passarelli, Sam Reinhart
 *
 */
public class HuffmanCoding {
	private PriorityQueue<Node> pq;
	private HashMap<Character, String> hm;
	private ArrayList<Node> myList;

	/**
	 * creates a new huffman coding class by making a priority queue with the
	 * ArrayList passed to it. The array list holds the Leafs of a newly parsed
	 * file
	 * 
	 * @param al
	 *            ArrayList of Leafs that hold the weights and characters of a
	 *            file
	 */
	public HuffmanCoding(ArrayList<Leaf> al) {
		pq = new PriorityQueue<Node>(al);
		hm = new HashMap<Character, String>();
		myList = new ArrayList<Node>();
	}

	/**
	 * a way to access the private HashMap
	 * 
	 * @return the HashMap that holds the code for each character in a file
	 *         after encoding
	 */
	public HashMap<Character, String> getHashMap() {
		return hm;
	}

	/**
	 * calculates the max length of a code for a character after encoding
	 * 
	 * @return max code length of character after encoding
	 */
	public int getMaxCharLength() {
		int temp = 0;

		for (Character str : hm.keySet()) {
			if (hm.get(str).length() > temp) {
				temp = hm.get(str).length();
			}
		}

		return temp;
	}

	/**
	 * calculates the length of a file after the encoding has taken place
	 * 
	 * @return length of the encoded file
	 */
	public int getFileLength() {

		int rtn = 0;

		for (int i = 0; i < myList.size(); i++) {
			Leaf leaf = (Leaf) myList.get(i);
			rtn += myList.get(i).weight * leaf.bits.length();
		}

		return rtn;
	}

	/**
	 * Performs Huffman encoding of the priority queue. If the queue is empty,
	 * does nothing. If the queue has one element, it makes the code of the
	 * element 0.
	 */
	public void encode() {
		int listSize = pq.size();
		if (listSize == 0) {
			return;
		} else if (pq.size() == 1) {
			pq.peek().addBit("0");
		} else {
			while (pq.size() != 1) {
				Node left = pq.poll();
				Node right = pq.poll();
				InternalNode in = new InternalNode(left.weight + right.weight, left, right);
				pq.add(in);
			}
			pq.peek().addBit("");
		}
		myList.add(pq.poll());
		while (myList.size() != listSize) {
			for (int i = 0; i < myList.size(); i++) {
				if (myList.get(i) instanceof InternalNode) {
					InternalNode in = (InternalNode) myList.remove(i);
					myList.add(in.left);
					myList.add(in.right);
					i--;
				}
			}
		}
		for (int i = 0; i < myList.size(); i++) {
			Leaf tempNode = (Leaf) myList.get(i);
			hm.put(tempNode.getChar(), tempNode.bits);
		}
	}
}