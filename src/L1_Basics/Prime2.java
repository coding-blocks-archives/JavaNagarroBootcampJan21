package L1_Basics;

import java.util.Scanner;

public class Prime2 {

	public static void main(String[] args) {
		
		Scanner scn = new Scanner(System.in);
		int n = scn.nextInt();
		
		int fact = 0 ;

		int div = 2 ;
		while(div * div <= n) {
			
			if(n % div == 0) {
				fact = fact + 1 ;
				break ;
			}
			
			div = div + 1 ;
		}
		
		if(fact == 0)
			System.out.println("Prime");
		else
			System.out.println("Not Prime");
		

	}

}
