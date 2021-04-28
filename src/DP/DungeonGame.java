package DP;

/**
 * @author Garima Chhikara
 * @email garima.chhikara@codingblocks.com
 *
 */

public class DungeonGame {

	public static void main(String[] args) {

		int[][] arr = { { -2, -3, 3 }, { -5, -10, 1 }, { 10, 30, -5 } };

		// System.out.println(DungeonGameRec(arr, 0, 0, arr.length - 1, arr[0].length -
		// 1));
		System.out.println(
				DungeonGameTD(arr, 0, 0, arr.length - 1, arr[0].length - 1, new int[arr.length][arr[0].length]));

		System.out.println(DungeonGameBU(arr));
	}

	public static int DungeonGameRec(int[][] arr, int cr, int cc, int er, int ec) {

		if (cr == er && cc == ec) {
			return arr[cr][cc] <= 0 ? -arr[cr][cc] + 1 : 1;
		}

		if (cr > er || cc > ec) {
			return Integer.MAX_VALUE;
		}

		int r = DungeonGameRec(arr, cr, cc + 1, er, ec);
		int d = DungeonGameRec(arr, cr + 1, cc, er, ec);

		int path = Math.min(r, d);

		int amountAlreadyHave = path - arr[cr][cc];

		int ans;

		if (amountAlreadyHave >= 1) {
			ans = amountAlreadyHave;
		} else {
			ans = 1;
		}

		return ans;

	}

	public static int DungeonGameTD(int[][] arr, int cr, int cc, int er, int ec, int[][] strg) {

		if (cr == er && cc == ec) {
			return arr[cr][cc] <= 0 ? -arr[cr][cc] + 1 : 1;
		}

		if (cr > er || cc > ec) {
			return Integer.MAX_VALUE;
		}

		if (strg[cr][cc] != 0) {
			return strg[cr][cc];
		}

		int r = DungeonGameTD(arr, cr, cc + 1, er, ec, strg);
		int d = DungeonGameTD(arr, cr + 1, cc, er, ec, strg);

		int path = Math.min(r, d);

		int amountAlreadyHave = path - arr[cr][cc];

		int ans;

		if (amountAlreadyHave >= 1) {
			ans = amountAlreadyHave;
		} else {
			ans = 1;
		}

		strg[cr][cc] = ans;

		return ans;

	}

	public static int DungeonGameBU(int[][] arr) {

		int[][] strg = new int[arr.length + 1][arr[0].length + 1];

		for (int row = strg.length - 1; row >= 0; row--) {

			for (int col = strg[0].length - 1; col >= 0; col--) {

				if (row == strg.length - 2 && col == strg[0].length - 2) {
					strg[row][col] = arr[row][col] <= 0 ? -arr[row][col] + 1 : 1;
				} else if (row == strg.length - 1) {
					strg[row][col] = Integer.MAX_VALUE;
				} else if (col == strg[0].length - 1) {
					strg[row][col] = Integer.MAX_VALUE;
				} else {

					int r = strg[row][col + 1];
					int d = strg[row + 1][col];

					int path = Math.min(r, d);

					int amountAlreadyHave = path - arr[row][col];

					int ans;

					if (amountAlreadyHave >= 1) {
						ans = amountAlreadyHave;
					} else {
						ans = 1;
					}

					strg[row][col] = ans;

				}

			}

		}

		return strg[0][0];

	}

}
