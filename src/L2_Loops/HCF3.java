package L2_Loops;

import java.util.Scanner;

public class HCF3 {

	public static void main(String[] args) {

		Scanner scn = new Scanner(System.in);

		int divident = scn.nextInt();
		int divisor = scn.nextInt();
		
		while(true) {
			
			int rem = divident % divisor ;
			
			if(rem == 0)
				break ;
			
			divident = divisor ;
			divisor = rem ;
		
		}
		
		System.out.println(divisor);
		
		
	}
	
}
