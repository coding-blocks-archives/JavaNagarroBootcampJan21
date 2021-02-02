package L1_Basics;

import java.util.Scanner;

public class SumN {

	public static void main(String[] args) {

		Scanner scn = new Scanner(System.in);
		int n = scn.nextInt();

		int sum = 0;

		int count = 1;

		while (count <= n) {

			sum = sum + count;
			count = count + 1;
		}

		System.out.println(sum);
	}

}
