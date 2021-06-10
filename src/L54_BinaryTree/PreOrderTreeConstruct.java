package L54_BinaryTree;

public class PreOrderTreeConstruct {

	private class Node {
		int data;
		Node left;
		Node right;

		public Node(int data) {
			this.data = data;
		}
	}

	private Node root;
	private int i = 0;

	public PreOrderTreeConstruct(int[] arr) {
		root = construct(arr);
	}

	private Node construct(int[] arr) {

		if (arr[i] == -1) {
			i++ ;
			return null;
		}

		Node nn = new Node(arr[i++]);

		nn.left = construct(arr);
		nn.right = construct(arr);

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
}
