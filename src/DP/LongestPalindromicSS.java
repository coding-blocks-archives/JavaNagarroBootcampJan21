package DP;

/**
 * @author Garima Chhikara
 * @email garima.chhikara@codingblocks.com
 *
 */

public class LongestPalindromicSS {

	public static void main(String[] args) {

		String str = "abccgbncb dbnbshdjb";
		System.out.println(LongestPalindromicSSRec(str, 0, str.length() - 1));
		System.out.println(LongestPalindromicSSTD(str, 0, str.length() - 1, new int[str.length()][str.length()]));
		System.out.println(LongestPalindromicSSBU(str));

	}

	public static int LongestPalindromicSSRec(String str, int si, int ei) {

		if (si > ei) {
			return 0;
		}

		if (si == ei) {
			return 1;
		}

		int ans = 0;

		if (str.charAt(si) == str.charAt(ei)) {
			ans = LongestPalindromicSSRec(str, si + 1, ei - 1) + 2;
		} else {

			int o1 = LongestPalindromicSSRec(str, si + 1, ei);
			int o2 = LongestPalindromicSSRec(str, si, ei - 1);

			ans = Math.max(o1, o2);
		}

		return ans;

	}

	public static int LongestPalindromicSSTD(String str, int si, int ei, int[][] strg) {

		if (si > ei) {
			return 0;
		}

		if (si == ei) {
			return 1;
		}

		if (strg[si][ei] != 0) {
			return strg[si][ei];
		}

		int ans = 0;

		if (str.charAt(si) == str.charAt(ei)) {
			ans = LongestPalindromicSSTD(str, si + 1, ei - 1, strg) + 2;
		} else {

			int o1 = LongestPalindromicSSTD(str, si + 1, ei, strg);
			int o2 = LongestPalindromicSSTD(str, si, ei - 1, strg);

			ans = Math.max(o1, o2);
		}

		strg[si][ei] = ans;

		return ans;

	}

	public static int LongestPalindromicSSBU(String str) {

		int n = str.length();
		int[][] strg = new int[n][n];

		for (int slide = 0; slide <= n - 1; slide++) {

			for (int si = 0; si <= n - slide - 1; si++) {

				int ei = si + slide;

				if (si == ei) {
					strg[si][ei] = 1;
				} else {

					int ans = 0;

					if (str.charAt(si) == str.charAt(ei)) {
						ans = strg[si + 1][ei - 1] + 2;
					} else {

						int o1 = strg[si + 1][ei];
						int o2 = strg[si][ei - 1];

						ans = Math.max(o1, o2);
					}

					strg[si][ei] = ans;
				}

			}

		}

		return strg[0][n - 1];
	}

}
