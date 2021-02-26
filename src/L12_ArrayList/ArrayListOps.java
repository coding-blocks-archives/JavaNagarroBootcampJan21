package L12_ArrayList;

import java.util.ArrayList;

public class ArrayListOps {

	public static void main(String[] args) {

		int[] one = { 5, 10, 20, 20, 30, 30, 40 };
		int[] two = { 20, 20, 30, 40, 40, 50 };

		System.out.println(intersection(one, two));
	}

	public static ArrayList<Integer> intersection(int[] one, int[] two) {

		ArrayList<Integer> ans = new ArrayList<Integer>();

		// logic ...
		int i = 0;
		int j = 0;

		while (i < one.length && j < two.length) {

			if (one[i] < two[j])
				i++;

			else if (one[i] > two[j])
				j++;

			else {
				ans.add(one[i]);
				i++;
				j++;
			}

		}

		return ans;

	}

}
