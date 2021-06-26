package L69_SegmentTree;

public class SegmentTree {

	private class Node {
		int data;
		int si;
		int ei;
		Node left;
		Node right;
	}

	private Node root;
	private STI sti;

	public SegmentTree(int[] arr, STI sti) {
		this.sti = sti;
		root = construct(arr, 0, arr.length - 1);
	}

	private Node construct(int[] arr, int lo, int hi) {

		if (lo == hi) {
			Node ln = new Node();
			ln.si = lo;
			ln.ei = hi;
			ln.data = arr[lo];
			return ln;
		}

		Node nn = new Node();
		nn.si = lo;
		nn.ei = hi;

		int mid = (lo + hi) / 2;

		nn.left = construct(arr, lo, mid);
		nn.right = construct(arr, mid + 1, hi);

		nn.data = sti.operation(nn.left.data, nn.right.data);

		return nn;

	}

	public void display() {
		System.out.println("-------------------");
		display(root);
		System.out.println("-------------------");
	}

	private void display(Node node) {

		if (node == null) {
			return;
		}

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

	public int rangeQuery(int qsi, int qei) {
		return rangeQuery(root, qsi, qei);
	}

	private int rangeQuery(Node node, int qsi, int qei) {

		// full contribution
		if (qsi <= node.si && node.ei <= qei) {
			return node.data;
		}

		// no contribution
		else if (node.ei < qsi || qei < node.si) {
			return sti.defaultValue();
		}

		// partial contribution
		else {

			int l = rangeQuery(node.left, qsi, qei);
			int r = rangeQuery(node.right, qsi, qei);

			return sti.operation(l, r);
		}

	}

	public void update(int idx, int item) {
		update(root, idx, item);
	}

	private void update(Node node, int idx, int item) {

		// you have reached the required node
		if (node.si == idx && node.ei == idx) {
			node.data = item;
		}

		// idx doesn't lie in the range of node
		else if (idx < node.si || idx > node.ei) {
			return;
		}

		// idx lies in the range of node
		else {

			update(node.left, idx, item);
			update(node.right, idx, item);

			node.data = sti.operation(node.left.data, node.right.data);
		}
	}

}
