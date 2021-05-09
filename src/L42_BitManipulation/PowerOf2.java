package L42_BitManipulation;

public class PowerOf2 {

	public static void main(String[] args) {

		int n = 1;

		if (n != 0 && (n & (n - 1)) == 0) {
			System.out.println("power of 2");
		} else {
			System.out.println("not a power of 2");
		}

	}

}
