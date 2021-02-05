package L3_Patterns;

public class Pattern10 {

	public static void main(String[] args) {

		int n = 5;

		int nsp = 0 ;
		int nst = 2*n-1 ;

		int row = 1;
		while (row <= n) {

			// work
			// spaces
			for (int csp = 1; csp <= nsp; csp = csp + 1)
				System.out.print("  ");

			// stars
			for (int cst = 1; cst <= nst; cst = cst + 1)
				System.out.print("* ");

			// changes
			System.out.println();
			row = row + 1;
			nsp = nsp + 1;
			nst = nst - 2;

		}

	}
}
