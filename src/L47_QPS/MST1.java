package L47_QPS;

import java.util.Scanner;

public class MST1 {

	public static void main(String[] args) {

		Scanner scn = new Scanner(System.in);

		int tc = scn.nextInt();

		int[] arr = new int[tc];
		int max = Integer.MIN_VALUE;

		for (int i = 0; i < arr.length; i++) {
			arr[i] = scn.nextInt();
			max = Math.max(max, arr[i]);
		}

		int n = max;
		int[] strg = new int[n + 1];
		strg[1] = 0;

		for (int i = 2; i <= n; i++) {

			int ans = strg[i - 1];

			if (i % 2 == 0)
				ans = Math.min(ans, strg[i / 2]);

			if (i % 3 == 0)
				ans = Math.min(ans, strg[i / 3]);

			strg[i] = ans + 1;

		}

		for (int i = 0; i < tc; i++)
			System.out.println("Case " + (i + 1) + ": " + strg[arr[i]]);

	}

}
