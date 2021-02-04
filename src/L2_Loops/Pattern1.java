package L2_Loops;

public class Pattern1 {

	public static void main(String[] args) {

		int n = 6;

		// rows
		int row = 1;

		while (row <= n) {

			// work
//			int col = 1;
//			while (col <= n) {
//				System.out.print("*");
//				col = col + 1;
//			}

			for (int col = 1; col <= n; col = col + 1)
				System.out.print("*");

			// changes
			System.out.println();
			row = row + 1;

		}

	}
}
