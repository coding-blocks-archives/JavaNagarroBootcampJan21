package L5_PatternsDataType;

public class Inverse {

	public static void main(String[] args) {

		int n = 54312;

		int pos = 1;
		int ans = 0;

		while (n != 0) {

			int rem = n % 10;

			ans = ans + pos * (int)Math.pow(10, rem - 1);

			n = n / 10;
			pos = pos + 1;
		}
		
		System.out.println(ans);

	}

}
