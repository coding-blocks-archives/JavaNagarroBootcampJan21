package L23_Leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CoinChangeCase3UserRespect {

	public static void main(String[] args) {
		
		int[] denom = {2,2,2,3,4} ;
		Arrays.sort(denom);
		// userRespect(denom, 0, 6, "");
		
		List<List<Integer>> list = new ArrayList<>() ;
		userRespect(denom, 0, 6, new ArrayList<>(), list);
		
		System.out.println(list);

	}

	public static void userRespect(int[] denom, int vidx, int amt, String ans) {

		if (amt == 0) {
			System.out.println(ans);
			return;
		}

		if (amt < 0) {
			return;
		}

		for (int i = vidx; i < denom.length; i++) {
			
			if(i > vidx && denom[i] == denom[i-1])
				continue ;
			
			userRespect(denom, i+1, amt - denom[i], ans + denom[i]);
		}
	}
	
	public static void userRespect(int[] denom, int vidx, int amt, List<Integer> temp, List<List<Integer>> list) {

		if (amt == 0) {
			list.add(new ArrayList<>(temp)) ;
			return;
		}

		if (amt < 0) {
			return;
		}

		for (int i = vidx; i < denom.length; i++) {
			
			if(i > vidx && denom[i] == denom[i-1])
				continue ;
			
			temp.add(denom[i]) ;
			userRespect(denom, i+1, amt - denom[i], temp, list);
			temp.remove(temp.size()-1) ;
		}
	}
}











