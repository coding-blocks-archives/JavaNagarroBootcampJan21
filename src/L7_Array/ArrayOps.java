package L7_Array;

import java.util.Scanner;

public class ArrayOps {

	static Scanner scn = new Scanner(System.in);

	public static void main(String[] args) {

		// int[] a = takeInput();
		int[] a = { 10, 20, 30, 40, 50, 60 };
		display(a);

		// System.out.println(maximum(a));
		// System.out.println(linearSearch(a, 80));
		// System.out.println(binarySearch(a, 25));

		// reverse(a);
		rotate2(a, 2);
		display(a);

	}

	public static int[] takeInput() {

		System.out.println("Size ?");
		int n = scn.nextInt();

		int[] arr = new int[n];

		for (int i = 0; i < arr.length; i++) {

			System.out.println("arr[" + i + "] ?");
			arr[i] = scn.nextInt();

		}

		return arr;

	}

	public static void display(int[] arr) {

		for (int val : arr)
			System.out.print(val + " ");

		System.out.println();
	}

	public static int maximum(int[] arr) {

		int max = Integer.MIN_VALUE;

		for (int i = 0; i < arr.length; i++) {

			if (arr[i] > max)
				max = arr[i];

		}

		return max;

	}

	public static int linearSearch(int[] arr, int item) {

		for (int i = 0; i < arr.length; i++) {

			if (arr[i] == item)
				return i;
		}

		return -1;
	}

	public static int binarySearch(int[] arr, int item) {

		int lo = 0;
		int hi = arr.length - 1;

		while (lo <= hi) {

			int mid = (lo + hi) / 2;

			if (item > arr[mid]) // Right Side
				lo = mid + 1;
			else if (item < arr[mid]) // Left Side
				hi = mid - 1;
			else
				return mid;

		}

		return -1;

	}

	public static void reverse(int[] arr) {

		int i = 0;
		int j = arr.length - 1;

		while (i < j) {

			int temp = arr[i];
			arr[i] = arr[j];
			arr[j] = temp;

			i = i + 1;
			j = j - 1;
		}

	}

	public static void reverse(int[] arr, int si, int ei) {

		int i = si;
		int j = ei;

		while (i < j) {

			int temp = arr[i];
			arr[i] = arr[j];
			arr[j] = temp;

			i = i + 1;
			j = j - 1;
		}

	}

	public static void rotate(int[] arr, int rot) {

		rot = rot % arr.length;

		for (int r = 1; r <= rot; r = r + 1) {

			// single rotation
			int temp = arr[arr.length - 1];

			for (int j = arr.length - 1; j >= 1; j = j - 1)
				arr[j] = arr[j - 1];

			arr[0] = temp;

		}

	}

	public static void rotate2(int[] arr, int rot) {

		rot = rot % arr.length;

		reverse(arr, 0, arr.length - rot - 1); // arr.length - rot
		reverse(arr, arr.length - rot, arr.length - 1); // rot

		reverse(arr);
	}

}
