package L42_BitManipulation;

public class BitsPrint {

	public static void main(String[] args) {

		// way 1
		int x = 100;

		while (x != 0) {

			int rem = x % 2;
			System.out.println(rem);

			x = x / 2;
		}

		System.out.println("----------");
		
		// way 2
		int y = 100;

		while (y != 0) {

			int rem = y & 1;
			System.out.println(rem);

			y = y >> 1;

		}
	}

}
