package L34_OOPS;

public class PClient {

	public static void main(String[] args) {

		System.out.println("hello");

		try {
			Person p = new Person();
			p.setAge(-20);
			System.out.println(p.getAge());
			return;
		} catch (Exception e) {
//			System.out.println("in catch");
			e.printStackTrace();
			// System.out.println(e.getMessage());
		} finally {
			System.out.println("in finally");
		}

		System.out.println("bye");

		// case 3
//		System.out.println("hello");
//		
//		Person p = new Person();
//		p.setAge(-20);
//		System.out.println(p.getAge());
//
//		System.out.println("bye");

	}

}
