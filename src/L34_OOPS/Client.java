package L34_OOPS;

public class Client {

	public static void main(String[] args) {

		Student s = new Student("Kamal", 25);
		s.introduceYourself();
		
		Student s1 = new Student() ;
		s1.introduceYourself();

	}

}
