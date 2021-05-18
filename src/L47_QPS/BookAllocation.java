package L47_QPS;

import java.util.Scanner;

public class BookAllocation {

	public static void main(String[] args) {

		Scanner scn = new Scanner(System.in);

		int nob = scn.nextInt();
		int nos = scn.nextInt();

		int[] pages = new int[nob];

		for (int i = 0; i < nob; i++) {
			pages[i] = scn.nextInt();
		}

		// bs logic ...
		int lo = 0;
		int hi = 0;

		for (int val : pages)
			hi += val;

		int finalAns = 0;

		while (lo <= hi) {

			int mid = (lo + hi) / 2;

			if (isItPossible(pages, nos, mid)) {
				finalAns = mid;
				hi = mid - 1;
			} else {
				lo = mid + 1;
			}

		}

		System.out.println(finalAns);

	}

	public static boolean isItPossible(int[] pages, int nos, int mid) {

		int students = 1;
		int pagesRead = 0;

		int bn = 0;

		while (bn < pages.length) {

			if (pagesRead + pages[bn] <= mid) {
				pagesRead += pages[bn];
				bn++;
			} else {
				students++;
				pagesRead = 0;

				if (students > nos)
					return false;

			}

		}

		return true;
	}

}
