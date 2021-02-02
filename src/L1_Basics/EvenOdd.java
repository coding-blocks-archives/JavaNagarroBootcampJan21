package L1_Basics;

import java.util.Scanner;

public class EvenOdd {

	public static void main(String[] args) {
		
		Scanner scn = new Scanner(System.in) ;
		
		int n = scn.nextInt() ;

		if (n % 2 == 0) {
			System.out.println(n + " is even");
		} else {
			System.out.println(n + " is odd");
		}

	}

}
