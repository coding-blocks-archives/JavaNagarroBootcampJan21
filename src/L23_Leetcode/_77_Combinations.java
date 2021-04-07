package L23_Leetcode;

import java.util.ArrayList;
import java.util.List;

public class _77_Combinations {

	public static void main(String[] args) {

		System.out.println(combine(4, 2));
	}

	public static List<List<Integer>> combine(int n, int k) {

		List<List<Integer>> list = new ArrayList<>() ;
		
		coinRespect(1, n, k, new ArrayList<>() , list);
		
		return list ;
	}

	public static void userRespect(int start, int n, int k, List<Integer> temp, List<List<Integer>> list ) {

		if(k == 0) {
			list.add(new ArrayList<>(temp)) ;
			return ;
		}
		
		if(start > n)
			return ;
		
		
		for (int i = start; i <= n; i++) {
			temp.add(i) ;
			userRespect(i + 1, n, k - 1,temp, list);
			temp.remove(temp.size()-1) ;
		}
	}
	
	public static void coinRespect(int start, int n, int k, List<Integer> temp, List<List<Integer>> list ) {

		if(k == 0) {
			list.add(new ArrayList<>(temp)) ;
			return ;
		}
		
		if(start > n)
			return ;
		
		temp.add(start) ;
		coinRespect(start+1, n, k-1, temp, list);
		temp.remove(temp.size()-1) ;
		
		coinRespect(start+1, n, k, temp, list);
		
	}

}
