package L52_GenericTree;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;
import java.util.Stack;

public class GenericTree {

	Scanner scn = new Scanner(System.in);

	private class Node {
		int data;
		ArrayList<Node> children = new ArrayList<>();
	}

	private Node root;

	public GenericTree() {
		root = construct(null, -1);
	}

	private Node construct(Node parent, int ith) {

		// prompt
		if (parent == null) {
			System.out.println("Enter the data for root node ?");
		} else {
			System.out.println("Enter the data for " + ith + " child of " + parent.data + " ?");
		}

		// take input of data
		int item = scn.nextInt();

		// create a new node
		Node nn = new Node();

		// update the data
		nn.data = item;

		// prompt
		System.out.println("Enter the number of children for " + nn.data + " ?");

		// take input for children
		int noc = scn.nextInt();

		// loop
		for (int j = 0; j < noc; j++) {

			Node child = construct(nn, j);
			nn.children.add(child);
		}

		return nn;

	}

	public void display() {
		System.out.println("---------------------");
		display(root);
		System.out.println("---------------------");

	}

	private void display(Node node) {

		// self work
		String str = node.data + " -> ";

		for (Node child : node.children) {
			str += child.data + " ";
		}

		str += ".";
		System.out.println(str);

		// smaller problem
		for (Node child : node.children) {
			display(child);
		}

	}

	public int size() {
		return size(root);
	}

	private int size(Node node) {

		int ts = 0;

		for (Node child : node.children) {
			int cs = size(child);
			ts += cs;
		}

		return ts + 1;

	}

	public int max() {
		return max(root);
	}

	private int max(Node node) {

		int tm = node.data;

		for (Node child : node.children) {
			int cm = max(child);

			if (cm > tm) {
				tm = cm;
			}
		}

		return tm;

	}

	public int ht() {
		return ht(root);
	}

	private int ht(Node node) {

		int th = -1;

		for (Node child : node.children) {
			int ch = ht(child);

			if (ch > th) {
				th = ch;
			}
		}

		return th + 1;

	}

	public boolean find(int item) {
		return find(root, item);
	}

	private boolean find(Node node, int item) {

		if (node.data == item) {
			return true;
		}

		for (Node child : node.children) {

			boolean cf = find(child, item);

			if (cf)
				return true;

		}

		return false;

	}

	public void mirror() {
		mirror(root);
	}

	private void mirror(Node node) {

		for (Node child : node.children) {
			mirror(child);
		}

		Collections.reverse(node.children);

		// array list reverse
//		int i = 0; // 0
//		int j = node.children.size() - 1; // 2
//
//		while (i <= j) {
//
//			Node in = node.children.get(i); // 2k
//			Node jn = node.children.get(j); // 4k
//
//			node.children.set(i, jn);
//			node.children.set(j, in);
//
//			i++;
//			j--;
//
//		}

	}

	public void printAtLevel(int level) {
		printAtLevel(root, level, 0);
	}

	private void printAtLevel(Node node, int level, int count) {

		if (level == count) {
			System.out.println(node.data);
			return;
		}

		for (Node child : node.children) {
			printAtLevel(child, level, count + 1);
		}

	}

	public void linearize() {
		linearize(root);
	}

	private void linearize(Node node) {

		for (Node child : node.children) {
			linearize(child);
		}

		while (node.children.size() > 1) {

			Node temp = node.children.remove(1);
			Node tail = getTail(node.children.get(0));
			tail.children.add(temp);

		}

	}

	private Node getTail(Node node) {

		if (node.children.size() == 0) {
			return node;
		}

		return getTail(node.children.get(0));
	}

	public void display2() {
		System.out.println("---------------------");
		display2(root);
		System.out.println("---------------------");

	}

	private void display2(Node node) {

		System.out.println("Hii " + node.data);

		for (int i = node.children.size() - 1; i >= 0; i--) {
			Node child = node.children.get(i);

			System.out.println("Going towards " + child.data);
			display2(child);
			System.out.println("Coming back from " + child.data);
		}

		System.out.println("Bye " + node.data);

	}

	public void preorder() {
		preorder(root);
		System.out.println();
	}

	private void preorder(Node node) {

		System.out.print(node.data + " ");

		for (Node child : node.children) {
			preorder(child);
		}

	}

	public void postorder() {
		postorder(root);
		System.out.println();
	}

	private void postorder(Node node) {

		for (Node child : node.children) {
			postorder(child);
		}

		System.out.print(node.data + " ");

	}

	public void levelOrder() {

		Queue<Node> q = new LinkedList<>();

		// initial setup : add root node in queue
		q.add(root);

		// work till q is not empty
		while (!q.isEmpty()) {

			// remove the node
			Node rn = q.remove();

			// print the data of removed node
			System.out.print(rn.data + " ");

			// removed node children enqueue
			for (Node child : rn.children) {
				q.add(child);
			}

		}

		System.out.println();

	}

	public void levelOrderLineWise() {

		Queue<Node> pq = new LinkedList<>();
		Queue<Node> hq = new LinkedList<>();

		// initial setup : add root node in queue
		pq.add(root);

		// work till q is not empty
		while (!pq.isEmpty()) {

			// remove the node
			Node rn = pq.remove();

			// print the data of removed node
			System.out.print(rn.data + " ");

			// removed node children enqueue
			for (Node child : rn.children) {
				hq.add(child);
			}

			// check of primary queue is empty -> level finish
			if (pq.isEmpty()) {
				System.out.println();

				Queue<Node> temp = pq;
				pq = hq;
				hq = temp;

			}

		}

	}

	public void levelOrderZigZag() {

		int count = 0;

		Stack<Node> ps = new Stack<>();
		Stack<Node> hs = new Stack<>();

		// initial setup : add root node in primary stack
		ps.add(root);

		// work till stack is not empty
		while (!ps.isEmpty()) {

			// remove the node
			Node rn = ps.pop();

			// print the data of removed node
			System.out.print(rn.data + " ");

			if (count % 2 == 0) {
				for (Node child : rn.children) {
					hs.push(child);
				}
			} else {
				for (int i = rn.children.size() - 1; i >= 0; i--) {
					Node child = rn.children.get(i);
					hs.push(child);
				}
			}

			// check of primary queue is empty -> level finish
			if (ps.isEmpty()) {
				System.out.println();

				Stack<Node> temp = ps;
				ps = hs;
				hs = temp;

				count++;

			}

		}

	}

}
