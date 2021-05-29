package L54_BinaryTree;

public class BTClient {

	public static void main(String[] args) {

		// 10 true 20 true 50 false false true 60 false false true 30 false true 70 false false
		BinaryTree bt = new BinaryTree();
		bt.display();
		
		System.out.println(bt.size());
		System.out.println(bt.max());
		System.out.println(bt.find(60));
		System.out.println(bt.ht());
		System.out.println(bt.leafNodesCount());
		
		System.out.println(bt.diameter1());
		System.out.println(bt.diameter2());
		System.out.println(bt.diameter3());
		
		System.out.println(bt.isBalanced1());
		System.out.println(bt.isBalanced2());
		System.out.println(bt.isBalanced3());

	}

}
