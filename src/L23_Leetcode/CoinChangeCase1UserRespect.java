package L23_Leetcode;

import java.util.ArrayList;
import java.util.List;

public class CoinChangeCase1UserRespect {

	public static void main(String[] args) {
		
		int[] denom = {1,2,3} ;
//		userRespect(denom, 0, 5, "");
		
		List<List<Integer>> list = new ArrayList<>() ;
		userRespect(denom, 0, 5, new ArrayList<>(), list);
		
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
			userRespect(denom, i, amt - denom[i], ans + denom[i]);
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
			temp.add(denom[i]) ;
			userRespect(denom, i, amt - denom[i],  temp, list);
			temp.remove(temp.size()-1) ;
		}
	}
}










