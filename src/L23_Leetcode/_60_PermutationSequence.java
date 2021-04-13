package L23_Leetcode;

import java.util.ArrayList;

public class _60_PermutationSequence {

	public static void main(String[] args) {

		System.out.println(getPermutation(4, 17));
	}

	public static String getPermutation(int n, int k) {

		int[] fact = new int[n];
		fact[0] = 1;
		for (int i = 1; i < fact.length; i++) {
			fact[i] = fact[i - 1] * i;
		}

		ArrayList<Integer> list = new ArrayList<>();
		for (int i = 0; i <= n; i++)
			list.add(i);

		return permutation(n, k, fact, list, "");
	}

	public static String permutation(int n, int k, int[] fact, ArrayList<Integer> list , String ans) {

		if(n == 0) {
			return ans ;
		}
		
		int group = k / fact[n - 1];

		if (k % fact[n - 1] != 0)
			group++;

		int newk = k - (group - 1) * fact[n - 1];

		int val = list.remove(group) ;
		
		return permutation(n - 1, newk, fact, list , ans+val);

	}

}









