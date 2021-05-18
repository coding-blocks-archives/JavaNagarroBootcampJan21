package L47_QPS;

public class Partitioning3Way {

	public static void main(String[] args) {

		int[] arr = { 1, 14, 5, 20, 4, 2, 54, 20, 87, 98, 3, 1, 32 };

		partitioning(arr, 14, 20);

		for (int val : arr) {
			System.out.print(val + " ");
		}
	}

	public static void partitioning(int[] arr, int ll, int hl) {

		int lo = 0;
		int mid = 0;
		int hi = arr.length - 1;

		while (mid <= hi) {

			if (arr[mid] < ll) {

				int temp = arr[lo];
				arr[lo] = arr[mid];
				arr[mid] = temp;

				lo++;
				mid++;

			} else if (arr[mid] >= ll && arr[mid] <= hl) {

				mid++;

			} else if (arr[mid] > hl) {

				int temp = arr[hi];
				arr[hi] = arr[mid];
				arr[mid] = temp;

				hi--;

			}

		}

	}

}
