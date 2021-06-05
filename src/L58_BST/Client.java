package L58_BST;

public class Client {

	public static void main(String[] args) {

		int[] in = {} ; // { 10, 20, 30, 40, 50, 60, 70 };

		BST bst = new BST(in);
		bst.display();
		
//		System.out.println(bst.max());
//		System.out.println(bst.find(35));
//		bst.replaceWithSumLarger();
//		bst.display();
		
//		bst.printInRange(15, 65);
		bst.add3(10);
		bst.display();
		bst.add3(20);
		bst.display();
		bst.add3(15);
		bst.display();
		bst.add3(5);
		bst.display();
	}

}
