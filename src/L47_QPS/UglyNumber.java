package L47_QPS;

public class UglyNumber {

	public static void main(String[] args) {

		System.out.println(nthUglyNumber(9));
	}

	public static int nthUglyNumber(int n) {

		int[] strg = new int[n + 1];
		strg[0] = 1;

		int i2 = 0;
		int i3 = 0;
		int i5 = 0;

		for (int i = 1; i <= n; i++) {

			int candidate2 = 2 * strg[i2];
			int candidate3 = 3 * strg[i3];
			int candidate5 = 5 * strg[i5];

			int minimum = Math.min(candidate2, Math.min(candidate3, candidate5));

			strg[i] = minimum;

			if (minimum == candidate2)
				i2++;

			if (minimum == candidate3)
				i3++;

			if (minimum == candidate5)
				i5++;

		}
		
//		for (int i = 0; i < strg.length; i++) {
//			System.out.println(i + " -> " + strg[i]);
//		}
		
		return strg[n] ;

	}

}
