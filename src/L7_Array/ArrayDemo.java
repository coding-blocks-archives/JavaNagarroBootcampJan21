package L7_Array;

public class ArrayDemo {

	public static void main(String[] args) {

		// create
		int[] arr = null;
		System.out.println(arr);
		arr = new int[5];
		System.out.println(arr);

		// get
		System.out.println(arr[0]);
		System.out.println(arr[1]);
		System.out.println(arr[2]);
		System.out.println(arr[3]);
		System.out.println(arr[4]);

		// set/update
		arr[0] = 10;
		arr[1] = 20;
		arr[2] = 30;
		arr[3] = 40;
		arr[4] = 50;

		// get
		System.out.println(arr[0]);
		System.out.println(arr[1]);
		System.out.println(arr[2]);
		System.out.println(arr[3]);
		System.out.println(arr[4]);

		// for loop
		for (int i = 0; i < arr.length; i = i + 1) {
			System.out.println(arr[i]);
			// arr[i] = 100 ;
		}

		System.out.println(arr.length);

		// enhanced for loop
		System.out.println("--- EFL ---");

		for (int val : arr) {
			System.out.println(val);
			val = 100;
		}

		for (int val : arr)
			System.out.println(val);

		int[] arr1 = arr;

		// arr[2] = 200 ;
		System.out.println(arr1[2]);

		int[] other = new int[3];
		other[0] = 100;
		other[1] = 200;
		other[2] = 300;

		arr1 = other;

		// demos
		int[] one = { 10, 20, 30, 40, 50 }; // hard core
		int[] two = { 100, 200, 300 };

		// case 1
		System.out.println(one[0] + " " + two[0]);
		swap(one[0], two[0]);
		System.out.println(one[0] + " " + two[0]);

		// case 2
		System.out.println(one[0] + " " + two[0]);
		// swap(one, two);
		System.out.println(one[0] + " " + two[0]);

		// case 3
		System.out.println(one[0] + " " + two[0]);
		swap(one, two);
		System.out.println(one[0] + " " + two[0]);

	}

	public static void swap(int[] a, int[] b) {

		int[] temp = a;
		a = b;
		b = temp;

	}

	// public static void swap(int[] a, int[] b) {
	//
	// int temp = a[0];
	// a[0] = b[0];
	// b[0] = temp;
	// }

	public static void swap(int a, int b) {

		int temp = a;
		a = b;
		b = temp;

	}

}
