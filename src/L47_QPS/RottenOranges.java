package L47_QPS;

import java.util.LinkedList;
import java.util.Queue;

public class RottenOranges {

	public static void main(String[] args) {

		int[][] arr = { { 2, 1, 1 }, { 1, 1, 0 }, { 0, 1, 1 } };

		System.out.println(orangesRotting(arr));
	}

	public static class Pair {

		int row;
		int col;
		int time;

		public Pair(int row, int col, int time) {
			this.row = row;
			this.col = col;
			this.time = time;
		}
	}

	public static int orangesRotting(int[][] arr) {

		Queue<Pair> q = new LinkedList<>();

		for (int i = 0; i < arr.length; i++) {
			for (int j = 0; j < arr[0].length; j++) {

				if (arr[i][j] == 2) {
					Pair np = new Pair(i, j, 0);
					q.add(np);
				}
			}
		}

		Pair rp = null;

		while (!q.isEmpty()) {

			rp = q.remove();
			int r = rp.row;
			int c = rp.col;
			int t = rp.time;

			// top
			if (r - 1 >= 0) {
				if (arr[r - 1][c] == 1) {
					Pair np = new Pair(r - 1, c, t + 1);
					q.add(np);
					arr[r - 1][c] = 2;
				}
			}

			// bottom
			if (r + 1 < arr.length) {
				if (arr[r + 1][c] == 1) {
					Pair np = new Pair(r + 1, c, t + 1);
					q.add(np);
					arr[r + 1][c] = 2;
				}
			}

			// left
			if (c - 1 >= 0) {
				if (arr[r][c - 1] == 1) {
					Pair np = new Pair(r, c - 1, t + 1);
					q.add(np);
					arr[r][c - 1] = 2;
				}
			}

			// right
			if (c + 1 < arr[0].length) {
				if (arr[r][c + 1] == 1) {
					Pair np = new Pair(r, c + 1, t + 1);
					q.add(np);
					arr[r][c + 1] = 2;
				}
			}

		}

		for (int i = 0; i < arr.length; i++) {
			for (int j = 0; j < arr[0].length; j++) {

				if (arr[i][j] == 1) {
					return -1;
				}
			}
		}

		if (rp == null)
			return -1;

		return rp.time;

	}

}
