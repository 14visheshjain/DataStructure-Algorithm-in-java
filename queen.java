/*
 * @author Vishesh Jain
 * @date   28-March-2019
 */
package lecture9a10;

import java.util.Scanner;

public class queen {

	public static void main(String[] args) {
		Scanner a = new Scanner(System.in);
		int row = a.nextInt();
		int col = a.nextInt();
		boolean[][] arr = new boolean[row][col];
		Nqueen(arr, 0, "");

	}

	public static void Nqueen(boolean[][] board, int row, String ans) {
		if (row == board.length) {
			System.out.println(ans);
			return;
		}
		for (int col = 0; col < board[0].length; col++) {
		if (isItSafe(board, row, col)) {
				board[row][col] = true;
				Nqueen(board, row + 1, ans + "{" + row + "-" + col + "}");
				board[row][col] = false;
			}
		}
	}

	public static boolean isItSafe(boolean[][] board, int row, int col) {
		int r = row - 1;
		int c = col;
		// check vertical
		for (; r >= 0; r--) {
			if (board[r][c])
				return false;
		}
		r = row - 1;
		c=col+1;
		// diagonal right
		while (r >= 0 && c < board[0].length) {
			if (board[r][c])
				return false;
			r--;
			c++;
		}
		// diagonal left

		r=row-1;
		c= col-1;
		while (r >= 0 && c >= 0) {
			if (board[r][c])
				return false;
			r--;
			c--;
		}
	return true;
	}
}
