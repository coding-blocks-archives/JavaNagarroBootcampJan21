package L11_Array2D;

import java.util.Scanner;

public class Array2DOps {

	static Scanner scn = new Scanner(System.in);

	public static void main(String[] args) {

		// int[][] a = takeInput();
		int[][] a = { { 10, 20, 30, 40 }, { 50, 60, 70, 80 }, { 90, 100, 110, 120 }, { 130, 140, 150, 160 },
				{ 170, 180, 190, 200 } };
		display(a);

		System.out.println("-- WAVE DISPLAY --");
		waveDisplay(a);

		System.out.println("-- SPIRAL DISPLAY --");
		spiralDisplay(a);

		System.out.println("-- MM --");
		int[][] one = { { 1, 2, 3, 4 }, { 5, 6, 7, 8 }, { 9, 10, 11, 12 } };
		int[][] two = { { 1, 2 }, { 3, 4 }, { 5, 6 }, { 7, 8 } };
		
		display(matrixMultiplication(one, two)) ;
	}

	public static int[][] takeInput() {

		// ask for total no. of rows ?
		System.out.println("Rows ?");
		int rows = scn.nextInt();

		// create a jagged array
		int[][] arr = new int[rows][];

		// iterating over rows : go to every row
		for (int r = 0; r < arr.length; r++) {

			// ask for cols in r row ?
			System.out.println("Cols for " + r + " row ?");
			int cols = scn.nextInt();

			// null -> address
			arr[r] = new int[cols];

			// loop on col -> to update the values
			for (int c = 0; c < arr[r].length; c++) {
				System.out.println("arr[" + r + "-" + c + "] ?");
				arr[r][c] = scn.nextInt();
			}

		}

		return arr;

	}

	public static void display(int[][] arr) {

//		for (int r = 0; r < arr.length; r++) {
//
//			for (int c = 0; c < arr[r].length; c++) {
//				System.out.print(arr[r][c] + " ");
//			}
//			System.out.println();
//
//		}

		for (int[] val : arr) { // 3k 4k 5k

			for (int temp : val) { // 3k : 10 20 30 40
				System.out.print(temp + "\t");
			}
			System.out.println();
		}

	}

	public static void waveDisplay(int[][] arr) {

		for (int c = 0; c < arr[0].length; c++) {

			if (c % 2 == 0) {
				for (int r = 0; r < arr.length; r++) {
					System.out.print(arr[r][c] + " ");
				}
			} else {
				for (int r = arr.length - 1; r >= 0; r--) {
					System.out.print(arr[r][c] + " ");
				}
			}

		}

		System.out.println();

	}

	public static void spiralDisplay(int[][] arr) {

		int minRow = 0;
		int maxRow = arr.length - 1;
		int minCol = 0;
		int maxCol = arr[0].length - 1;

		int nel = arr.length * arr[0].length;
		int count = 0;

		while (count < nel) { // 0 < 30 , 18 < 30, 28 < 30

			// first col
			for (int r = minRow; r <= maxRow && count < nel; r++) {
				System.out.print(arr[r][minCol] + " ");
				count++;
			}
			minCol++;

			// last row
			for (int c = minCol; c <= maxCol && count < nel; c++) {
				System.out.print(arr[maxRow][c] + " ");
				count++;
			}
			maxRow--;

			// last col
			for (int r = maxRow; r >= minRow && count < nel; r--) {
				System.out.print(arr[r][maxCol] + " ");
				count++;
			}
			maxCol--;

			// first row
			for (int c = maxCol; c >= minCol && count < nel; c--) {
				System.out.print(arr[minRow][c] + " ");
				count++;
			}
			minRow++;
		}

		System.out.println();

	}

	public static int[][] matrixMultiplication(int[][] one, int[][] two) {

		int r1 = one.length;
		int c1 = one[0].length;

		int r2 = two.length;
		int c2 = two[0].length;

		int[][] res = new int[r1][c2];

		for (int i = 0; i < res.length; i++) {

			for (int j = 0; j < res[0].length; j++) {

				// i , j cell fill -> one ith row & two jth col multiply
				int sum = 0;
				for (int k = 0; k < c1; k++) {
					sum += one[i][k] * two[k][j];
				}

				res[i][j] = sum;
			}
		}

		return res;

	}
}
