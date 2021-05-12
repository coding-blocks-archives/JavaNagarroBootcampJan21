package L45_Static;

public class Overloading {

	public static void main(String[] args) {

		sum(10, 20);
	}

//	public static void sum(int a, int b) {
//		System.out.println("In 2 Args Sum");
//		System.out.println(a + b);
//	}

	public static int sum(int a, int b) {
		System.out.println("In Return Sum");
		return a + b;
	}
	
	public static void sum(int a, int b, int c) {
		System.out.println("In 3 Args Sum");
		System.out.println(a + b + c);
	}

	public static void sum(double a, double b) {
		System.out.println("In Double Sum");
		System.out.println(a + b);
	}

	public static void sum(int b, int c, int... a) {

		System.out.println("in var args");

//		for(int val : a) {
//			System.out.println(val);
//		}

		for (int i = 0; i < a.length; i++) {
			System.out.println(a[i]);
		}

	}

}
