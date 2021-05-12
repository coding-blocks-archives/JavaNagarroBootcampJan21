package L45_Static;

public class Student {

	String name;
	final int rollNo;
	static int totalStudents;

	public Student(String name) {
		this.name = name;

		totalStudents++;
		this.rollNo = totalStudents;
	}

	// non static fxn : non static variable access ? Yes
	// non static fxn : static variable access ? Yes
	// non static fxn : non static fxn call ? Yes
	// non static fxn : static fxn call ? Yes

	public void introduceYourself() {
		System.out.println(name + " has roll no " + rollNo);
	}

	public static void sayHi() {
		int a;
	}

	// static fxn : non static variable access ? No
	// static fxn : static variable access ? Yes
	// static fxn : non static fxn call ? No
	// static fxn : static fxn call ? Yes

	public static void getNoStudents() {

		sayHi();
		System.out.println("Total Students are :  " + totalStudents);
	}
}
