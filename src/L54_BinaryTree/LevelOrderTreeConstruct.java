package L54_BinaryTree;

import java.util.LinkedList;
import java.util.Queue;

public class LevelOrderTreeConstruct {

	private class Node {
		int data;
		Node left;
		Node right;

		Node(int data) {
			this.data = data;
		}
	}

	private Node root;

	public LevelOrderTreeConstruct(int[] arr) {

		int i = 0;

		Queue<Node> q = new LinkedList<>();

		root = new Node(arr[i++]);
		q.add(root);

		while (!q.isEmpty()) {

			// remove
			Node rn = q.remove();

			// left
			int ld = arr[i++] ;
			if (ld != -1) {
				Node leftChild = new Node(ld);
				rn.left = leftChild;
				q.add(leftChild);
			}

			// right
			int rd = arr[i++] ;
			if (rd != -1) {
				Node rightChild = new Node(rd);
				rn.right = rightChild;
				q.add(rightChild);
			}

		}

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

}
