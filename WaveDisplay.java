package lecture5;

import java.util.Scanner;

public class WaveDisplay {
	static Scanner s = new Scanner(System.in);

	public static void main(String[] args) {
		int[][] arr = takeinput();
		ROWdisplay(arr);
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

	public static void ROWdisplay(int[][] arr) {
		for (int col = 0; col < arr[0].length; col++) {
			if (col % 2 == 0)
				for (int row = 0; row < arr.length; row++) {
					System.out.println(arr[row][col] + " ");
				}
			else
				for (int row = arr.length - 1; row >= 0; row--) {
					System.out.println(arr[row][col] + " ");
				}

		}
	}
}
