package L23_Leetcode;

import java.util.ArrayList;
import java.util.List;

public class SubsetCase1UserRespect {

	public static void main(String[] args) {

		int[] arr = { 1, 2, 3 };

		List<List<Integer>> list = new ArrayList<>();

		userRespect(arr, 0, new ArrayList<>(), list);

		System.out.println(list);

	}

	public static void userRespect(int[] arr, int vidx, String ans) {

		System.out.println(ans);

		for (int i = vidx; i < arr.length; i++) {
			userRespect(arr, i + 1, ans + arr[i]);
		}

	}

	public static void userRespect(int[] arr, int vidx, List<Integer> temp, List<List<Integer>> list) {

		list.add(new ArrayList<>(temp));

		for (int i = vidx; i < arr.length; i++) {
			temp.add(arr[i]);
			userRespect(arr, i + 1, temp, list);
			temp.remove(temp.size() - 1);
		}

	}

}






