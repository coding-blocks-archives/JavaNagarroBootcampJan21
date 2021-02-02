package L1_Basics;

import java.util.Scanner;

public class Prime {

	public static void main(String[] args) {
		
		Scanner scn = new Scanner(System.in);
		int n = scn.nextInt();
		
		int fact = 0 ;

		int div = 1 ;
		while(div <= n) {
			
			if(n % div == 0) {
				fact = fact + 1 ;
			}
			
			div = div + 1 ;
		}
		
		if(fact == 2)
			System.out.println(n + " is prime");
		else
			System.out.println(n + " is not prime");
		

	}

}
