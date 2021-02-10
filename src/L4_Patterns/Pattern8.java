package L4_Patterns;

public class Pattern8 {

	public static void main(String[] args) {

		int n = 9;

		// rows
		int row = 1;

		while (row <= n) {

			// work
			for (int col = 1; col <= n; col = col + 1) {
				
				if(row == col || row + col == n+1)
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
