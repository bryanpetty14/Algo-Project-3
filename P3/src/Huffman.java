import java.io.File;
import java.util.ArrayList;
import java.util.Scanner;

/**
 * Huffman class for calling all methods and testing class
 * 
 * @author Bryan Petty
 * @author Matt Passarelli
 * @author Sam Reinhart
 */
public class Huffman
{
	public static int totChars = 0;
	public static int diffChars = 0;
	public static int maxCodeLen = 0;
	public static double avdCodeLen = 0;
	public static int FileLen = 0;
	public static int byteFileLen = 0;
	public static double totReduc = 0;
	private static ArrayList<Leaf> tempArray = new ArrayList<Leaf>();

	/**
	 * Resets all field Variables
	 */
	public void resetVals()
	{
		totChars = 0;
		diffChars = 0;
		maxCodeLen = 0;
		avdCodeLen = 0;
		FileLen = 0;
		byteFileLen = 0;
		totReduc = 0;
	}

	public static void main(String[] args)
	{
		tempArray.clear();
		String toEncode = "OneLine";
		huffmanEncode(toEncode);
		doEncoding();
		// TODO display the value like she did in the project

		System.out.println("Name: " + toEncode + "\n" + "TotalChars: " + totChars + "\n" + "DiffChars: " + diffChars
				+ "\n" + "MaxCodeLen: " + maxCodeLen + "\n" + "AveCodeLen: " + avdCodeLen + "\n" + "FileLen: " + FileLen
				+ "\n" + "ByteFileLen: " + byteFileLen + "\n" + "HuffmanReduction: " + totReduc + "\n");

		tempArray.clear();
	}

	/**
	 * Does the encoding by call HuffmanCoding's encode method. ALso sets needed
	 * variables from public methods in HuffmanCoding
	 */
	private static void doEncoding()
	{
		HuffmanCoding hc = new HuffmanCoding(tempArray);
		hc.encode();

		maxCodeLen = hc.getMaxCharLength();
		avdCodeLen = Math.round(((double) hc.getFileLength() / totChars) * 10.0) / 10.0;
		FileLen = hc.getFileLength();
		totReduc = (double) FileLen / (double) byteFileLen;

		// this ugly line just rounds it to 4 decimal places so that when we
		// move the decimal eventually, we don't need to round then
		totReduc = Math.round(totReduc * 10000.0) / 10000.0;
	}

	private static void huffmanEncode(String toEncode)
	{
		File temp = new File(toEncode);
		Scanner scanner = null;
		try
		{
			scanner = new Scanner(temp);
			int lineCount = 0;
			while(scanner.hasNextLine())
			{
				String line = scanner.nextLine();
				lineCount++;
				totChars += line.length() + 1;
				for(int i = 0; i < line.length(); i++)
				{
					if(tempArray.size() == 0)
					{
						Leaf aLeaf = new Leaf(1);
						aLeaf.setChar(line.charAt(i));
						tempArray.add(aLeaf);
					}
					else
					{
						for(int j = 0; j < tempArray.size(); j++)
						{
							if(tempArray.get(j).getChar() == line.charAt(i))
							{
								tempArray.get(j).incWeight();
								break;
							}
							if(j + 1 == tempArray.size())
							{
								Leaf aLeaf = new Leaf(1);
								aLeaf.setChar(line.charAt(i));
								tempArray.add(aLeaf);
								break;
							}
						}
					}
				}
			}
			if(lineCount != 0)
			{
				Leaf aLeaf = new Leaf(lineCount);
				aLeaf.setChar('\n');
				tempArray.add(aLeaf);
			}
			diffChars = tempArray.size();
			byteFileLen = totChars * 8;
		}
		catch(Exception e)
		{
			System.out.println("broke");
		}
		finally
		{

			if(scanner != null)
			{
				scanner.close();
			}
		}

	}

}
