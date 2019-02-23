package lecture5;

import java.util.Scanner;

public class jaggedarray {
	static Scanner scn = new Scanner(System.in);

	public static void main(String[] args) {
		int[][] arr = takeinput();
		display(arr);
	}

	public static int[][] takeinput() {
		int rows;
		System.out.println("rows?");
		rows = scn.nextInt();
		int[][] arr = new int[rows][];
		for (int row = 0; row < arr.length; row++) {
			System.out.println("col in row " + row);
			int cols = scn.nextInt();
			arr[row] = new int[cols];
			for (int col = 0; col < cols; col++) {
				System.out.println("arr[" + row + "-" + col + "]");
				arr[row][col] = scn.nextInt();
			}
		}
		return arr;
	}

	public static void display(int[][] arr) {
		for (int row = 0; row < arr.length; row++) {
			for (int j = 0; j < arr[row].length; j++)
				System.out.print(arr[row][j] + " ");
			System.out.println();
		}

	}
}
