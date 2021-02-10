package L4_Patterns;

public class Pattern13 {

	public static void main(String[] args) {
		
		int n = 5 ;
		
		int nst = 1 ;
		
		int row = 1 ;
		while(row <= 2*n-1)
		{
			// stars
			for(int cst = 1 ; cst <= nst ; cst = cst + 1)
				System.out.print("*");
			
			// update
			System.out.println();
			
			if(row <= n-1)
				nst = nst + 1 ;
			else
				nst = nst - 1 ;
		
			row = row + 1 ;
			
		}
	}
}
