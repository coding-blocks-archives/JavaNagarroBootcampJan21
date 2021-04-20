package L34_OOPS;

public class Person {

	private String name;
	private int age;

	public int getAge() {
		return age;
	}

	public void setAge(int age) throws Exception {

		if (age < 0) {
			throw new Exception("Age can't be -ve");
		}
		this.age = age;
			
		// case 3
//		try {
//			if (age < 0) {
//				throw new Exception("Age can't be -ve");
//			}
//			this.age = age;
//			
//		} 
//		catch (Exception e) {
//			// System.out.println(e.getMessage()) ;
//			System.out.println("in catch");
//		}
//
//		System.out.println("bye set age");

	}

}
