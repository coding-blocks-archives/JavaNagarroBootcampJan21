package L54_BinaryTree;

import java.util.Scanner;

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
		display(root) ;
		System.out.println("-----------------------");
	}
	
	private void display(Node node) {

		if(node == null)
			return ;
		
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
