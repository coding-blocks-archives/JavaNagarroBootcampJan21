package L58_BST;

public class BST {

	private class Node {
		int data;
		Node left;
		Node right;
	}

	private Node root;

	public BST(int[] in) {
		root = construct(in, 0, in.length - 1);
	}

	private Node construct(int[] in, int lo, int hi) {

		if (lo > hi)
			return null;

		int mid = (lo + hi) / 2;

		Node nn = new Node();
		nn.data = in[mid];

		nn.left = construct(in, lo, mid - 1);
		nn.right = construct(in, mid + 1, hi);

		return nn;

	}

	public void display() {

		System.out.println("-----------------------");
		display(root);
		System.out.println("-----------------------");
	}

	private void display(Node node) {

		if (node == null)
			return;

		String str = "";

		if (node.left == null)
			str += ".";
		else
			str += node.left.data;

		str += " -> " + node.data + " <- ";

		if (node.right == null)
			str += ".";
		else
			str += node.right.data;

		System.out.println(str);

		display(node.left);
		display(node.right);

	}

	public int max() {
		return max(root);
	}

	private int max(Node node) {

		if (node.right == null) {
			return node.data;
		}

		return max(node.right);

	}

	public boolean find(int item) {
		return find(root, item);
	}

	private boolean find(Node node, int item) {

		if (node == null)
			return false;

		// right
		if (node.data < item)
			return find(node.right, item);

		// left
		else if (node.data > item)
			return find(node.left, item);

		// equal
		else
			return true;
	}

	private int sum = 0;

	public void replaceWithSumLarger() {
		replaceWithSumLarger(root);
	}

	private void replaceWithSumLarger(Node node) {

		if (node == null)
			return;

		replaceWithSumLarger(node.right);

		int temp = node.data;
		node.data = sum;
		sum += temp;

		replaceWithSumLarger(node.left);

	}

	public void printInRange(int lo, int hi) {
		printInRange(root, lo, hi);
	}

	private void printInRange(Node node, int lo, int hi) {

		if (node == null)
			return;

		if (node.data >= lo && node.data <= hi) {
			printInRange(node.left, lo, hi);
			System.out.println(node.data);
			printInRange(node.right, lo, hi);
		}

		else if (node.data < lo)
			printInRange(node.right, lo, hi);

		else if (node.data > hi)
			printInRange(node.left, lo, hi);

	}

	public void add1(int item) {

		if (root == null) {
			Node nn = new Node();
			nn.data = item;
			root = nn;

			return;
		}

		add1(root, item);
	}

	private void add1(Node node, int item) {

		// Left
		if (item <= node.data) {

			// left does not exist
			if (node.left == null) {
				Node nn = new Node();
				nn.data = item;
				node.left = nn;
			}
			// left exist
			else {
				add1(node.left, item);
			}
		}
		// Right
		else {

			// right does not exist
			if (node.right == null) {
				Node nn = new Node();
				nn.data = item;
				node.right = nn;
			}
			// right exist
			else {
				add1(node.right, item);
			}

		}

	}

	public void add2(int item) {

		if (root == null) {
			Node nn = new Node();
			nn.data = item;
			root = nn;

			return;
		}

		add2(root, null, item);
	}

	private void add2(Node node, Node parent, int item) {

		if (node == null) {
			Node nn = new Node();
			nn.data = item;

			if (item <= parent.data)
				parent.left = nn;
			else
				parent.right = nn;

			return;
		}

		// Left
		if (item <= node.data) {
			add2(node.left, node, item);
		}
		// Right
		else {
			add2(node.right, node, item);
		}

	}

	public void add3(int item) {
		root = add3(root, item) ;
	}
	
	private Node add3(Node node, int item) {
		
		if(node == null) {
			Node nn = new Node() ;
			nn.data = item ;
			return nn ;			
		}
		
		// left
		if(item <= node.data) {
			node.left = add3(node.left, item) ;
		}
		// right
		else{
			node.right = add3(node.right, item) ;
		}
		
		return node ;
		
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
