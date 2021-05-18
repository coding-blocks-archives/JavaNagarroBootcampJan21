package L47_QPS;

public class Sort012 {

	public static void main(String[] args) {

		int[] arr = { 0, 1, 1, 0, 1, 2, 1, 2, 0, 0, 0, 1 };

		sort012(arr);

		for (int val : arr) {
			System.out.print(val + " ");
		}
	}

	public static void sort012(int[] arr) {

		int lo = 0;
		int mid = 0;
		int hi = arr.length - 1;

		while (mid <= hi) {

			if (arr[mid] == 0) {

				int temp = arr[lo];
				arr[lo] = arr[mid];
				arr[mid] = temp;

				lo++;
				mid++;

			} else if (arr[mid] == 1) {

				mid++;

			} else if (arr[mid] == 2) {

				int temp = arr[hi];
				arr[hi] = arr[mid];
				arr[mid] = temp;

				hi--;

			}

		}

	}

}
