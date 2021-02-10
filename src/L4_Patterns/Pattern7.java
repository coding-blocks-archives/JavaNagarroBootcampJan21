package L4_Patterns;

public class Pattern7 {

	public static void main(String[] args) {

		int n = 9;

		// rows
		int row = 1;

		while (row <= n) {

			// work
			for (int col = 1; col <= n; col = col + 1) {
				
				if(row == 1 || row == n || col == 1 || col == n)
					System.out.print("* ");
				else
					System.out.print("  ");
				
			}
						
			// changes
			System.out.println();
			row = row + 1;

		}

	}
}
