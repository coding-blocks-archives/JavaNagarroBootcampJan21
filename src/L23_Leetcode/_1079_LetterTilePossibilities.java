package L23_Leetcode;

public class _1079_LetterTilePossibilities {

	public static void main(String[] args) {

		System.out.println(numTilePossibilities("AAB"));
	}

	static int count;

	public static int numTilePossibilities(String tiles) {

		int[] freq = new int[26];

		for (int i = 0; i < tiles.length(); i++) {

			char ch = tiles.charAt(i);
			freq[ch - 'A']++;
		}

		count = 0;

		numTile(freq, "");

		return count - 1;

	}

	public static void numTile(int[] freq, String ans) {

		if (ans.length() != 0)
			System.out.println(ans);
		
		count++;

		for (int i = 0; i < freq.length; i++) {

			if (freq[i] > 0) {

				freq[i]--;
				numTile(freq, ans + (char) (i + 'A'));
				freq[i]++;
			}

		}

	}

}
