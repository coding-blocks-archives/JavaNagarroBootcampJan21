package L39_LinkedList;

public class LinkedList {

	private class Node {

		int data;
		Node next;

	}

	private Node head;

	public void display() {

		System.out.println("-------------------------");

		Node temp = head;

		while (temp != null) {

			System.out.print(temp.data + " ");
			temp = temp.next;

		}
		System.out.println();
		System.out.println("-------------------------");

	}

	public int size() {

		int count = 0;

		Node temp = head;

		while (temp != null) {
			count++;
			temp = temp.next;
		}

		return count;

	}

	public boolean isEmpty() {

		// return size() == 0;
		return head == null;
	}

	public int getFirst() throws Exception {

		if (isEmpty()) {
			throw new Exception("LL is Empty.");
		}

		return head.data;

	}

	public int getLast() throws Exception {

		if (isEmpty()) {
			throw new Exception("LL is Empty.");
		}

		Node temp = head;

		while (temp.next != null) {
			temp = temp.next;
		}

		return temp.data;

	}

	public int getAt(int idx) throws Exception {

		if (isEmpty()) {
			throw new Exception("LL is Empty.");
		}

		if (idx < 0 || idx >= size()) {
			throw new Exception("Invalid Index.");
		}

		Node temp = head;
		for (int i = 1; i <= idx; i++) {
			temp = temp.next;
		}

		return temp.data;

	}

	private Node getNodeAt(int idx) throws Exception {

		if (isEmpty()) {
			throw new Exception("LL is Empty.");
		}

		if (idx < 0 || idx >= size()) {
			throw new Exception("Invalid Index.");
		}

		Node temp = head;
		for (int i = 1; i <= idx; i++) {
			temp = temp.next;
		}

		return temp;

	}

	public void addLast(int item) throws Exception {

		// created a new node with data as item
		Node nn = new Node();
		nn.data = item;
		nn.next = null;

		if (isEmpty()) {

			// your ll was already empty and now you are adding an element for the 1st time
			// : spcl case
			head = nn;

		} else {

			// linking
			Node last = getNodeAt(size() - 1);
			last.next = nn;

		}
	}

	public void addFirst(int item) {

		// create a new node
		Node nn = new Node();
		nn.data = item;
		nn.next = null;

		// linking
		nn.next = head;
		head = nn;

	}

}








