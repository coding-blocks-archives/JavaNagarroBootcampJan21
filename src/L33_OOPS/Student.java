package L33_OOPS;

public class Student {

	String name;
	int age;
	
	public void introduceYourself() {
		System.out.println(name + " is " + age + " years old.");
	}
	
	public void sayHi(String name, Student s) {	
		System.out.println(this.name + " says hi to " + name);	
		introduceYourself();
	}
	

}
