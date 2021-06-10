package L60_AVL;

public class Client {

	public static void main(String[] args) {
		
		AVL avl = new AVL() ;
		avl.add(20);
		avl.add(25);
		avl.add(30);
		avl.add(10);
		avl.add(5);
		avl.add(15);
		avl.add(27);
		avl.add(19);
		avl.add(16);
		
		avl.display(); 
		
		
		
	}
}
