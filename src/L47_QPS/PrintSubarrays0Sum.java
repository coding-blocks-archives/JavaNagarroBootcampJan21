package L47_QPS;

import java.util.ArrayList;
import java.util.HashMap;

public class PrintSubarrays0Sum {

	public static void main(String[] args) {

		int[] arr = { 6, 3, -1, -3, 4, -2, 2, 4, 6, -12, -7 };

		printSubarray0Sum(arr);

	}

	public static void printSubarray0Sum(int[] arr) {

		HashMap<Integer, ArrayList<Integer>> map = new HashMap<>();

		map.put(0, new ArrayList<>());
		map.get(0).add(-1);

		int sum = 0;

		for (int i = 0; i < arr.length; i++) {

			// prefix sum
			sum += arr[i];

			// create a new entry
			if (!map.containsKey(sum)) {
				map.put(sum, new ArrayList<>());
			}

			// ans
			ArrayList<Integer> temp = map.get(sum);
			for (int val : temp) {
				System.out.println(val + 1 + " -> " + i);
			}

			// add your index corresponding to prefix sum
			map.get(sum).add(i);

		}

	}

}
