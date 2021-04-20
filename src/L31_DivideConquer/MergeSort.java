package L31_DivideConquer;

public class MergeSort {

	public static void main(String[] args) {

		int[] arr = { 80, 10, 50, 30, 60, 20, 70, 25 };

//		int[] res = mergeSort(arr, 0, arr.length - 1);
//
//		for (int val : res)
//			System.out.print(val + " ");

		quickSort(arr, 0, arr.length - 1);

		for (int val : arr)
			System.out.print(val + " ");

	}

	public static int[] mergeTwoSortedArrays(int[] one, int[] two) {

		int[] merged = new int[one.length + two.length];

		int i = 0;
		int j = 0;

		int k = 0;

		while (i < one.length && j < two.length) {

			if (one[i] < two[j]) {
				merged[k] = one[i];
				i++;
				k++;
			} else {
				merged[k] = two[j];
				j++;
				k++;
			}

		}

		// two array finish, one array elements consume
		if (j == two.length) {

			while (i < one.length) {
				merged[k] = one[i];
				i++;
				k++;
			}

		}

		// one array finish, two array elements consume
		if (i == one.length) {

			while (j < two.length) {
				merged[k] = two[j];
				j++;
				k++;
			}

		}

		return merged;

	}

	public static int[] mergeSort(int[] arr, int lo, int hi) {

		if (lo == hi) {
			int[] br = new int[1];
			br[0] = arr[lo];
			return br;
		}

		int mid = (lo + hi) / 2;

		int[] fh = mergeSort(arr, lo, mid);
		int[] sh = mergeSort(arr, mid + 1, hi);

		int[] res = mergeTwoSortedArrays(fh, sh);

		return res;
	}

	public static void quickSort(int[] arr, int lo, int hi) {

		if (lo >= hi)
			return;

		int mid = (lo + hi) / 2;

		// partitioning
		// start
		int pivot = arr[mid] ;

		int left = lo;
		int right = hi;

		while (left <= right) {

			// left problem point
			while (arr[left] < pivot)
				left++;

			// right problem point
			while (arr[right] > pivot)
				right--;

			// problem resolve : swap
			if (left <= right) {
				int temp = arr[left];
				arr[left] = arr[right];
				arr[right] = temp;
				left++;
				right--;
			}

		}

		// stop

		// sp
		quickSort(arr, lo, right);
		quickSort(arr, left, hi);

	}

}
