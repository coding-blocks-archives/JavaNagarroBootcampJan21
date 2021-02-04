package L2_Loops;

import java.util.Scanner;

public class HCF2 {

	public static void main(String[] args) {
		
		Scanner scn = new Scanner(System.in) ;
		
		int n1 = scn.nextInt() ;
		int n2 = scn.nextInt() ;
		
		int min = Math.min(n1, n2) ;
		
		int hcf = 1;
		
		int count = 1 ;
		while(count <= min) {
			
			if(n1 % count == 0 && n2 % count == 0){
				hcf = count ;
			}
			
			count = count + 1 ;
		}
		
		System.out.println(hcf);
		

	}

}
