package L53_NagarroTest;

public class TreasureIsland {

	public static void main(String[] args) {

		int[][] arr = { { 0 }, { 1 } };

		System.out.println(treasureIsland(arr, 0, new int[arr[0].length], ""));
	}

	public static int treasureIsland(int[][] arr, int bidx, int[] keys, String ans) {

		if (bidx == arr.length) {

			if (keysCheck(keys)) {
				System.out.println(ans);
				return 1;
			}

			return 0;
		}

		int count = 0;

		// exclude
		count += treasureIsland(arr, bidx + 1, keys, ans);

		// keys change
		for (int i = 0; i < keys.length; i++)
			keys[i] += arr[bidx][i];

		// include
		count += treasureIsland(arr, bidx + 1, keys, ans + "B" + bidx + " ");

		// undo
		for (int i = 0; i < keys.length; i++)
			keys[i] -= arr[bidx][i];

		return count;

	}

	public static boolean keysCheck(int[] keys) {

		for (int i = 0; i < keys.length; i++) {

			if (keys[i] == 0)
				return false;

		}

		return true;
	}

}
