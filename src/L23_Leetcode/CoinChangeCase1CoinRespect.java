package L23_Leetcode;

import java.util.ArrayList;
import java.util.List;

public class CoinChangeCase1CoinRespect {

	public static void main(String[] args) {

		int[] denom = { 1, 2, 3 };
//		coinRespect(denom, 0, 5, "");
		
		List<List<Integer>> list = new ArrayList<>() ;
		coinRespect(denom, 0, 5, new ArrayList<>(), list);
		
		System.out.println(list);

	}

	public static void coinRespect(int[] denom, int vidx, int amt, String ans) {

		if (amt == 0) {
			System.out.println(ans);
			return;
		}

		if (vidx == denom.length || amt < 0) {
			return;
		}

		coinRespect(denom, vidx, amt - denom[vidx], ans + denom[vidx]);
		coinRespect(denom, vidx + 1, amt, ans);
		
	}
	
	public static void coinRespect(int[] denom, int vidx, int amt, List<Integer> temp, List<List<Integer>> list) {

		if (amt == 0) {
			list.add(new ArrayList<>(temp)) ;
			return;
		}

		if (vidx == denom.length || amt < 0) {
			return;
		}

		temp.add(denom[vidx]) ;
		coinRespect(denom, vidx, amt - denom[vidx], temp, list);
		temp.remove(temp.size()-1) ;
		
		coinRespect(denom, vidx + 1, amt, temp, list);
		
	}
}
