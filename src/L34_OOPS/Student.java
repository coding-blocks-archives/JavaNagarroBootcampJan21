package L34_OOPS;

public class Student {

	String name = "Rohit";
	int age = 50;

	public Student() {
		this.name = "Aman";
		this.age = 20;
	}

	public Student(String name, int age) {
		this.name = name;
		this.age = age;
	}

	public void introduceYourself() {
		System.out.println(name + " is " + age + " years old.");
	}
}
