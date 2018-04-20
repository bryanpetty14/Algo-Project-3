import java.io.File;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Scanner;

/**
 * 
 * @author Bryan Petty, Matt Passarelli, Sam Reinhart
 *
 */
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
	public static String reduc;
	public static String space;

	/**
	 * resets all of the static values used to calculate and hold the report
	 * information
	 */
	public static void resetVals() {
		totChars = 0;
		diffChars = 0;
		maxCodeLen = 0;
		avdCodeLen = 0;
		FileLen = 0;
		byteFileLen = 0;
		totReduc = 0;
	}

	/**
	 * encodes each text file then displays them in a formatted report
	 * 
	 * @param args
	 *            not used
	 */
	public static void main(String[] args) {
		resetVals();
		tempArray.clear();
		String toEncode = "P3Text";
		HashMap<Character, String> hashM;
		huffmanEncode(toEncode);
		doEncoding();
		char tempChar;
		reduc = "%" + Double.toString(totReduc);
		hashM = hc.getHashMap();

		System.out.print(String.format("%-1s %-1s %-1s %-1s %-1s %-1s %-1s %-1s %n", "Name", "TotalChars", "Diffchars",
				"MaxCodeLen", "AveCodeLen", "FileLen", "ByteFileLen", "HuffmanReduction"));
		System.out.println(String.format("%4s %10s %9s %10s %10s %7s %11s %16s %n", toEncode, totChars, diffChars,
				maxCodeLen, avdCodeLen, FileLen, byteFileLen, reduc) + "\n");

		System.out.print(String.format("%-1s %-13s %-1s %n", "Char", "Freq", "Code"));
		for (int i = 0; i < hashM.keySet().size(); i++) {
			tempChar = tempArray.get(i).getChar();
			if (tempChar == '\t') {
				System.out.println(String.format("%-1s %5s %13s", "tab", tempArray.get(i).weight,
						hashM.get(tempArray.get(i).getChar())));
			} else if (tempChar == '\n') {
				System.out.println(String.format("%-1s %4s %13s", "{NL}", tempArray.get(i).weight,
						hashM.get(tempArray.get(i).getChar())));
			} else {
				System.out.println(String.format("%-1s %7s %13s", tempChar, tempArray.get(i).weight,
						hashM.get(tempArray.get(i).getChar())));
			}
		}
		System.out.println();

		tempArray.clear();
		resetVals();

		toEncode = "Huffman Program";
		huffmanEncode(toEncode);
		doEncoding();

		reduc = "%" + Double.toString(totReduc);
		hashM = hc.getHashMap();

		System.out.print(String.format("%-12s %-1s %-1s %-1s %-1s %-1s %-1s %-1s %n", "Name", "TotalChars", "Diffchars",
				"MaxCodeLen", "AveCodeLen", "FileLen", "ByteFileLen", "HuffmanReduction"));
		System.out.println(String.format("%4s %7s %9s %10s %10s %7s %11s %16s", toEncode, totChars, diffChars,
				maxCodeLen, avdCodeLen, FileLen, byteFileLen, reduc) + "\n");

		System.out.print(String.format("%-1s %-13s %-1s %n", "Char", "Freq", "Code"));
		for (int i = 0; i < hashM.keySet().size(); i++) {
			tempChar = tempArray.get(i).getChar();
			if (tempChar == '\t') {
				System.out.println(String.format("%-1s %5s %13s", "tab", tempArray.get(i).weight,
						hashM.get(tempArray.get(i).getChar())));
			} else if (tempChar == '\n') {
				System.out.println(String.format("%-1s %4s %13s", "{NL}", tempArray.get(i).weight,
						hashM.get(tempArray.get(i).getChar())));
			} else {
				System.out.println(String.format("%-1s %7s %13s", tempChar, tempArray.get(i).weight,
						hashM.get(tempArray.get(i).getChar())));
			}
		}
		System.out.println();

		tempArray.clear();
		resetVals();

		toEncode = "Mrs. Farrell Book";
		huffmanEncode(toEncode);
		doEncoding();

		reduc = "%" + Double.toString(totReduc);
		hashM = hc.getHashMap();

		System.out.print(String.format("%-14s %-1s %-1s %-1s %-1s %-1s %-1s %-1s %n", "Name", "TotalChars", "Diffchars",
				"MaxCodeLen", "AveCodeLen", "FileLen", "ByteFileLen", "HuffmanReduction"));
		System.out.println(String.format("%4s %7s %9s %10s %10s %7s %11s %16s", toEncode, totChars, diffChars,
				maxCodeLen, avdCodeLen, FileLen, byteFileLen, reduc) + "\n");

		System.out.print(String.format("%-1s %-1s %18s %n", "Char", "Freq", "Code"));
		for (int i = 0; i < hashM.keySet().size(); i++) {
			tempChar = tempArray.get(i).getChar();
			if (tempChar == '\t') {
				System.out.println(String.format("%-1s %5s %18s", "tab", tempArray.get(i).weight,
						hashM.get(tempArray.get(i).getChar())));
			} else if (tempChar == '\n') {
				System.out.println(String.format("%-1s %4s %18s", "{NL}", tempArray.get(i).weight,
						hashM.get(tempArray.get(i).getChar())));
			} else {
				System.out.println(String.format("%-1s %7s %18s", tempChar, tempArray.get(i).weight,
						hashM.get(tempArray.get(i).getChar())));
			}
		}
		System.out.println();

		tempArray.clear();
		resetVals();

		toEncode = "OneLine";
		huffmanEncode(toEncode);
		doEncoding();

		reduc = "%" + Double.toString(totReduc);
		hashM = hc.getHashMap();

		System.out.print(String.format("%-1s %-1s %-1s %-1s %-1s %-1s %-1s %-1s %n", "Name", "TotalChars", "Diffchars",
				"MaxCodeLen", "AveCodeLen", "FileLen", "ByteFileLen", "HuffmanReduction"));
		System.out.println(String.format("%4s %7s %9s %10s %10s %7s %11s %16s", toEncode, totChars, diffChars,
				maxCodeLen, avdCodeLen, FileLen, byteFileLen, reduc) + "\n");

		System.out.println(String.format("%-1s %-6s %-4s", "Char", "Freq", "Code"));
		for (int i = 0; i < hashM.keySet().size(); i++) {
			tempChar = tempArray.get(i).getChar();
			if (tempChar == '\t') {
				System.out.println(String.format("%-1s %5s %5s", "tab", tempArray.get(i).weight,
						hashM.get(tempArray.get(i).getChar())));
			} else if (tempChar == '\n') {
				System.out.println(String.format("%-1s %4s %5s", "{NL}", tempArray.get(i).weight,
						hashM.get(tempArray.get(i).getChar())));
			} else {
				System.out.println(String.format("%-1s %7s %5s", tempChar, tempArray.get(i).weight,
						hashM.get(tempArray.get(i).getChar())));
			}
		}
		System.out.println();
	}

	/**
	 * creates a new huffman coding instance with the parsed file chars and
	 * encodes the chars. Then calculates the values for the report
	 */
	private static void doEncoding() {
		hc = new HuffmanCoding(tempArray);
		hc.encode();
		maxCodeLen = hc.getMaxCharLength();
		FileLen = hc.getFileLength();
		avdCodeLen = Math.round(((double) FileLen / totChars) * 10.0) / 10.0;
		totReduc = (Math.round((double) FileLen / (double) byteFileLen * 10000)) / 100.0;
	}

	/**
	 * Does the File I/O process for a filename that is given, there is an error
	 * parsing the file, just displays broke on the console. Otherwise it counts
	 * characters and puts them into an ArrayList in the form of Leafs
	 * 
	 * @param toEncode
	 *            File name or path to be encoded
	 */
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
			if (lineCount != 0) {
				Leaf aLeaf = new Leaf(lineCount);
				aLeaf.setChar('\n');
				tempArray.add(aLeaf);
			}
			diffChars = tempArray.size();
			byteFileLen = totChars * 8;
		} catch (Exception e) {
			System.out.println("broke");
		} finally {

			if (scanner != null) {
				scanner.close();
			}
		}

	}

}