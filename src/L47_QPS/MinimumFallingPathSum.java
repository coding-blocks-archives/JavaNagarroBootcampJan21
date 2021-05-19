package L47_QPS;

public class MinimumFallingPathSum {

	public static void main(String[] args) {

		int[][] arr = { { 2, 1, 3 }, { 6, 5, 4 }, { 7, 8, 9 } };

		System.out.println(minFallingPathSum(arr));
		System.out.println(minFallingPathSumBU(arr));

	}

	public static int minFallingPathSum(int[][] arr) {

		int min = Integer.MAX_VALUE;

		for (int i = 0; i < arr[0].length; i++) {
			min = Math.min(min, minFallingPathSum(arr, 0, i, new int[arr.length][arr[0].length]));
		}

		return min;
	}

	public static int minFallingPathSum(int[][] arr, int row, int col, int[][] strg) {

		if (col < 0 || col >= arr[0].length) {
			return Integer.MAX_VALUE;
		}

		if (row == arr.length) {
			return 0;
		}

		if (strg[row][col] != 0)
			return strg[row][col];

//		if(row == arr.length-1) {
//			return arr[row][col] ;
//		}

		int dleft = minFallingPathSum(arr, row + 1, col - 1, strg);
		int below = minFallingPathSum(arr, row + 1, col, strg);
		int dright = minFallingPathSum(arr, row + 1, col + 1, strg);

		int ans = Math.min(dleft, Math.min(below, dright)) + arr[row][col];

		strg[row][col] = ans;

		return ans;
	}

	public static int minFallingPathSumBU(int[][] arr) {

		int n = arr.length;
		int[][] strg = new int[n][n];

		for (int r = n - 1; r >= 0; r--) {

			for (int c = 0; c < n; c++) {

				if (r == n - 1) {
					strg[r][c] = arr[r][c];
				} else {

					int dleft = Integer.MAX_VALUE;
					int dright = Integer.MAX_VALUE;

					if (c - 1 >= 0)
						dleft = strg[r + 1][c - 1];

					int below = strg[r + 1][c];

					if (c + 1 < n)
						dright = strg[r + 1][c + 1];

					int ans = Math.min(dleft, Math.min(below, dright)) + arr[r][c];

					strg[r][c] = ans;

				}
			}

		}
		
		int min = Integer.MAX_VALUE ;
		
		for (int i = 0; i < n; i++) {
			min = Math.min(min, strg[0][i]) ;
		}

		return min ;
	}

}
