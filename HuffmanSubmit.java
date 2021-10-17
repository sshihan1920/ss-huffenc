import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Scanner;

public class HuffmanSubmit implements Huffman {
	 
//Frequency HashMap Maker Method
	public static HashMap charMapMaker(String inputFileName) {
		HashMap<Character, Integer> charFreqMap = new HashMap<Character, Integer>();
		BinaryIn reader = new BinaryIn(inputFileName);
		//Scanner scnr = new Scanner(inputFileName);
		String s = reader.readString();
		//System.out.println(s.charAt(2));		
		
		for (int i = 0; i < s.length(); i++) {
				char ch = s.charAt(i);
				Integer freq = charFreqMap.get(ch);
				    
				    if (freq != null) {
				        charFreqMap.put(ch, new Integer(freq + 1));
				    }
				    else {
				       charFreqMap.put(ch, 1);
				   }			    
				}
			
		
			return charFreqMap;		
		}		
	
//Convert HashMap to Character Array Method 
	public static char[] convertToCharArray(HashMap<Character, Integer> map) {
		char [] charArray = new char [map.size()];
		int i = 0;
					
			for (Entry<Character, Integer> entry : map.entrySet()) {
				charArray[i] = entry.getKey();
				++i;
			}
			return charArray;
		}

//Convert HashMap to Integer Array Method 
	public static int[] convertToIntArray(HashMap<Character, Integer> map) {
		int[] freq = new int[256];
		
		for (int i = 0; i < freq.length; ++i) {
			if (map.containsKey((char) i)) {
				freq[i] = map.get((char) i);
			}
		}
		
		return freq;
	}
	
//Frequency Writer Method	
	public static void writeFreq(int[] freq, String outputFileName) {
		BinaryOut writer = new BinaryOut(outputFileName);
		
		for (int i = 0; i < freq.length; ++i) {
			if (freq[i] > 0) {	
			String binString = Integer.toBinaryString(i);
				while (binString.length() < 8) binString = '0' + binString;
				writer.write(binString + ":" + freq[i] + " \n");	
				writer.flush();
				}
			}
		writer.close();
	}
	
//Compress Method
	public void compress(String inFile, String outFile, int[] freq) {
		BinaryIn reader = new BinaryIn(inFile);
		BinaryOut writer = new BinaryOut(outFile);
		Trie huff = new Trie();
		
		String s = reader.readString();
		char[] input = s.toCharArray();
		 
		 HTNode root = huff.buildTrie(freq);

		 String[] st = new String[256];
		 huff.buildCode(st, root, "");

		 huff.writeTrie(root, writer);

		 writer.write(input.length);

		 for (int i = 0; i < input.length; i++) {
			 String code = st[input[i]];
			 
			 for (int j = 0; j < code.length(); j++)
				 if (code.charAt(j) == '1')
					 writer.write(true);
				 else writer.write(false);
		 }
		 writer.close(); 
	}
	
//Encode Method		
	public void encode(String inputFileName, String outputFileName, String freqFileName) {
		BinaryIn inReader = new BinaryIn(inputFileName);
		
		String inString = inReader.readString();
		HashMap map = charMapMaker(inputFileName);
		
		int [] inFreq = convertToIntArray(map);
		
		writeFreq(inFreq, freqFileName);		
		compress(inputFileName, outputFileName, inFreq);
	}

//Decode Method
   public void decode(String inputFileName, String outputFileName, String freqFileName){
	   BinaryIn inReader = new BinaryIn(inputFileName);
	   BinaryOut outWriter = new BinaryOut(outputFileName);
	   Trie huff = new Trie();
	   
	   HashMap map = charMapMaker(inputFileName);
	   int [] freq = convertToIntArray(map);

	   HTNode root = huff.buildTrie(freq);
	   huff.expand(inReader, outWriter);
   }

//Main Method   
   public static void main(String[] args) {
	    Huffman huffman = new HuffmanSubmit();
	    
		huffman.encode("alice30.txt", "alice30.enc", "freq.txt");
		huffman.decode("alice30.enc", "alice30.dec", "freq.txt");
		//huffman.encode("ur.jpg", "ur_enc.jpg", "freq.txt");
		//huffman.decode("ur_enc.jpg", "ur_dec.jpg", "freq.txt");
		// After decoding, both ur.jpg and ur_dec.jpg should be the same. 
   }
}
