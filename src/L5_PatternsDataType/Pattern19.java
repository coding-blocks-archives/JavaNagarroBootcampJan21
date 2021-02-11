package L5_PatternsDataType;

public class Pattern19 {

	public static void main(String[] args) {

		int n = 21;

		int nsp = -1;
		int nst = n / 2 + 1;

		int row = 1;
		while (row <= n) {

			// stars
			for (int cst = 1; cst <= nst; cst = cst + 1)
				System.out.print("* ");

			// spaces
			for (int csp = 1; csp <= nsp; csp = csp + 1)
				System.out.print("  ");

			// stars
			int cst = 1;

			if (row == 1 || row == n)
				cst = 2;
			
			for (; cst <= nst; cst = cst + 1)
				System.out.print("* ");

			// update
			System.out.println();

			if (row <= n / 2) {
				nsp = nsp + 2;
				nst = nst - 1;
			} else {
				nsp = nsp - 2;
				nst = nst + 1;
			}

			row = row + 1;

		}
	}
}
