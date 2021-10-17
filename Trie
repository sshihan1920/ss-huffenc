public class Trie {
		public HTNode root;
		public static int trieSize;
	
	Trie() {
		this.trieSize = 256;
	}
		
	public void expand(BinaryIn from, BinaryOut to) {
			HTNode root = readTrie(from);
			 int N = from.readInt();
			 for (int i = 0; i < N; i++)
			 { // Expand ith codeword.
			 HTNode x = root;
			 while (!x.isLeaf())
			 if (from.readBoolean())
			 x = x.right;
			 else x = x.left;
			 to.write(x.ch);
			 }
			 to.close(); 
		}
		
	public String[] buildCode(HTNode root) 
	{ // Make a lookup table from trie.
	 String[] st = new String[trieSize];
	 buildCode(st, root, "");
	 return st; 
	}
	public static void buildCode(String[] st, HTNode x, String s) 
	{ // Make a lookup table from trie (recursive).
	 if (x.isLeaf())
	 { st[x.ch] = s; return; }
	 buildCode(st, x.left, s + '0');
	 buildCode(st, x.right, s + '1'); 
	}	
		
	static HTNode buildTrie(int[] freq) 
	{
	 // Initialize priority queue with singleton trees.
	 MinPQ<HTNode> pq = new MinPQ<HTNode>();
	 for (char c = 0; c < trieSize; c++)
		 if (freq[c] > 0) {
			 pq.insert(new HTNode(c, freq[c], null, null));
		 }
			 
	 while (pq.size() > 1) { // Merge two smallest trees.
		 HTNode x = pq.delMin();
		 HTNode y = pq.delMin();
		 HTNode parent = new HTNode('\0', x.freq + y.freq, x, y);
		 pq.insert(parent);
	 }
	 return pq.delMin(); 
	}
	
	public static void writeTrie(HTNode x, BinaryOut writer) 
	{ // Write bitstring-encoded trie.
	 if (x.isLeaf())
	 {
	 writer.write(true);
	 writer.write(x.ch);
	 return;
	 }
	 writer.write(false);
	 writeTrie(x.left, writer);
	 writeTrie(x.right, writer); 
	}
	
	public static HTNode readTrie(BinaryIn from) 
	{
	 if (from.readBoolean())
	 return new HTNode(from.readChar(), 0, null, null);
	 return new HTNode('\0', 0, readTrie(from), readTrie(from)); 
	}
}		
