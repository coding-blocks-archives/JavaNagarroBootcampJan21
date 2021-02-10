package L4_Patterns;

public class Pattern17 {

	public static void main(String[] args) {

		int n = 21;

		int nsp = 1;
		int nst = n / 2;

		int row = 1;
		while (row <= n) {

			// stars
			for (int cst = 1; cst <= nst; cst = cst + 1)
				System.out.print("* ");

			// spaces
			for (int csp = 1; csp <= nsp; csp = csp + 1)
				System.out.print("  ");

			// stars
			for (int cst = 1; cst <= nst; cst = cst + 1)
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
