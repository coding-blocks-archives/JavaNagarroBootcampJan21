package L23_Leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class _47_PermutationsII {

	public static void main(String[] args) {

		int[] arr = {1,1,1,2} ;
		
		System.out.println(permuteUnique(arr));
	}

	public static List<List<Integer>> permuteUnique(int[] arr) {

		Arrays.sort(arr) ;
		boolean[] available = new boolean[arr.length] ;
		Arrays.fill(available, true);
		
		List<List<Integer>> list = new ArrayList<>() ;
		
		permutation(arr, available, new ArrayList<>(), list);
		
		return list ;
		
		
	}
	
	public static void permutation(int[] arr, boolean[] available, List<Integer> temp, List<List<Integer>> list) {
		
		if(temp.size() ==arr.length) {
			list.add(new ArrayList<>(temp)) ;
			return ;
		}
		
		for (int i = 0; i < available.length; i++) {
			
			if(available[i] == false)
				continue ;
			
			if(i > 0 && arr[i] == arr[i-1] && available[i-1])
				continue ;
			
			available[i] = false ;
			temp.add(arr[i]) ;
			
			permutation(arr, available, temp, list);
			
			temp.remove(temp.size()-1) ;
			available[i] = true ;
			
			
		}
		
		
	}

}
