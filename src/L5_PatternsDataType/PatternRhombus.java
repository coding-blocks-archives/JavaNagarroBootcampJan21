package L5_PatternsDataType;

public class PatternRhombus {

	public static void main(String[] args) {

		int n = 7;

		int nsp = n / 2;
		int nst = 1;
		int val = 1;

		int row = 1;
		while (row <= n) {

			int temp = val;

			// spaces
			for (int csp = 1; csp <= nsp; csp = csp + 1)
				System.out.print("  ");

			// stars
			for (int cst = 1; cst <= nst; cst = cst + 1) {
				System.out.print(temp + " ");

				if (cst <= nst / 2)
					temp = temp + 1;
				else
					temp = temp - 1;
			}

			// update
			System.out.println();

			if (row <= n / 2) {
				nsp = nsp - 1;
				nst = nst + 2;
				val = val + 1;
			} else {
				nsp = nsp + 1;
				nst = nst - 2;
				val = val - 1;
			}

			row = row + 1;

		}
	}
}
