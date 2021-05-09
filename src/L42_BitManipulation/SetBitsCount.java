package L42_BitManipulation;

public class SetBitsCount {

	public static void main(String[] args) {

		int x = 100;
		
		System.out.println(Integer.toBinaryString(x));

		int count = 0;

		while (x != 0) {

			if ((x & 1) == 1)
				count++;

			x >>= 1;

		}
		
		System.out.println(count);
	}
}
