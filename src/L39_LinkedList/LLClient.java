package L39_LinkedList;

public class LLClient {

	public static void main(String[] args) throws Exception {

		LinkedList ll = new LinkedList();
		ll.addLast(10);
		ll.addLast(20);
		ll.addLast(30);
		ll.display();

		ll.addLast(40);
//		ll.display();
		ll.addLast(50);
		ll.display();
//		ll.addAt(2, 60);
//		ll.display();
//		System.out.println(ll.getFirst());
//		System.out.println(ll.getLast());
//		System.out.println(ll.getAt(3));
//		
//		System.out.println(ll.removeFirst());
//		ll.display();
		ll.addLast(70);
//		ll.display();
//		System.out.println(ll.removeLast()); 
//		ll.addFirst(80);
//		ll.display();
//		System.out.println(ll.removeAt(2));
//		ll.display();

//		ll.reverseR2() ;
		ll.display();

		System.out.println(ll.mid());
		System.out.println(ll.kthFromLast(5));
		
		ll.createDummyList(); 
	}

}
