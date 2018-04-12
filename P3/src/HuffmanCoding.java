import java.util.ArrayList;
import java.util.PriorityQueue;

public class HuffmanCoding {
	PriorityQueue<Node> pq;

	public HuffmanCoding(ArrayList<Leaf> al){
		pq = new PriorityQueue<Node>();
		for(int i = 0; i<al.size(); i++){
			pq.add(al.get(i));
		}
	}
	public void addLine(String s){
		Leaf temp = new Leaf(0);
		for(int i = 0; i<s.length();i++){
		}
	}
	public int getMaxCharLength() {
		// TODO return the max length of the bit strings created
		return 0;
	}
}
