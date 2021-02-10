package L4_Patterns;

public class Pattern15 {

	public static void main(String[] args) {

		int n = 5;

		int nsp = 0;
		int nst = n;

		int row = 1;
		while (row <= 2 * n - 1) {
			
			// spaces
			for (int csp = 1; csp <= nsp; csp = csp + 1)
				System.out.print("  ");

			// stars
			for (int cst = 1; cst <= nst; cst = cst + 1)
				System.out.print("* ");

			// update
			System.out.println();

			if (row <= n - 1) {
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
