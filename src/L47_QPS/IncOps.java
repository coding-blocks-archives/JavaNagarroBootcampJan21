package L47_QPS;

import java.util.Scanner;

public class IncOps {

	public static void main(String[] args) {

		Scanner scn = new Scanner(System.in);

		int n = scn.nextInt();
		int m = scn.nextInt();

		int[] arr = new int[n + 1];

		for (int i = 1; i <= m; i++) {

			int a = scn.nextInt();
			int b = scn.nextInt();
			int k = scn.nextInt();

			arr[a] += k;
			arr[b + 1] -= k;

		}

		int max = Integer.MIN_VALUE;

		int sum = 0;
		for (int i = 0; i < arr.length - 1; i++) {
			
			sum += arr[i];
			
			if (sum > max)
				max = sum;
		}

		System.out.println(max);

	}

}
