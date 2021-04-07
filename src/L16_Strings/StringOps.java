package L16_Strings;

import java.util.Scanner;

public class StringOps {

	public static void main(String[] args) {

		Scanner scn = new Scanner(System.in);

		// String str = scn.next();
		// printChars(str);
		// substrings(str);
		// System.out.println(palindrome(str));
		// System.out.println(countPalindromicSubstrings(str));
		// System.out.println(countPalindromicSubstrings2(str));

		reverseWords("The Sky is Blue");
	}

	public static void printChars(String str) {

		for (int i = 0; i < str.length(); i++) {
			System.out.println(str.charAt(i));
		}

	}

	public static void substrings(String str) {

		for (int si = 0; si < str.length(); si++) {

			for (int ei = si + 1; ei <= str.length(); ei++) {

				System.out.println(str.substring(si, ei));
			}
		}
	}

	public static boolean palindrome(String str) {

		int i = 0;
		int j = str.length() - 1;

		while (i < j) {

			if (str.charAt(i) != str.charAt(j))
				return false;

			i++;
			j--;
		}

		return true;
	}

	public static int countPalindromicSubstrings(String str) {

		int count = 0;

		for (int si = 0; si < str.length(); si++) {

			for (int ei = si + 1; ei <= str.length(); ei++) {

				String ss = str.substring(si, ei);

				if (palindrome(ss))
					count++;

			}
		}

		return count;
	}

	public static int countPalindromicSubstrings2(String str) {

		int count = 0;

		// odd length palindromic substrings
		for (int axis = 0; axis < str.length(); axis++) {

			for (int orbit = 0; axis - orbit >= 0 && axis + orbit < str.length(); orbit++) {

				if (str.charAt(axis - orbit) == str.charAt(axis + orbit))
					count++;
				else
					break;
			}

		}

		// even length palindromic substrings
		for (double axis = 0.5; axis < str.length(); axis++) {

			for (double orbit = 0.5; axis - orbit >= 0 && axis + orbit < str.length(); orbit++) {

				if (str.charAt((int) (axis - orbit)) == str.charAt((int) (axis + orbit)))
					count++;
				else
					break;
			}

		}

		return count;

	}

	public static void reverseWords(String str) {

		String[] arr = str.split(" ");

		for (int i = arr.length - 1; i >= 0; i--)
			System.out.print(arr[i] + " ");
	}

}
