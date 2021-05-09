package L42_BitManipulation;

public class DecimalToBinary {

	public static void main(String[] args) {

		int n = 95;
		int mult = 1;

		int sum = 0;

		while (n != 0) {

			int rem = n % 2;
			int temp = rem * mult;
			sum = sum + temp;

			mult = mult * 10;
			n = n / 2;
		}
		
		System.out.println(sum);

	}

}
