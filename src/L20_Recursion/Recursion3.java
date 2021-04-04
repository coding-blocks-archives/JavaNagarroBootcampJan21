package L20_Recursion;

import java.util.ArrayList;

public class Recursion3 {

	public static void main(String[] args) {

//		subsequencesAscii("ab", "");
//		KPC2("145");
//		coinToss(4, "");
//		validParenthesis(3, 0, 0, "");
//		climbingStairs(0, 3, "");
//		mazePath(0, 0, 2, 2, "");

//		permutation("abc", "");

//		coinTossNoConsecutiveHead(3, "", true);

//		lexicoCounting(0, 1000);

		jumpingNumbers(0, 100);

//		palindromePartitions("abbcbc", "");
	}

	public static void subsequences(String ques, String ans) {

		if (ques.length() == 0) {
			System.out.println(ans);
			return;
		}

		char ch = ques.charAt(0); // a
		String roq = ques.substring(1); // bc

		subsequences(roq, ans); // ch no
		subsequences(roq, ans + ch); // ch yes
	}

	public static void subsequencesAscii(String ques, String ans) {

		if (ques.length() == 0) {
			System.out.println(ans);
			return;
		}

		char ch = ques.charAt(0);
		String roq = ques.substring(1);

		subsequencesAscii(roq, ans); // ch no
		subsequencesAscii(roq, ans + ch); // ch yes
		subsequencesAscii(roq, ans + (int) ch); // ch ascii
	}

	public static String getCode(char ch) {
		if (ch == '1')
			return "abc";
		else if (ch == '2')
			return "def";
		else if (ch == '3')
			return "ghi";
		else if (ch == '4')
			return "jk";
		else if (ch == '5')
			return "lmno";
		else if (ch == '6')
			return "pqr";
		else if (ch == '7')
			return "stu";
		else if (ch == '8')
			return "vwx";
		else if (ch == '9')
			return "yz";
		else if (ch == '0')
			return "@#";
		else
			return "";
	}

	public static void KPC(String ques, String ans) {

		if (ques.length() == 0) {
			System.out.println(ans);
			return;
		}

		char ch = ques.charAt(0);
		String roq = ques.substring(1);

		String code = getCode(ch);

		for (int i = 0; i < code.length(); i++) {
			KPC(roq, ans + code.charAt(i));
		}

	}

	public static void KPC2(String str) {

		ArrayList<String> list = new ArrayList<String>();

		list.add("");

		for (int i = 0; i < str.length(); i++) { // 145

			ArrayList<String> nl = new ArrayList<String>();

			String code = getCode(str.charAt(i));

			for (String val : list) { // list // a b c

				for (int j = 0; j < code.length(); j++) { // options
					nl.add(val + code.charAt(j)); // aj ak bj bk cj ck
				}

			}

			list = nl;
		}

		System.out.println(list);

	}

	public static void coinToss(int n, String ans) {

		if (n == 0) {
			System.out.println(ans);
			return;
		}

		coinToss(n - 1, ans + "H");
		coinToss(n - 1, ans + "T");
	}

	public static void validParenthesis(int n, int open, int close, String ans) {

		// +ve bc
		if (open == n && close == n) {
			System.out.println(ans);
			return;
		}

		// -ve bc
		if (open > n || close > open)
			return;

		validParenthesis(n, open + 1, close, ans + "(");
		validParenthesis(n, open, close + 1, ans + ")");

	}

	public static void climbingStairs(int curr, int n, String ans) {

		if (curr == n) {
			System.out.println(ans);
			return;
		}

		if (curr > n) {
			return;
		}

		for (int step = 1; step <= 3; step++)
			climbingStairs(curr + step, n, ans + step);

	}

	public static void mazePath(int cr, int cc, int er, int ec, String ans) {

		if (cr == er && cc == ec) {
			System.out.println(ans);
			return;
		}

		if (cr > er || cc > ec) {
			return;
		}

		mazePath(cr, cc + 1, er, ec, ans + "H");
		mazePath(cr + 1, cc, er, ec, ans + "V");
		mazePath(cr + 1, cc + 1, er, ec, ans + "D");
	}

	public static void permutation(String ques, String ans) {

		if (ques.length() == 0) {
			System.out.println(ans);
			return;
		}

		for (int i = 0; i < ques.length(); i++) {

			char ch = ques.charAt(i);
			String roq = ques.substring(0, i) + ques.substring(i + 1);

			permutation(roq, ans + ch);
		}

	}

	public static void coinTossNoConsecutiveHead(int n, String ans, boolean flag) {

		if (n == 0) {
			System.out.println(ans);
			return;
		}

		if (flag) // last element was Head
		{
			coinTossNoConsecutiveHead(n - 1, ans + "T", false);
		} else // last element was Tail
		{
			coinTossNoConsecutiveHead(n - 1, ans + "H", true);
			coinTossNoConsecutiveHead(n - 1, ans + "T", false);
		}
	}

	public static void lexicoCounting(int curr, int n) {

		if (curr > n)
			return;

		System.out.println(curr);

		int i = 0;

		if (curr == 0)
			i = 1;

		while (i <= 9) {
			lexicoCounting(curr * 10 + i, n);
			i++;
		}

	}

	public static void jumpingNumbers(int curr, int n) {

		if (curr > n)
			return;

		System.out.println(curr);

		if (curr == 0) {

			for (int i = 1; i <= 9; i++)
				jumpingNumbers(i, n);

		} else {

			int rem = curr % 10;

			if (rem != 0)
				jumpingNumbers(curr * 10 + (rem - 1), n);

			if (rem != 9)
				jumpingNumbers(curr * 10 + (rem + 1), n);

		}

	}

	public static void palindromePartitions(String ques, String ans) {

		if (ques.length() == 0) {
			System.out.println(ans);
			return;
		}

		for (int i = 1; i <= ques.length(); i++) {

			String part = ques.substring(0, i);
			String roq = ques.substring(i);

			if (isPalindrome(part))
				palindromePartitions(roq, ans + part + " ");

		}

	}

	public static boolean isPalindrome(String str) {

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

}
