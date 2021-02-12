package L6_Functions;

import java.util.Scanner;

public class ShoppingGame {

	public static void main(String[] args) {

		Scanner scn = new Scanner(System.in);

		int tc = scn.nextInt();

		for (int t = 1; t <= tc; t++) {
			
			int aL = scn.nextInt();
			int hL = scn.nextInt();

			int aC = 0;
			int hC = 0;

			int i = 1;

			while (true) {

				// Aayush Turn
				if (i % 2 == 1) {

					// purchase
					if (aC + i <= aL)
						aC = aC + i;
					else {
						System.out.println("Harshit");
						break;
					}

				}
				// Harshit Turn
				else {

					// purchase
					if (hC + i <= hL)
						hC = hC + i;
					else {
						System.out.println("Aayush");
						break;
					}
				}

				i++;
			}
		}
	}

}
