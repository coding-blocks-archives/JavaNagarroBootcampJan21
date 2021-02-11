package L5_PatternsDataType;

public class Pattern27 {

	public static void main(String[] args) {

		int n = 5;

		int nsp = n - 1;
		int nst = 1;

		int val;

		int row = 1;
		while (row <= n) {

			val = 1;

			// work
			// spaces
			for (int csp = 1; csp <= nsp; csp = csp + 1)
				System.out.print("  ");

			// stars
			for (int cst = 1; cst <= nst; cst = cst + 1) {
				
				System.out.print(val + " ");
				
				if(cst <= nst/2)
					val ++ ;
				else
					val-- ;			
				
			}

			// changes
			System.out.println();
			row = row + 1;
			nsp = nsp - 1;
			nst = nst + 2;

		}

	}
}
