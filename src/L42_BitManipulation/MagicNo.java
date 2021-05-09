package L42_BitManipulation;

public class MagicNo {

	public static void main(String[] args) {

		int n = 8;

		int mult = 1; // 5 power 0
		int ans = 0;

		while (n != 0) {

			if ((n & 1) == 1)
				ans += mult;

			mult = mult * 5;
			n = n >> 1;

		}
		
		System.out.println(ans);

	}

}
