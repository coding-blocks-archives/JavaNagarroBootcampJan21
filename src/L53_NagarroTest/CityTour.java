package L53_NagarroTest;

public class CityTour {

	public static void main(String[] args) {

		int[][] arr = { { 5, 0 }, { -1, 9 }, { 3, 2 }, { 10, 10 } };

		System.out.println(cityTour(arr));
	}

	public static int cityTour(int[][] arr) {

		String[][] pathTrack = new String[arr.length][arr[0].length];

		// step 1: 0,0 -> 2,2
		int p1 = cityTour1(arr, 0, 0, arr.length - 1, arr[0].length - 1, pathTrack);

		if (p1 == Integer.MIN_VALUE)
			return 0;

		// printing
//		for (int i = 0; i < pathTrack.length; i++) {
//			for (int j = 0; j < pathTrack[0].length; j++) {
//				System.out.print(pathTrack[i][j] + "\t");
//			}
//			System.out.println();
//		}

		// step 2 : array 0's
		int r = 0;
		int c = 0;

		while (!pathTrack[r][c].equals("E")) {

			arr[r][c] = 0;

			if (pathTrack[r][c].equals("H")) {
				c++;
			} else {
				r++;
			}
		}

		arr[r][c] = 0;

//		for (int i = 0; i < pathTrack.length; i++) {
//			for (int j = 0; j < pathTrack[0].length; j++) {
//				System.out.print(arr[i][j] + "\t");
//			}
//			System.out.println();
//		}

		// step 3 : 2,2 -> 0,0
		int p2 = cityTour2(arr, arr.length - 1, arr[0].length - 1);

		return p1 + p2;
	}

	public static int cityTour1(int[][] arr, int row, int col, int er, int ec, String[][] pathTrack) {

		if (row == er && col == ec) {
			pathTrack[row][col] = "E";
			return arr[row][col];
		}

		if (row > er || col > ec || arr[row][col] == -1) {
			return Integer.MIN_VALUE;
		}

		int hp = cityTour1(arr, row, col + 1, er, ec, pathTrack);
		int vp = cityTour1(arr, row + 1, col, er, ec, pathTrack);

		int max = Math.max(hp, vp);

		if (max == Integer.MIN_VALUE)
			return Integer.MIN_VALUE;

		pathTrack[row][col] = hp == max ? "H" : "V";

		return max + arr[row][col];

	}

	public static int cityTour2(int[][] arr, int row, int col) {

		if (row == 0 && col == 0) {
			return arr[row][col];
		}

		if (row < 0 || col < 0 || arr[row][col] == -1) {
			return Integer.MIN_VALUE;
		}

		int hp = cityTour2(arr, row, col - 1);
		int vp = cityTour2(arr, row - 1, col);

		int max = Math.max(hp, vp);

		if (max == Integer.MIN_VALUE)
			return Integer.MIN_VALUE;

		return max + arr[row][col];

	}

}
