package DP;

import java.util.Arrays;

/**
 * @author Garima Chhikara
 * @email garima.chhikara@codingblocks.com
 *
 */

public class LCS3Strings {

	public static void main(String[] args) {

		String s1 = "abcdjhbch bdhb dc b hdjsb jsbdj";
		String s2 = "agcfd nxb jsdb,j bdjkn jrkndcxvhdsbj ";
		String s3 = "ad ncbx hdsjhvbjdhv jdhhjvnfjvnkr";

		// System.out.println(LCS3Strings(s1, s2, s3, 0, 0, 0));

		int[][][] strg = new int[s1.length()][s2.length()][s3.length()];
		for (int i = 0; i < strg.length; i++) {
			for (int j = 0; j < strg[0].length; j++) {
				Arrays.fill(strg[i][j], -1);
			}
		}

		System.out.println(LCS3StringsTD(s1, s2, s3, 0, 0, 0, strg));
		System.out.println(LCS3StringsBU(s1, s2, s3));
	}

	public static int LCS3StringsRec(String s1, String s2, String s3, int vidx1, int vidx2, int vidx3) {

		if (s1.length() == vidx1 || s2.length() == vidx2 || s3.length() == vidx3) {
			return 0;
		}

		int ans = 0;

		if (s1.charAt(vidx1) == s2.charAt(vidx2) && s2.charAt(vidx2) == s3.charAt(vidx3)) {
			ans = LCS3StringsRec(s1, s2, s3, vidx1 + 1, vidx2 + 1, vidx3 + 1) + 1;
		} else {

			int o1 = LCS3StringsRec(s1, s2, s3, vidx1 + 1, vidx2, vidx3);
			int o2 = LCS3StringsRec(s1, s2, s3, vidx1, vidx2 + 1, vidx3);
			int o3 = LCS3StringsRec(s1, s2, s3, vidx1, vidx2, vidx3 + 1);

			ans = Math.max(o1, Math.max(o2, o3));

		}

		return ans;

	}

	public static int LCS3StringsTD(String s1, String s2, String s3, int vidx1, int vidx2, int vidx3, int[][][] strg) {

		if (s1.length() == vidx1 || s2.length() == vidx2 || s3.length() == vidx3) {
			return 0;
		}

		if (strg[vidx1][vidx2][vidx3] != -1) {
			return strg[vidx1][vidx2][vidx3];
		}

		int ans = 0;

		if (s1.charAt(vidx1) == s2.charAt(vidx2) && s2.charAt(vidx2) == s3.charAt(vidx3)) {
			ans = LCS3StringsTD(s1, s2, s3, vidx1 + 1, vidx2 + 1, vidx3 + 1, strg) + 1;
		} else {

			int o1 = LCS3StringsTD(s1, s2, s3, vidx1 + 1, vidx2, vidx3, strg);
			int o2 = LCS3StringsTD(s1, s2, s3, vidx1, vidx2 + 1, vidx3, strg);
			int o3 = LCS3StringsTD(s1, s2, s3, vidx1, vidx2, vidx3 + 1, strg);

			ans = Math.max(o1, Math.max(o2, o3));

		}

		strg[vidx1][vidx2][vidx3] = ans;

		return ans;

	}

	public static int LCS3StringsBU(String s1, String s2, String s3) {

		int[][][] strg = new int[s1.length() + 1][s2.length() + 1][s3.length() + 1];

		for (int s1l = s1.length() - 1; s1l >= 0; s1l--) {
			for (int s2l = s2.length() - 1; s2l >= 0; s2l--) {
				for (int s3l = s3.length() - 1; s3l >= 0; s3l--) {

					int ans = 0;

					if (s1.charAt(s1l) == s2.charAt(s2l) && s2.charAt(s2l) == s3.charAt(s3l)) {
						ans = strg[s1l + 1][s2l + 1][s3l + 1] + 1;
					} else {

						int o1 = strg[s1l + 1][s2l][s3l];
						int o2 = strg[s1l][s2l + 1][s3l];
						int o3 = strg[s1l][s2l][s3l + 1];

						ans = Math.max(o1, Math.max(o2, o3));

					}

					strg[s1l][s2l][s3l] = ans;

				}
			}
		}

		return strg[0][0][0];

	}

}
