package L7_Array;

import java.util.Arrays;
import java.util.Scanner;

public class PairOfRoses {

	public static void main(String[] args) {
		
		Scanner scn = new Scanner(System.in) ;
		
		int tc = scn.nextInt() ;
		
		while(tc > 0) {
			
			int n = scn.nextInt() ;
			
			int[] arr = new int[n] ;
			
			for (int i = 0; i < arr.length; i++) {
				arr[i] = scn.nextInt() ;
			}
			
			int target = scn.nextInt() ;
			
			targetSumPair(arr, target);
			
			tc -- ;
		}
	}
	public static void targetSumPair(int[] arr, int target) {

		int si = 0;
		int ei = 0 ;
		// array sort
		Arrays.sort(arr);

		// logic ...
		int i = 0;
		int j = arr.length - 1;

		while (i < j) {

			if (arr[i] + arr[j] > target)
				j--;
			else if (arr[i] + arr[j] < target)
				i++;
			else {

				si = i ;
				ei = j ;
				i++;
				j--;

			}
		}
		
		System.out.println("Deepak should buy roses whose prices are " + arr[si] + " and " + arr[ei] + ".");

	}

	
}
