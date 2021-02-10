package L4_Patterns;

public class Pattern21 {

	public static void main(String[] args) {

		int n = 7;

		int nst = 1;
		int nsp = 2 * n - 3;

		int row = 1;
		while (row <= n) {

			// stars
			for (int cst = 1; cst <= nst; cst = cst + 1)
				System.out.print("* ");

			// spaces
			for (int csp = 1; csp <= nsp; csp = csp + 1)
				System.out.print("  ");

			// stars
			int cst = 1 ;
			
			if(row == n )
				cst = 2;
			
			for (; cst <= nst; cst = cst + 1)
				System.out.print("* ");

			// update
			System.out.println();

			nst = nst + 1;
			nsp = nsp - 2;

			row = row + 1;

		}
	}
}
