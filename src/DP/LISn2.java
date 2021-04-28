package DP;

import java.util.Arrays;

/**
 * @author Garima Chhikara
 * @email garima.chhikara@codingblocks.com
 *
 */

public class LISn2 {

	public static void main(String[] args) {

		int[] arr = { 3, 4, -1, 0, 6, 2, 3 };
		System.out.println(LISBU(arr));
	}

	public static int LISBU(int[] arr) {

		int max = Integer.MIN_VALUE;

		int[] strg = new int[arr.length];

		Arrays.fill(strg, 1);

		for (int i = 0; i < strg.length; i++) {

			for (int j = 0; j < i; j++) {

				if (arr[j] < arr[i]) {
					strg[i] = Math.max(strg[i], strg[j] + 1);

					max = Math.max(max, strg[i]);
				}
			}
		}

		return max;

	}
}
