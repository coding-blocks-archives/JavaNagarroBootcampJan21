package L12_ArrayList;

import java.util.ArrayList;
import java.util.Collections;

public class ArrayListOps {

	public static void main(String[] args) {

//		int[] one = { 5, 10, 20, 20, 30, 30, 40 };
//		int[] two = { 20, 20, 30, 40, 40, 50 };
//
//		System.out.println(intersection(one, two));

		int[] one = { 9, 8, 7, 5 };
		int[] two = { 9, 6, 7 };

		System.out.println(sumTwoArrays(one, two));

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

	public static ArrayList<Integer> sumTwoArrays(int[] one, int[] two) {

		ArrayList<Integer> res = new ArrayList<Integer>();

		int i = one.length - 1;
		int j = two.length - 1;

		int carry = 0;

		while (i >= 0 || j >= 0) {

			int sum = carry;

			if (i >= 0)
				sum += one[i];

			if (j >= 0)
				sum += two[j];

			int rem = sum % 10;
			res.add(rem);

			carry = sum / 10;

			i--;
			j--;

		}

		if (carry > 0)
			res.add(carry);

		Collections.reverse(res);

		return res;
	}
}
