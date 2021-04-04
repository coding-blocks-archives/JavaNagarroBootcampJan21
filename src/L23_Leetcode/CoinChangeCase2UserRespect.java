package L23_Leetcode;

public class CoinChangeCase2UserRespect {

	public static void main(String[] args) {
		
		int[] denom = {2,2,2,3,4} ;
		userRespect(denom, 0, 6, "");

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
			userRespect(denom, i+1, amt - denom[i], ans + denom[i]);
		}
	}
}
