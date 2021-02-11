package L5_PatternsDataType;

public class Rotate {

	public static void main(String[] args) {

		int n = 123456;
		int rot = 23;

		int temp = n ; // 123456
		
		// no. of digits
		int nod = 0;

		while (temp != 0) {
			nod = nod + 1;
			temp = temp / 10;
		}

		rot = rot % nod ;
		
		// rotate
		int divisor = (int) Math.pow(10, rot); // 10^4
		int rem = n % divisor; // 3456
		int quot = n / divisor; // 12

		int mult = (int) Math.pow(10, nod - rot);

		int ans = rem * mult + quot;

		System.out.println(ans);

	}

}
