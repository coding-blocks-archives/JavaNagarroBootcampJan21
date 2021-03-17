package L17_Recursion;

public class Recursion {

	public static void main(String[] args) {

//		System.out.println("hello");
//		PDI(3);
//		System.out.println("bye");

//		System.out.println(factorial(4));
//		System.out.println(power(3, 7));
		
		System.out.println(fibonacci(4));

	}

	// n -> 1 counting
	public static void PD(int n) {

		// base case
		if (n == 0)
			return;

		// work : n print
		System.out.println(n);

		// n-1 -> 1 counting
		PD(n - 1);
	}

	// BP : 1 -> n
	public static void PI(int n) {

		if (n == 0)
			return;

		// SP : 1 -> n-1
		PI(n - 1);

		// Work : n print
		System.out.println(n);
	}

	public static void PDI(int n) {

		if (n == 0)
			return;

		System.out.println("hii " + n);
		PDI(--n);
		System.out.println("bye " + n);

	}

	// BP : start->n n-> start
	public static void PID(int start, int n) {

		if (start == n + 1)
//		if(start > n)
			return;

		System.out.println(start);

		// SP : start+1->n n->start+1
		PID(start + 1, n);

		System.out.println(start);
	}

	// BP : n!
	public static int factorial(int n) {

		// Base Case
		if (n == 0)
			return 1;

		// SP : (n-1)!
		int fnm1 = factorial(n - 1);

		// Self Work
		int fn = fnm1 * n;

		return fn;

//		return factorial(n-1) * n ;
	}

	public static int power(int b, int e) {

		if(e == 0)
			return 1 ;
		
		int sp = power(b, e - 1);
		int bp = sp * b;

		return bp;

	}

	public static int fibonacci(int n) {
		
		if(n == 0 || n == 1) {
			return n ;
		}
		
		int fnm1 = fibonacci(n-1) ;
		int fnm2 = fibonacci(n-2) ;
		
		int fn = fnm1 + fnm2 ;
		
		return fn ;
	}













}



