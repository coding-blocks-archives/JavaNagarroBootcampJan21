package L47_HashMapImplementation;

public class HashMap {

	private class Node {

		String key;
		Integer value;
		Node next;

		public Node(String key, Integer value) {
			this.key = key;
			this.value = value;
			this.next = null;
		}
		
	}

	private Node[] bucketArray;
	private int size;

	public HashMap() {
		this(4);
	}

	public HashMap(int capacity) {

		bucketArray = new Node[capacity];
		size = 0;

	}

	private int hashFunction(String key) {

		int hc = key.hashCode();
		int bn = hc % bucketArray.length;
		return bn;
	}

	public void put(String key, Integer value) {

		int bn = hashFunction(key);

		Node temp = bucketArray[bn];

		while (temp != null) {

			if (temp.key.equals(key)) {
				temp.value = value;
				return;
			}

			temp = temp.next;
		}

		// code flow area : key wasn't present

		Node nn = new Node(key, value);
		Node head = bucketArray[bn];

		nn.next = head;
		bucketArray[bn] = nn;

		size++;

		// load factor
		double lf = (1.0 * size) / bucketArray.length;
		int threshold = 2;

		if (lf > threshold)
			reshash();

	}

	private void reshash() {

		Node[] oba = bucketArray;
		Node[] nba = new Node[oba.length * 2];

		bucketArray = nba;
		size = 0;

		for (Node temp : oba) {

			while (temp != null) {

				put(temp.key, temp.value);
				temp = temp.next;
			}
		}

	}

	public Integer get(String key) {

		int bn = hashFunction(key);

		Node temp = bucketArray[bn];

		while (temp != null) {

			if (temp.key.equals(key)) {
				return temp.value;
			}

			temp = temp.next;
		}

		return null;

	}

	public boolean containsKey(String key) {

		int bn = hashFunction(key);

		Node temp = bucketArray[bn];

		while (temp != null) {

			if (temp.key.equals(key)) {
				return true;
			}

			temp = temp.next;
		}

		return false;

	}

	public Integer remove(String key) {

		int bn = hashFunction(key);

		Node temp = bucketArray[bn];
		Node prev = null;

		while (temp != null) {

			if (temp.key.equals(key)) {
				break;
			}

			prev = temp;
			temp = temp.next;
		}

		// key wasn't present
		if (temp == null) {
			return null;
		}

		// if we came outside the loop because of break
		if (prev == null) {
			bucketArray[bn] = temp.next;
		} else {
			prev.next = temp.next;
		}

		size--;

		return temp.value;

	}

	@Override
	public String toString() {

		String str = "";

		for (Node temp : bucketArray) {

			while (temp != null) {

				str += temp.key + "=" + temp.value + "  ";
				temp = temp.next;
			}

		}

		return str;
	}

}
