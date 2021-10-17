public class HTNode implements Comparable <HTNode> {
		char ch;
		int freq;
		HTNode left;
		HTNode right;
		
		//Sum HTNode Creation Method
		HTNode (int sum) {
			this.freq = sum;
			this.ch = '\0';
			this.right = null;
			this.left = null;
		}
		
		//HTNode Creation Method
		HTNode (char ch, int freq, HTNode left, HTNode right) {
			this.ch = ch;
			this.freq = freq;
			this.left = left;
			this.right = right;
		}
		
		//HTNode Leaf Checker Method
		public boolean isLeaf() {
			return left == null && right == null;
		}
		
		//HTNode Compare Method
		public int compareTo(HTNode that) {
			return this.freq - that.freq;
		}
}		
