package L47_QPS;

import java.util.Deque;
import java.util.LinkedList;

public class MaxWindowK {

	public static void main(String[] args) {

		"abc".compareTo("def") ;
		int[] arr = { 80, 7, 5, 10, 50, 40, 60, 90 };
		int k = 4;

		Deque<Integer> q = new LinkedList<>();

		for (int i = 0; i < k; i++) {

			while (!q.isEmpty() && arr[i] >= arr[q.peekLast()]) {
				q.removeLast();
			}

			q.add(i);
		}

		System.out.println(arr[q.peekFirst()]);

		for (int i = k; i < arr.length; i++) {

			// out of window
			if (!q.isEmpty() && q.peekFirst() == i - k) {
				q.removeFirst();
			}

			// new value remove , smaller values remove
			while (!q.isEmpty() && arr[i] >= arr[q.peekLast()]) {
				q.removeLast();
			}

			// self add
			q.addLast(i);

			// ans
			System.out.println(arr[q.peekFirst()]);

		}

	}

}
