package L47_QPS;

import java.util.HashSet;

public class Subarray0sum {

	public static void main(String[] args) {

		int[] arr = { 6, 3, -1, -3, 4, -2, 2, 4, 6, -12, -7 };
		
		System.out.println(subarray0sum(arr)) ;

	}

	public static boolean subarray0sum(int[] arr) {

		HashSet<Integer> set = new HashSet<>();
		set.add(0);

		int sum = 0;

		for (int i = 0; i < arr.length; i++) {

			sum += arr[i];

			if (set.contains(sum)) {
				return true;
			}

			set.add(sum);
		}

		return false;

	}

}
