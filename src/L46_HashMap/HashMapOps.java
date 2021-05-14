package L46_HashMap;

import java.util.HashMap;

public class HashMapOps {

	public static void main(String[] args) {

//		System.out.println(maxFreqChar("aaaabbccccccccccaaaaaaaaaaaaa"));

//		int[] one = { 10, 5, 6, 20, 30, 30, 40, 10, 5, 20, 20, 20 };
//		int[] two = { 30, 30, 30, 20, 20, 100, 75, 68 };
//
//		intersection(one, two);

		int[] arr = { 2, 12, 9, 16, 10, 5, 3, 20, 25, 11, 1, 8, 6 , 7};

		longestConsecutiveSeq(arr);

	}

	public static char maxFreqChar(String str) {

		HashMap<Character, Integer> map = new HashMap<>();

		for (int i = 0; i < str.length(); i++) {

			char ch = str.charAt(i);

//			if (map.containsKey(ch)) {
//
//				int of = map.get(ch);
//				int nf = of + 1;
//				map.put(ch, nf);
//
//			} else {
//				map.put(ch, 1);
//			}

			int nf = map.getOrDefault(ch, 0) + 1;
			map.put(ch, nf);

		}

		int max = 0;
		char maxFreqChar = ' ';

		for (char key : map.keySet()) {

			int val = map.get(key);

			if (val > max) {
				max = val;
				maxFreqChar = key;
			}

		}

		return maxFreqChar;

	}

	public static void intersection(int[] one, int[] two) {

		HashMap<Integer, Integer> map = new HashMap<>();

		// 1. create a freq map
		for (int key : one) {

			int nf = map.getOrDefault(key, 0) + 1;
			map.put(key, nf);
		}

		// 2. 2nd array iterate
		for (int key : two) {

			if (map.containsKey(key) && map.get(key) > 0) {

				System.out.println(key);
				map.put(key, map.get(key) - 1);

			}

		}

	}

	public static void longestConsecutiveSeq(int[] arr) {

		HashMap<Integer, Boolean> map = new HashMap<>();

		for (int key : arr) {

			if (map.containsKey(key - 1)) {
				map.put(key, false);
			} else {
				map.put(key, true);
			}

			if (map.containsKey(key + 1)) {
				map.put(key + 1, false);
			}
		}

		int max = 0;
		int startingPoint = 0;

		// loop on all keys
		for (int key : map.keySet()) {

			// filter out the keys which are starting point
			if (map.get(key)) {

				int count = 0;

				while (map.containsKey(key + count))
					count++;

				// System.out.println(key + " -> " + count);

				if (count > max) {
					max = count;
					startingPoint = key;
				}

			}

		}

		for (int i = 0; i < max; i++) {
			System.out.println(startingPoint + i);
		}

	}

}
