import java.io.File;
import java.util.ArrayList;
import java.util.Scanner;

public class Huffman {
	public static int totChars = 0;
	public static int diffChars = 0;
	public static int maxCodeLen = 0;
	public static double avdCodeLen = 0;
	public static int FileLen = 0;
	public static int byteFileLen = 0;
	public static double totReduc = 0;
	private static ArrayList<Leaf> tempArray = new ArrayList<Leaf>();

	public void resetVals() {
		totChars = 0;
		diffChars = 0;
		maxCodeLen = 0;
		avdCodeLen = 0;
		FileLen = 0;
		byteFileLen = 0;
		totReduc = 0;
	}

	public static void main(String[] args) {
		tempArray.clear();
		String toEncode = "Untitled 1";
		huffmanEncode(toEncode);
		doEncoding();
		tempArray.clear();
	}

	private static void doEncoding() {
		
		HuffmanCoding hc = new HuffmanCoding(tempArray);
		maxCodeLen = hc.getMaxCharLength();
		
	}

	private static void huffmanEncode(String toEncode) {
		// TODO Auto-generated method stub
		File temp = new File(toEncode);
		Scanner scanner = null;
		try {
			scanner = new Scanner(temp);
			int lineCount = 0;
			while (scanner.hasNextLine()) {
				String line = scanner.nextLine();
				lineCount++;
				totChars += line.length() + 1;
				for (int i = 0; i < line.length(); i++) {
					if (tempArray.size() == 0) {
						Leaf aLeaf = new Leaf(1);
						aLeaf.setChar(line.charAt(i));
						tempArray.add(aLeaf);
					} else {
						for (int j = 0; j < tempArray.size(); j++) {
							if (tempArray.get(j).getChar() == line.charAt(i)) {
								tempArray.get(j).incWeight();
								break;
							}
							if (j + 1 == tempArray.size()) {
								Leaf aLeaf = new Leaf(1);
								aLeaf.setChar(line.charAt(i));
								tempArray.add(aLeaf);
							}
						}
					}
				}
				if(lineCount != 0){
					Leaf aLeaf = new Leaf(lineCount);
					aLeaf.setChar('\n');
					tempArray.add(aLeaf);
				}
				System.out.println(tempArray.toString());
				diffChars = tempArray.size();
				byteFileLen = diffChars*8;
			}
		} catch (Exception e) {
			System.out.println("broke");
		} finally {
			if (scanner != null) {
				scanner.close();
			}
		}

	}

}
