package L23_Leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CoinChangeCase3CoinRespect {

	public static void main(String[] args) {

		int[] denom = { 1, 2, 2, 2, 3, 3, 4 };
		Arrays.sort(denom);
		// coinRespect(denom, 0, 5, "", true);
		
		List<List<Integer>> list = new ArrayList<>() ;
		coinRespect(denom, 0, 6, new ArrayList<>(), list, true);
		
		System.out.println(list);

	}

	public static void coinRespect(int[] denom, int vidx, int amt, String ans, boolean flag) {

		if (amt == 0) {
			System.out.println(ans);
			return;
		}

		if (vidx == denom.length || amt < 0) {
			return;
		}

		if (flag == false && denom[vidx] == denom[vidx - 1]) {
			coinRespect(denom, vidx + 1, amt, ans, false);
		} else {
			coinRespect(denom, vidx + 1, amt - denom[vidx], ans + denom[vidx], true);
			coinRespect(denom, vidx + 1, amt, ans, false);
		}

	}
	
	public static void coinRespect(int[] denom, int vidx, int amt, List<Integer> temp, List<List<Integer>> list, boolean flag) {

		if (amt == 0) {
			list.add(new ArrayList<>(temp)) ;
			return;
		}

		if (vidx == denom.length || amt < 0) {
			return;
		}

		if (flag == false && denom[vidx] == denom[vidx - 1]) {
			coinRespect(denom, vidx + 1, amt, temp, list, false);
		} else {
			temp.add(denom[vidx]) ;
			coinRespect(denom, vidx + 1, amt - denom[vidx], temp, list, true);
			temp.remove(temp.size()-1) ;
			
			coinRespect(denom, vidx + 1, amt, temp, list, false);
		}

	}
}
