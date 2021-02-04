package L2_Loops;

import java.util.Scanner;

public class HCF {

	public static void main(String[] args) {
		
		Scanner scn = new Scanner(System.in) ;
		
		int n1 = scn.nextInt() ;
		int n2 = scn.nextInt() ;
		
		int min = Math.min(n1, n2) ;
		
		int count = min ;
		while(count >= 1) {
			
			if(n1 % count == 0 && n2 % count == 0){
				System.out.println(count);
				break ;
			}
			
			count = count - 1 ;
		}
		
		

	}

}
