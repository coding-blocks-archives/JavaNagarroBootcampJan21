package L47_QPS;

import java.util.Arrays;

public class SumSubsequenceWidths {

	public static void main(String[] args) {

		int[] arr = { 5, 69, 89, 92, 31, 16, 25, 45, 63, 40, 16, 56, 24, 40, 75, 82, 40, 12, 50, 62, 92, 44, 67, 38, 92,
				22, 91, 24, 26, 21, 100, 42, 23, 56, 64, 43, 95, 76, 84, 79, 89, 4, 16, 94, 16, 77, 92, 9, 30, 13 };
		System.out.println(sumSubseqWidths(arr));
	}

	public static int sumSubseqWidths(int[] arr) {

		Arrays.sort(arr);

		int mod = 1000_000_007;

		// create an array which is storing powers of 2
		long[] power = new long[arr.length];

		power[0] = 1;
		for (int i = 1; i < power.length; i++) {
			power[i] = (power[i - 1] * 2) % mod;
		}

		long max = 0;
		long min = 0;

		// go to every element and ask for its contribution in max and min
		for (int i = 0; i < arr.length; i++) {

			max = (max + arr[i] * power[i]) % mod;
			min = (min + arr[i] * power[arr.length - i - 1]) % mod;

		}

		return (int) (max - min + mod) % mod;

	}

}
