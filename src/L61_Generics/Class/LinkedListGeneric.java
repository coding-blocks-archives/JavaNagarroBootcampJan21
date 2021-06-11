package L61_Generics.Class;

public class LinkedListGeneric<T> {

	private class Node {

		T data;
		Node next;

		Node(T data) {
			this.data = data;
		}

		Node() {

		}

	}

	private Node head;

	public void display() {

		System.out.println("-------------------------");

		Node temp = head;

		while (temp != null) {

			System.out.println(temp.data);
			temp = temp.next;

		}
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

	public T getFirst() throws Exception {

		if (isEmpty()) {
			throw new Exception("LL is Empty.");
		}

		return head.data;

	}

	public T getLast() throws Exception {

		if (isEmpty()) {
			throw new Exception("LL is Empty.");
		}

		Node temp = head;

		while (temp.next != null) {
			temp = temp.next;
		}

		return temp.data;

	}

	public T getAt(int idx) throws Exception {

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

	public void addLast(T item) throws Exception {

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

	public void addFirst(T item) {

		// create a new node
		Node nn = new Node();
		nn.data = item;
		nn.next = null;

		// linking
		nn.next = head;
		head = nn;

	}

	public void addAt(int idx, T item) throws Exception {

		if (idx < 0 || idx > size()) {
			throw new Exception("Invalid Index.");
		}

		if (idx == 0)
			addFirst(item);

		else if (idx == size())
			addLast(item);

		else {

			// create a new node
			Node nn = new Node();
			nn.data = item;
			nn.next = null;

			// linking
			Node n1 = getNodeAt(idx - 1);
			Node n2 = getNodeAt(idx);

			n1.next = nn;
			nn.next = n2;

		}

	}

	public T removeLast() throws Exception {

		if (isEmpty()) {
			throw new Exception("LL is Empty.");
		}

		T rv = getLast();

		if (size() == 1) {
			head = null;
		} else {
			Node sm2 = getNodeAt(size() - 2);
			sm2.next = null;
		}

		return rv;
	}

	public T removeFirst() throws Exception {

		if (isEmpty()) {
			throw new Exception("LL is Empty.");
		}

		T rv = getFirst();

		if (size() == 1) {
			head = null;
		} else {
			head = head.next;
		}

		return rv;
	}

	public T removeAt(int idx) throws Exception {

		if (isEmpty()) {
			throw new Exception("LL is Empty.");
		}

		if (idx < 0 || idx >= size()) {
			throw new Exception("Invalid Index.");
		}

		if (idx == 0)
			return removeFirst();

		else if (idx == size() - 1)
			return removeLast();

		else {

			Node im1 = getNodeAt(idx - 1);
			Node i = im1.next;
			Node ip1 = i.next;

			im1.next = ip1;

			return i.data;

		}

	}

}
