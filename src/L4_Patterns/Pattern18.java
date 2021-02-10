package L4_Patterns;

public class Pattern18 {

	public static void main(String[] args) {

		int n = 13;

		int nsp = n/2 ;
		int nst = 1 ;

		int row = 1;
		while (row <= n) {
			
			// spaces
			for (int csp = 1; csp <= nsp; csp = csp + 1)
				System.out.print("  ");

			// stars
			for (int cst = 1; cst <= nst; cst = cst + 1)
				System.out.print("* ");

			// update
			System.out.println();

			if (row <= n/2) {
				nsp = nsp - 1;
				nst = nst + 2;	
			} else {
				nsp = nsp + 1;
				nst = nst - 2;
			}

			row = row + 1;

		}
	}
}
