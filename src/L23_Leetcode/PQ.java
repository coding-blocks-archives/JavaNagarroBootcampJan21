package L23_Leetcode;

import java.util.ArrayList;

public class PQ {

	public static void main(String[] args) {

		String A = "abcdefabcd";
		String D = "ab";
		String E = "cd";
		String F = "e";

		ans = Integer.MAX_VALUE;
		Jon2(A, D, E, F);
		System.out.println(ans);

	}
	

	static int ans;
	
	public static void Jon2(String A, String D, String E, String F) {

		if (A.length() == 0) {
			ans = 0;
			return;
		}

		int idx1 = A.indexOf(D);
		int idx2 = A.indexOf(E);
		int idx3 = A.indexOf(F);

		if (idx1 == -1 && idx2 == -1 && idx3 == -1) {
			ans = Math.min(ans, A.length());
			return;
		}

		if (idx1 != -1) {
			String roa = A.substring(0, idx1) + A.substring(idx1 + D.length());
			Jon2(roa, D, E, F);

		}

		if (idx2 != -1) {
			String roa = A.substring(0, idx2) + A.substring(idx2 + E.length());
			Jon2(roa, D, E, F);
		}

		if (idx3 != -1) {
			String roa = A.substring(0, idx3) + A.substring(idx3 + F.length());
			Jon2(roa, D, E, F);

		}

	}

	public static void Jon1(String A, String D, String E, String F, int flag) {

		ArrayList<Integer> list1 = occurrence(A, D);
		ArrayList<Integer> list2 = occurrence(A, E);
		ArrayList<Integer> list3 = occurrence(A, F);

		if (list1.size() == 0 && list2.size() == 0 && list3.size() == 0) {
			ans = Math.min(ans, A.length());
			return;
		}

		String ps;
		ArrayList<Integer> list;

		if (flag == 1) {
			ps = D;
			list = list1;
		} else if (flag == 2) {
			ps = E;
			list = list2;
		} else {
			ps = F;
			list = list3;
		}

		if (list.size() != 0) {
			for (int idx : list) {

				String roa = A.substring(0, idx) + A.substring(idx + ps.length());
				Jon1(roa, D, E, F, (flag + 1) % 3);

			}
		} else {

			Jon1(A, D, E, F, (flag + 1) % 3);

		}

	}

	public static ArrayList<Integer> occurrence(String src, String pat) {

		ArrayList<Integer> list = new ArrayList<Integer>();

		for (int i = 0; i <= src.length() - pat.length(); i++) {

			int j = 0;

			while (j < pat.length()) {

				if (src.charAt(i + j) != pat.charAt(j)) {
					break;
				}

				j++;
			}

			if (j == pat.length()) {
				list.add(i);
			}
		}

		return list;
	}

}
