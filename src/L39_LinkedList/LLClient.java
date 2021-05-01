package L39_LinkedList;

public class LLClient {

	public static void main(String[] args) throws Exception {

		LinkedList ll = new LinkedList();
		ll.addFirst(10);
		ll.addFirst(20);
		ll.addLast(30);
		ll.display();

		ll.addLast(40);
		ll.display();
		ll.addLast(50);
		ll.display();

	}

}
