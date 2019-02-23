package lecture5;

import java.util.Scanner;

public class array2D {
	static Scanner s = new Scanner(System.in);

	public static void main(String[] args) {
		int[][] arr = takeinput();
		display(arr);
	}

	public static int[][] takeinput() {
		System.out.println("rows?");
		int rows = s.nextInt();
		System.out.println("cols?");
		int cols = s.nextInt();
		int[][] arr = new int[rows][cols];
		for (int row = 0; row < arr.length; row++) {
			for (int col = 0; col < arr[0].length; col++) {
				System.out.println("arr[" + row + "-" + col + "]");
				arr[row][col] = s.nextInt();
			}
		}
		return arr;
	}

	public static void display(int[][] arr) {
		for (int row = 0; row < arr.length; row++) {
             for(int col = 0 ; col < arr[0].length ; col++) {
            	 System.out.print(arr[row][col] + "  ");
             }
            	 System.out.println();
		}
	}
}
