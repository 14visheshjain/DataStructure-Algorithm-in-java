package lecture5;

import java.util.Scanner;

public class MatrixMultiplication {
	static Scanner s = new Scanner(System.in);

	public static void main(String[] args) {
		System.out.println("rows and cols 1 matrix");
		int r1 = s.nextInt();
		int c1 = s.nextInt();
		System.out.println("rows and cols 2 matrix");
		int r2 = s.nextInt();
		int c2 = s.nextInt();
		if (c1 != r2)
			System.out.println("invalid input not \n possible multiplication");
		else {
			int[][] a = takeinput(r1, c1);
			int[][] b = takeinput(r2, c2);

			int[][] c = multiply(a, b);
			display(c);
		}

	}

	public static int[][] multiply(int[][] a, int[][] b) {

		int[][] c = new int[ a.length][b[0].length];
		int sum = 0;
		for (int i = 0; i < a.length; i++) {

			for (int j = 0; j < b[0].length; j++) {
				sum = 0;
				for (int k = 0; k < a[0].length; k++) {
					sum += (a[i][k] * b[k][j]);
				}
				c[i][j] = sum;
			}
		}

		return c;
	}

	public static void display(int[][] arr) {
		for (int row = 0; row < arr.length; row++) {
			for (int col = 0; col < arr[0].length; col++) {
				System.out.print(arr[row][col] + "  ");
			}
			System.out.println();
		}
	}

	public static int[][] takeinput(int rows, int cols) {

		int[][] arr = new int[rows][cols];
		for (int row = 0; row < arr.length; row++) {
			for (int col = 0; col < arr[0].length; col++) {
				System.out.println("arr[" + row + "-" + col + "]");
				arr[row][col] = s.nextInt();
			}
		}
		return arr;
	}

}
