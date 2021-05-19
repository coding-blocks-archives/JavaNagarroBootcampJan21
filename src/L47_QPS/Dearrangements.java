package L47_QPS;

public class Dearrangements {

	public static void main(String[] args) {

		int n = 10;
		//System.out.println(dearrangementsTD(n, new int[n + 1]));
		System.out.println(dearrangementsBU(n));
	}

	public static int dearrangementsRec(int n) {

		if (n == 1)
			return 0;

		if (n == 2)
			return 1;

		int deal = dearrangementsRec(n - 2);
		int nodeal = dearrangementsRec(n - 1);

		int specificPosTotal = deal + nodeal;

		int total = (n - 1) * specificPosTotal;

		return total;

	}

	public static int dearrangementsTD(int n, int[] strg) {

		if (n == 1)
			return 0;

		if (n == 2)
			return 1;

		if (strg[n] != 0) {
			return strg[n];
		}

		int deal = dearrangementsTD(n - 2, strg);
		int nodeal = dearrangementsTD(n - 1, strg);

		int specificPosTotal = deal + nodeal;

		int total = (n - 1) * specificPosTotal;

		strg[n] = total;

		return total;

	}

	public static int dearrangementsBU(int n) {

		int[] strg = new int[n + 1];
		strg[1] = 0;
		strg[2] = 1;

		for (int i = 3; i <= n ; i++) {

			int deal = strg[i-2] ;
			int nodeal = strg[i-1] ;

			int specificPosTotal = deal + nodeal;

			int total = (i - 1) * specificPosTotal;

			strg[i] = total;
		}
		
		return strg[n] ;

	}

}









