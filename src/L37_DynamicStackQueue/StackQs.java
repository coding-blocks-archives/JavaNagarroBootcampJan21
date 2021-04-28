package L37_DynamicStackQueue;

import java.util.Stack;

public class StackQs {

	public static void main(String[] args) throws Exception {

//		DynamicStack ds = new DynamicStack();
//		ds.push(10);
//		ds.push(20);
//		ds.push(30);
//		ds.push(40);
//
//		System.out.println("----- Display Reverse -----");
//		ds.display();
//		displayReverse(ds);
//		System.out.println();
//		ds.display();
//
//		System.out.println("----- Actual Reverse -----");
//		ds.display();
//		actualReverse(ds, new DynamicStack());
//		ds.display();

//		int[][] arr = { { 0, 1, 0, 1 }, { 1, 0, 1, 0 }, { 0, 0, 0, 0 }, { 1, 1, 1, 0 } };
//
//		celebrityProblem(arr);

//		int[] arr = { 50, 30, 20, 40, 10, 45, 5, 60, 8, 15 };
//		int[] res = nextGreaterElement3(arr);

		int[] arr = { 80, 50, 70, 30, 20, 40, 90, 10, 15, 35 };
		int[] res = stockSpan(arr);

		for (int i = 0; i < res.length; i++) {
			System.out.println(arr[i] + " -> " + res[i]);
		}

	}

	public static void displayReverse(DynamicStack s) throws Exception {

		if (s.isEmpty()) {
			return;
		}

		int temp = s.pop();

		displayReverse(s);

		System.out.print(temp + " ");
		s.push(temp);

	}

	public static void actualReverse(DynamicStack s, DynamicStack helper) throws Exception {

		if (s.isEmpty()) {
			actualReverse2(s, helper);
//			s = helper;
			return;
		}

		int temp = s.pop();
		helper.push(temp);

		actualReverse(s, helper);

	}

	public static void actualReverse2(DynamicStack s, DynamicStack helper) throws Exception {

		if (helper.isEmpty()) {
			return;
		}

		int temp = helper.pop();
		actualReverse2(s, helper);
		s.push(temp);

	}

	public static void celebrityProblem(int[][] arr) {

		Stack<Integer> s = new Stack<>();

		for (int i = 0; i < arr.length; i++) {
			s.push(i);
		}

		while (s.size() >= 2) {

			int a = s.pop();
			int b = s.pop();

			// a knows b , a can't be a celeb , a discard
			if (arr[a][b] == 1) {
				s.push(b);
			}
			// a doesn't know b , b can't be celeb , b discard
			else {
				s.push(a);
			}

		}

		int candidate = s.pop();

		for (int i = 0; i < arr.length; i++) {

			if (i != candidate) {

				if (arr[candidate][i] == 1 || arr[i][candidate] == 0) {
					System.out.println("No celeb");
					return;
				}

			}
		}

		System.out.println(candidate + " is celebrity");

	}

	public static void nextGreaterElement(int[] arr) {

		Stack<Integer> s = new Stack<>();

		// go to every element
		for (int i = 0; i < arr.length; i++) {

			// arr[i] want to be next greater
			while (!s.isEmpty() && arr[i] >= s.peek()) {
				System.out.println(s.pop() + " -> " + arr[i]);
			}

			// push arr[i]
			s.push(arr[i]);
		}

		// if some values are left in stack, then there nge is -1
		while (!s.isEmpty()) {
			System.out.println(s.pop() + " -> -1");
		}

	}

	public static int[] nextGreaterElement2(int[] arr) {

		int[] ans = new int[arr.length];

		Stack<Integer> s = new Stack<>();

		// go to every element
		for (int i = 0; i < arr.length; i++) {

			// arr[i] want to be next greater
			while (!s.isEmpty() && arr[i] >= arr[s.peek()]) {
				ans[s.pop()] = arr[i];
			}

			// push index i
			s.push(i);
		}

		// if some values are left in stack, then there nge is -1
		while (!s.isEmpty()) {
			ans[s.pop()] = -1;
		}

		return ans;

	}

	public static int[] nextGreaterElement3(int[] arr) {

		Stack<Integer> s = new Stack<>();

		int[] ans = new int[arr.length];

		for (int i = arr.length - 1; i >= 0; i--) {

			while (!s.isEmpty() && s.peek() <= arr[i]) {
				s.pop();
			}

			if (s.isEmpty())
				ans[i] = -1;
			else
				ans[i] = s.peek();

			s.push(arr[i]);

		}

		return ans;

	}

	public static int[] stockSpan(int[] arr) {

		Stack<Integer> s = new Stack<>();

		int[] ans = new int[arr.length];

		for (int i = 0; i < arr.length; i++) {

			while (!s.isEmpty() && arr[i] >= arr[s.peek()]) {
				s.pop();
			}

			if (s.isEmpty())
				ans[i] = i;
			else
				ans[i] = i - s.peek() - 1;

			s.push(i);

		}

		return ans;

	}

}
