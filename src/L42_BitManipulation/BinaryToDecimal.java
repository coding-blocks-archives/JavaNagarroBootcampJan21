package L42_BitManipulation;

public class BinaryToDecimal {

	public static void main(String[] args) {

		int n = 11001;
		int mult = 1;

		int sum = 0;

		while (n != 0) {

			int rem = n % 10;
			int temp = rem * mult;
			sum = sum + temp;

			mult = mult * 2;
			n = n / 10;
		}
		
		System.out.println(sum);

	}

}
