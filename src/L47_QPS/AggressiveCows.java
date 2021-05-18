package L47_QPS;

import java.util.Arrays;
import java.util.Scanner;

public class AggressiveCows {

	public static void main(String[] args) {

		Scanner scn = new Scanner(System.in);

		int nos = scn.nextInt();
		int noc = scn.nextInt();

		int[] stall = new int[nos];

		for (int i = 0; i < nos; i++) {
			stall[i] = scn.nextInt();
		}

		Arrays.sort(stall);

		// logic binary search ...
		int lo = 0;
		int hi = stall[stall.length - 1] - stall[0];
		
		int finalAns = 0 ;

		while (lo <= hi) {

			int mid = (lo + hi) / 2;

			if (isItPossible(stall, noc, mid)) {
				
				finalAns = mid ;
				lo = mid + 1;
				
			} else {
				hi = mid - 1;
			}

		}
		
		System.out.println(finalAns);

	}

	public static boolean isItPossible(int[] stall, int noc, int mid) {

		int cowsPlaced = 1 ;
		int pos = stall[0] ;
		
		for(int i = 1 ; i < stall.length ; i++) {
			
			if(stall[i] - pos >= mid) {
				cowsPlaced ++ ;
				pos = stall[i] ;
				
				if(cowsPlaced == noc)
					return true ;
			}
			
		}
		
		return false ;
		
		
	}

}











