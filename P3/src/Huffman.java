import java.io.File;
import java.util.ArrayList;
import java.util.Collections;
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
	private static HuffmanCoding hc; 

	public static void resetVals() {
		totChars = 0;
		diffChars = 0;
		maxCodeLen = 0;
		avdCodeLen = 0;
		FileLen = 0;
		byteFileLen = 0;
		totReduc = 0;
	}

	public static void main(String[] args) {
		resetVals();
		tempArray.clear();
		String toEncode = "P3";
		huffmanEncode(toEncode);
		doEncoding();
		System.out.println("Name: " + toEncode + "\n" + "TotalChars: " + totChars + "\n" + "DiffChars: " + diffChars
				+ "\n" + "MaxCodeLen: " + maxCodeLen + "\n" + "AveCodeLen: " + avdCodeLen + "\n" + "FileLen: " + FileLen
				+ "\n" + "ByteFileLen: " + byteFileLen + "\n" + "HuffmanReduction: " + totReduc + "%\n");
		
		tempArray.clear();
		resetVals();
		
		toEncode = "Huffman Program";
		huffmanEncode(toEncode);
		doEncoding();
		System.out.println("Name: " + toEncode + "\n" + "TotalChars: " + totChars + "\n" + "DiffChars: " + diffChars
				+ "\n" + "MaxCodeLen: " + maxCodeLen + "\n" + "AveCodeLen: " + avdCodeLen + "\n" + "FileLen: " + FileLen
				+ "\n" + "ByteFileLen: " + byteFileLen + "\n" + "HuffmanReduction: " + totReduc + "%\n");
		tempArray.clear();
		resetVals();
		
		toEncode = "Mrs. Farrell Book";
		huffmanEncode(toEncode);
		doEncoding();
		System.out.println("Name: " + toEncode + "\n" + "TotalChars: " + totChars + "\n" + "DiffChars: " + diffChars
				+ "\n" + "MaxCodeLen: " + maxCodeLen + "\n" + "AveCodeLen: " + avdCodeLen + "\n" + "FileLen: " + FileLen
				+ "\n" + "ByteFileLen: " + byteFileLen + "\n" + "HuffmanReduction: " + totReduc + "%\n");
		tempArray.clear();
		resetVals();
		
		toEncode = "OneLine";
		huffmanEncode(toEncode);
		doEncoding();
		System.out.println("Name: " + toEncode + "\n" + "TotalChars: " + totChars + "\n" + "DiffChars: " + diffChars
				+ "\n" + "MaxCodeLen: " + maxCodeLen + "\n" + "AveCodeLen: " + avdCodeLen + "\n" + "FileLen: " + FileLen
				+ "\n" + "ByteFileLen: " + byteFileLen + "\n" + "HuffmanReduction: " + totReduc + "%\n");
		tempArray.clear();
		//TODO display the value like she did in the project*/
	}

	private static void doEncoding() {
		hc = new HuffmanCoding(tempArray);
		hc.encode();
		maxCodeLen = hc.getMaxCharLength();
		FileLen = hc.getFileLength();
		avdCodeLen = Math.round(((double) FileLen / totChars) * 10.0) / 10.0;
		totReduc = (Math.round((double)FileLen/(double)byteFileLen*10000))/100.0;
	}

	private static void huffmanEncode(String toEncode) {
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
								break;
							}
						}
					}
				}
			}
			if(lineCount != 0){
				Leaf aLeaf = new Leaf(lineCount);
				aLeaf.setChar('\n');
				tempArray.add(aLeaf);
			}
			diffChars = tempArray.size();
			byteFileLen = totChars*8;
		} catch (Exception e) {
			System.out.println("broke");
		} finally {
			
			if (scanner != null) {
				scanner.close();
			}
		}

	}

}
