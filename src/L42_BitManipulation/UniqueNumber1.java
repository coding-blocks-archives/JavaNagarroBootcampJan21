package L42_BitManipulation;

public class UniqueNumber1 {

	public static void main(String[] args) {

		int[] arr = { 20, 10, 67, 89, 10, 20, 89, 56, 67 };

		int ans = 0;

		for (int val : arr) {
			ans = ans ^ val;
		}

		System.out.println(ans);
	}

}
