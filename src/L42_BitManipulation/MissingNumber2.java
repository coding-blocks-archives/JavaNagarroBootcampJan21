package L42_BitManipulation;

public class MissingNumber2 {

	public static void main(String[] args) {

		int n = 6;
		int[] arr = { 1, 4, 3, 6 };

		int xor = 0;

		for (int val : arr)
			xor ^= val;

		for (int i = 1; i <= n; i++)
			xor ^= i;

		int rbsbMask = xor & (-xor);

		int n1 = 0;
		int n2 = 0;

		for (int val : arr) {

			// unset
			if ((val & rbsbMask) == 0) {
				n1 ^= val;
			}
			// set
			else {
				n2 ^= val;
			}

		}

		for (int val = 1 ; val <= n ; val++) {

			// unset
			if ((val & rbsbMask) == 0) {
				n1 ^= val;
			}
			// set
			else {
				n2 ^= val;
			}

		}

		System.out.println(n1 + " " + n2);

	}

}
