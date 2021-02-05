package L3_Patterns;

public class Pattern2 {

	public static void main(String[] args) {

		int n = 5;

		int nst = 1;

		int row = 1;
		while (row <= n) {

			// work
			for (int col = 1; col <= nst; col = col + 1) {
				System.out.print("*");
			}


			// changes
			System.out.println();
			row = row + 1;
			nst = nst + 1;

		}
	}
}
