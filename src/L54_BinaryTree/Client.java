package L54_BinaryTree;

public class Client {

	public static void main(String[] args) {

		int[] arr = { 10, 20, 30, 40, 50, -1, 70, -1, -1, -1, -1, -1, -1 };

		LevelOrderTreeConstruct t = new LevelOrderTreeConstruct(arr);
		t.display();

		int[] arr1 = { 10, 20, 40, -1, -1, 50, -1, -1, 30, -1, 70, -1, -1 };
		PreOrderTreeConstruct t1 = new PreOrderTreeConstruct(arr1);
		t1.display();

	}
}
