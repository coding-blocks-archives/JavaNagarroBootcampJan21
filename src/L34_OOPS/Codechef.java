package L34_OOPS;

import java.util.Scanner;

// https://www.codechef.com/problems/BUILDB

public class Codechef {

	public static void main(String[] args) {

		Scanner scn = new Scanner(System.in);

		int tc = scn.nextInt();

		for (int i = 0; i < tc; i++) {

			int n = scn.nextInt();

			int r = scn.nextInt();

			int[] A = new int[n];
			int[] B = new int[n];

			for (int j = 0; j < n; j++) {
				A[j] = scn.nextInt();
			}

			for (int j = 0; j < n; j++) {
				B[j] = scn.nextInt();
			}

			long max = B[0];
			long tension = B[0];

			for (int k = 1; k < n; k++) {

				tension -= (A[k] - A[k - 1]) * r;

				if (tension < 0) {
					tension = 0;
				}

				tension += B[k];

				if (tension > max) {
					max = tension;
				}
			}

			System.out.println(max);
		}

		scn.close();

	}

}
