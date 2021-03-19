package L19_Recursion;

public class Recursion2 {

	public static void main(String[] args) {

		int[] arr = { 10, 5, 30, 60, 30 };

//		reverseDisplay(arr, 0) ;
//		System.out.println();

//		System.out.println(max(arr, 0));

		System.out.println(lastOccIndex(arr, 30, 0));
	}

	public static void display(int[] arr, int vidx) {

		if (vidx == arr.length) {
			return;
		}

		System.out.print(arr[vidx] + " ");

		display(arr, vidx + 1);

	}

	public static void reverseDisplay(int[] arr, int vidx) {

		if (vidx == arr.length) {
			return;
		}

		reverseDisplay(arr, vidx + 1);

		System.out.print(arr[vidx] + " ");
	}

	public static int max(int[] arr, int vidx) {

		if (vidx == arr.length) {
			return Integer.MIN_VALUE;
		}

		int sp = max(arr, vidx + 1);

		int bp = Math.max(arr[vidx], sp);

		return bp;

	}

	public static int firstOccIndex(int[] arr, int item, int vidx) {

		if (vidx == arr.length) {
			return -1;
		}

		if (arr[vidx] == item) {
			return vidx;
		}

		int sp = firstOccIndex(arr, item, vidx + 1);
		return sp;

		// return firstOccIndex(arr, item, vidx+1) ;
	}

	public static int lastOccIndex(int[] arr, int item, int vidx) {

		if (vidx == arr.length) {
			return -1;
		}

		int sp = lastOccIndex(arr, item, vidx + 1);

		if (arr[vidx] == item && sp == -1) {
			return vidx;
		}

		return sp;

	}

	public static int[] allIndexes(int[] arr , int item, int vidx, int count) {
		
		
		
	}
}






