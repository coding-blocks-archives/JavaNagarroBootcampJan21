package L38_MinStack;

public class Client {

	public static void main(String[] args) throws Exception {

		MinStack s = new MinStack();
		s.push(10);
		s.push(50);
		s.push(40);
		s.push(6);
		s.push(45);
		s.push(2);

		System.out.println(s.peek());
		s.pop();
		System.out.println(s.peek());

	}

}
