package L6_Functions;

public class FunctionDemo {

	static int val = 10;

	public static void main(String[] args) {

		System.out.println("hii main");

		System.out.println("--- Case 1 ----");
		// call
		addition();
		subtraction();

		System.out.println("--- Case 2 ----");
		int a = 100;
		int b = 200;
		additionParams(a, b);

		System.out.println("--- Case 3 ----");
		int x = additionReturn(25, 30);
		System.out.println(x);

		System.out.println("--- Case 4 ----");
		System.out.println(val); // 10
		int val = 100;
		System.out.println(val); // 100
		System.out.println(FunctionDemo.val); // 10

		fun(FunctionDemo.val);

		System.out.println(val);
		System.out.println(FunctionDemo.val);

		System.out.println("--- Case 5 ---");
		int one = 20;
		int another = 30;

		System.out.println(one + " " + another);
		Swap(one, another);
		System.out.println(one + " " + another);

		System.out.println("bye main");

	}

	public static void Swap(int one, int two) {

		System.out.println(one + ", " + two);

		int temp = one;
		one = two;
		two = temp;

		System.out.println(one + ", " + two);
	}

	public static void fun(int a) {

		int val = 20;

		FunctionDemo.val = val + 30;

		System.out.println(val);
		System.out.println(FunctionDemo.val);

	}

	public static int additionReturn(int a, int b) {

		int sum = a + b;
		return sum;
	}

	public static void additionParams(int a, int b) {

		int sum = a + b;
		System.out.println(sum);

	}

	public static void addition() {

		int a = 10;
		int b = 20;

		int sum = a + b;

		subtraction();

		System.out.println(sum);

	}

	public static void subtraction() {

		int a = 100;
		int b = 60;

		int diff = a - b;

		System.out.println(diff);

	}

}
