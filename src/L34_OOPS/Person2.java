package L34_OOPS;

public class Person2 {

	private String name;
	private int age;

	public int getAge() {
		return age;
	}

	public void setAge(int age) {

		if (age < 0) {
			throw new RuntimeException("Age can't be -ve");
		}
		this.age = age;

	}

}
