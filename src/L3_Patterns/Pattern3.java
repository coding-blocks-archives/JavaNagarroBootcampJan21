package L3_Patterns;

public class Pattern3 {

	public static void main(String[] args) {

		int n = 5;

		int nst = n;

		int row = 1;
		while (row <= n) {

			// work
			// cst is nothing spcl, it is simply a variable which is responsible for running the loop
			for (int cst = 1; cst <= nst; cst = cst + 1) {
				System.out.print("*");
			}

			// changes
			System.out.println();
			row = row + 1;
			nst = nst - 1;

		}
	}
}
