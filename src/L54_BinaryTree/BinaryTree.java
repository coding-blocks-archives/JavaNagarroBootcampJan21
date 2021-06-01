package L54_BinaryTree;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;
import java.util.Stack;

public class BinaryTree {

	private Scanner scn = new Scanner(System.in);

	private class Node {
		int data;
		Node left;
		Node right;
	}

	private Node root;

	public BinaryTree() {
		root = construct(null, true);
	}

	// ilc -> true : parent left child create
	// ilc -> false : parent right child create
	private Node construct(Node parent, boolean ilc) {

		if (parent == null) {
			System.out.println("Enter the data for root node ?");
		} else {

			if (ilc)
				System.out.println("Enter the data for left child of " + parent.data + " ?");
			else
				System.out.println("Enter the data for right child of " + parent.data + " ?");

		}

		int item = scn.nextInt();

		Node nn = new Node();
		nn.data = item;

		System.out.println(nn.data + " has left child ?");
		boolean hlc = scn.nextBoolean();

		if (hlc)
			nn.left = construct(nn, true);

		System.out.println(nn.data + " has right child ?");
		boolean hrc = scn.nextBoolean();

		if (hrc)
			nn.right = construct(nn, false);

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

	public int size() {
		return size(root);
	}

	private int size(Node node) {

		if (node == null)
			return 0;

		int ls = size(node.left);
		int rs = size(node.right);

		return ls + rs + 1;

	}

	public int max() {
		return max(root);
	}

	private int max(Node node) {

		if (node == null) {
			return Integer.MIN_VALUE;
		}

		int lm = max(node.left);
		int rm = max(node.right);

		return Math.max(node.data, Math.max(lm, rm));

	}

	public boolean find(int item) {
		return find(root, item);
	}

	private boolean find(Node node, int item) {

		if (node == null)
			return false;

		if (node.data == item)
			return true;

		boolean lf = find(node.left, item);
		boolean rf = find(node.right, item);

		return lf || rf;

	}

	public int ht() {
		return ht(root);
	}

	private int ht(Node node) {

		if (node == null)
			return -1;

		int lh = ht(node.left);
		int rh = ht(node.right);

		return Math.max(lh, rh) + 1;
	}

	public int leafNodesCount() {
		return leafNodesCount(root);
	}

	private int leafNodesCount(Node node) {

		if (node == null)
			return 0;

		if (node.left == null && node.right == null)
			return 1;

		int llc = leafNodesCount(node.left);
		int rlc = leafNodesCount(node.right);

		return llc + rlc;

	}

	private int diameter;

	public int diameter1() {
		diameter1(root);
		return diameter;
	}

	private void diameter1(Node node) {

		if (node == null)
			return;

		diameter1(node.left);
		diameter1(node.right);

		int pndrn = ht(node.left) + ht(node.right) + 2;

		if (pndrn > diameter)
			diameter = pndrn;

	}

	public int diameter2() {
		return diameter2(root);
	}

	private int diameter2(Node node) {

		if (node == null)
			return 0;

		int ld = diameter2(node.left);
		int rd = diameter2(node.right);

		int sd = ht(node.left) + ht(node.right) + 2;

		return Math.max(sd, Math.max(ld, rd));

	}

	private class DiaPair {
		int dia = 0;
		int ht = -1;
	}

	public int diameter3() {
		return diameter3(root).dia;
	}

	private DiaPair diameter3(Node node) {

		if (node == null) {
			return new DiaPair();
		}

		DiaPair ldp = diameter3(node.left);
		DiaPair rdp = diameter3(node.right);

		DiaPair sdp = new DiaPair();

		// sdp diameter
		int ld = ldp.dia;
		int rd = rdp.dia;

		int sd = ldp.ht + rdp.ht + 2;

		sdp.dia = Math.max(sd, Math.max(ld, rd));

		// sdp ht
		sdp.ht = Math.max(ldp.ht, rdp.ht) + 1;

		return sdp;

	}

	private boolean isBal = true;

	public boolean isBalanced1() {
		isBalanced1(root);
		return isBal;
	}

	private void isBalanced1(Node node) {

		if (node == null)
			return;

		isBalanced1(node.left);
		isBalanced1(node.right);

		int bf = ht(node.left) - ht(node.right);

		if (bf <= -2 || bf >= 2)
			isBal = false;

	}

	public boolean isBalanced2() {

		return isBalanced2(root);

	}

	private boolean isBalanced2(Node node) {

		if (node == null)
			return true;

		boolean lb = isBalanced2(node.left);
		boolean rb = isBalanced2(node.right);

		int bf = ht(node.left) - ht(node.right);

		if (lb && rb && (bf == -1 || bf == 0 || bf == 1))
			return true;
		else
			return false;

	}

	private class BalPair {
		boolean bal = true;
		int ht = -1;
	}

	public boolean isBalanced3() {
		return isBalanced3(root).bal;
	}

	private BalPair isBalanced3(Node node) {

		if (node == null) {
			return new BalPair();
		}

		BalPair lbp = isBalanced3(node.left);
		BalPair rbp = isBalanced3(node.right);

		BalPair sbp = new BalPair();

		// sbp balanced
		boolean lb = lbp.bal;
		boolean rb = rbp.bal;

		int bf = lbp.ht - rbp.ht;

		if (lb && rb && (bf == -1 || bf == 0 || bf == 1))
			sbp.bal = true;
		else
			sbp.bal = false;

		// sbp ht
		sbp.ht = Math.max(lbp.ht, rbp.ht) + 1;

		return sbp;

	}

	public boolean flipEquivalent(BinaryTree other) {
		return flipEqivalent(root, other.root);
	}

	private boolean flipEqivalent(Node n1, Node n2) {

		if (n1 == null && n2 == null)
			return true;

		if (n1 == null || n2 == null)
			return false;

		if (n1.data != n2.data)
			return false;

		boolean flip = flipEqivalent(n1.left, n2.right) && flipEqivalent(n1.right, n2.left);

		if (flip)
			return true;

		boolean noflip = flipEqivalent(n1.left, n2.left) && flipEqivalent(n1.right, n2.right);

		return flip || noflip;

	}

	public void display2() {

		display2(root);

	}

	private void display2(Node node) {

		if (node == null)
			return;

		System.out.println("hii " + node.data);

		display2(node.left);
		System.out.println("Coming back from lc and going towards rc of " + node.data);
		display2(node.right);

		System.out.println("bye " + node.data);

	}

	// NLR : preorder
	// LRN : postorder
	// LNR : inorder
	// NRL : rev postorder
	// RLN : rev preorder
	// RNL : rev inorder
	public void preorder() {
		preorder(root);
		System.out.println();
	}

	private void preorder(Node node) {

		if (node == null)
			return;

		// N
		System.out.print(node.data + " ");

		// L
		preorder(node.left);

		// R
		preorder(node.right);

	}

	private class Pair {
		Node n;
		boolean sd;
		boolean ld;
		boolean rd;
	}

	public void preorderI() {

		// create a stack
		Stack<Pair> s = new Stack<>();

		// Make a pair with root node
		Pair sp = new Pair();
		sp.n = root;

		// Put the starting pair in stack
		s.push(sp);

		// work till stack is not empty
		while (!s.isEmpty()) {

			Pair tp = s.peek();

			// N
			if (tp.sd == false) {
				System.out.print(tp.n.data + " ");
				tp.sd = true;
			}

			// L
			else if (tp.ld == false) {

				Pair np = new Pair();
				np.n = tp.n.left;

				if (np.n != null)
					s.push(np);

				tp.ld = true;

			}

			// R
			else if (tp.rd == false) {

				Pair np = new Pair();
				np.n = tp.n.right;

				if (np.n != null)
					s.push(np);

				tp.rd = true;

			}

			// work complete : pop
			else {

				s.pop();

			}
		}

		System.out.println();

	}

	public int sum() {
		return sum(root);
	}

	private int sum(Node node) {

		if (node == null) {
			return 0;
		}

		int ls = sum(node.left);
		int rs = sum(node.right);

		return ls + rs + node.data;
	}

	private int mss = Integer.MIN_VALUE;

	public int maxSubtreeSum1() {
		maxSubtreeSum1(root);
		return mss;
	}

	private void maxSubtreeSum1(Node node) {

		if (node == null)
			return;

		maxSubtreeSum1(node.left);
		maxSubtreeSum1(node.right);

		int pnsum = sum(node.left) + sum(node.right) + node.data;

		if (pnsum > mss)
			mss = pnsum;

	}

	public int maxSubtreeSum2() {
		return maxSubtreeSum2(root);
	}

	private int maxSubtreeSum2(Node node) {

		if (node == null) {
			return Integer.MIN_VALUE;
		}

		int lmss = maxSubtreeSum2(node.left);
		int rmss = maxSubtreeSum2(node.right);

		int pnsum = sum(node.left) + sum(node.right) + node.data;

		return Math.max(pnsum, Math.max(lmss, rmss));
	}

	private class MSSPair {
		int mss = Integer.MIN_VALUE;
		int es = 0;
	}

	public int maxSubtreeSum3() {
		return maxSubtreeSum3(root).mss;
	}

	private MSSPair maxSubtreeSum3(Node node) {

		if (node == null)
			return new MSSPair();

		MSSPair lmssp = maxSubtreeSum3(node.left);
		MSSPair rmssp = maxSubtreeSum3(node.right);

		MSSPair smssp = new MSSPair();

		// mss
		smssp.mss = Math.max(lmssp.es + rmssp.es + node.data, Math.max(lmssp.mss, rmssp.mss));

		// es
		smssp.es = lmssp.es + rmssp.es + node.data;

		return smssp;

	}

	private class VOPair {
		Node n;
		int vl;

		public VOPair(Node n, int vl) {
			this.n = n;
			this.vl = vl;
		}
	}

	public void verticalTraversal() {

		HashMap<Integer, ArrayList<Integer>> map = new HashMap<>();
		Queue<VOPair> q = new LinkedList<>();

		VOPair sp = new VOPair(root, 0);
		q.add(sp);

		while (!q.isEmpty()) {

			// remove
			VOPair rp = q.remove();

			// check if entry is already present with rp.vl ? If no, then make an entry
			if (!map.containsKey(rp.vl))
				map.put(rp.vl, new ArrayList<>());

			// add the data of node in map
			map.get(rp.vl).add(rp.n.data);

			// left child
			if (rp.n.left != null) {
				VOPair left = new VOPair(rp.n.left, rp.vl - 1);
				q.add(left);
			}

			// right child
			if (rp.n.right != null) {
				VOPair right = new VOPair(rp.n.right, rp.vl + 1);
				q.add(right);
			}

		}

		ArrayList<Integer> keys = new ArrayList<>(map.keySet());
		Collections.sort(keys);

		for (int key : keys) {
			System.out.println(key + " -> " + map.get(key));
		}

	}

}
