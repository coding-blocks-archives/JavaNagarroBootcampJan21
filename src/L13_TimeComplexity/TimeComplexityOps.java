package L13_TimeComplexity;

import java.util.Arrays;

public class TimeComplexityOps {

	public static void main(String[] args) {

		//System.out.println(polynomial(3, 7));
		SOE(50) ;
	}

	public static int polynomial(int x, int n) {

		int sum = 0;
		int mult = x;

		for (int coeff = n; coeff >= 1; coeff--) {

			sum += coeff * mult;
			mult = mult * x;
		}

		return sum;
	}

	public static void SOE(int n) {

		boolean[] primes = new boolean[n + 1];

		Arrays.fill(primes, true);

		primes[0] = false;
		primes[1] = false;

		for (int table = 2; table * table <= n; table++) {

			if(primes[table] == false)
				continue ;
			
			for (int mult = 2; table * mult <= n; mult++) {
				primes[table * mult] = false;
			}

		}
		
		for (int i = 0; i < primes.length; i++) {
			if(primes[i])
				System.out.println(i);
		}

	}

}
