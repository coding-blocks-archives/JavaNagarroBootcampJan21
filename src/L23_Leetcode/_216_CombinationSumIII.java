package L23_Leetcode;

import java.util.ArrayList;
import java.util.List;

public class _216_CombinationSumIII {

	public static void main(String[] args) {

		System.out.println(combinationSum3(3, 7));
	}

	public static List<List<Integer>> combinationSum3(int k, int n) {

		List<List<Integer>> list = new ArrayList<>();

		elementRespect(1, n, k, new ArrayList<>(), list);

		return list;
	}

	public static void userRespect(int start, int n, int k, List<Integer> temp, List<List<Integer>> list) {

		if (k == 0) {

			if (n == 0)
				list.add(new ArrayList<>(temp));

			return;
		}

		if (start > 9 || n < 0)
			return;

		for (int i = start; i <= 9; i++) {
			temp.add(i);
			userRespect(i + 1, n - i, k - 1, temp, list);
			temp.remove(temp.size() - 1);
		}
	}

	public static void elementRespect(int start, int n, int k, List<Integer> temp, List<List<Integer>> list) {

		if (k == 0) {

			if (n == 0)
				list.add(new ArrayList<>(temp));
			return;
		}

		if (start > 9 || n < 0)
			return;

		temp.add(start);
		elementRespect(start + 1, n - start, k - 1, temp, list);
		temp.remove(temp.size() - 1);

		elementRespect(start + 1, n, k, temp, list);

	}

}
