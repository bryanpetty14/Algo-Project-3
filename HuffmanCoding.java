import java.util.ArrayList;
import java.util.HashMap;
import java.util.PriorityQueue;

public class HuffmanCoding
{
	private PriorityQueue<Node> pq;
	private HashMap<Character, String> hm;
	private ArrayList<Node> myList;

	public HuffmanCoding(ArrayList<Leaf> al)
	{
		pq = new PriorityQueue<Node>(al);
		hm = new HashMap<Character, String>();
		myList = new ArrayList<Node>();
	}

	public int getMaxCharLength()
	{
		int temp = 0;

		for(Character str : hm.keySet())
		{
			if(hm.get(str).length() > temp)
			{
				temp = hm.get(str).length();
			}
		}

		return temp;
	}

	public double getAverage()
	{
		// TODO return the average amount of bits per leaf
		return 0;
	}

	public int getFileLength()
	{
		// TODO return the length of the compressed file
		return 0;
	}

	public void encode()
	{
		int listSize = pq.size();
		// TODO Auto-generated method stub
		if(pq.size() == 1)
		{
			pq.peek().addBit("0");
		}
		else
		{
			while(pq.size() != 1)
			{
				Node left = pq.poll();
				Node right = pq.poll();
				InternalNode in = new InternalNode(left.weight + right.weight, left, right);
				pq.add(in);
			}
			pq.peek().addBit("");
		}
		myList.add(pq.poll());
		while(myList.size() != listSize)
		{
			for(int i = 0; i < myList.size(); i++)
			{
				if(myList.get(i) instanceof InternalNode)
				{
					InternalNode in = (InternalNode) myList.remove(i);
					myList.add(in.left);
					myList.add(in.right);
					i--;
				}
			}
		}
		for(int i = 0; i < myList.size(); i++)
		{
			Leaf tempNode = (Leaf) myList.get(i);
			hm.put(tempNode.getChar(), tempNode.bits);
		}
	}
}
