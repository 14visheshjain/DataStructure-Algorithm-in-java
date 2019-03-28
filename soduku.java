/*
 * @author Vishesh Jain
 * @date   28-March-2019
 */
package lecture9a10;

import java.util.Scanner;

public class soduku {
	static Scanner a = new Scanner(System.in);

	public static void main(String[] args) {
		int n=  a.nextInt();
		int[][] sudokuBoard =  takeinput(n);
		sudokusol(sudokuBoard, 0);
	}

	public static int[][] takeinput(int n) {
		//System.out.println("rows?");
		int rows = n;
		//System.out.println("cols?");
		int cols = n ;
		int[][] arr = new int[rows][cols];
		for (int row = 0; row < arr.length; row++) {
			for (int col = 0; col < arr[0].length; col++) {
				//System.out.println("arr[" + row + "-" + col + "]");
				arr[row][col] = a.nextInt();
			}
		}
		return arr;
	}


	public static void sudokusol(int[][] board, int np) {
		if(np == board.length*board.length) {
			display(board);
			System.out.println();
			return ;
		}
             int row= np/9;
              int col=np%9;
		
			if (board[row][col] == 0) {
				for (int put = 1; put <= 9; put++) {
                    
 					if(canPut(board, put, row, col)){
 						 board[row][col]=put;
 						 sudokusol(board , np+1);
 						 board[row][col]=0;
 					}

				}

			}
			else
				sudokusol(board , np+1);

		

	}

	public static boolean canPut(int[][] board, int put, int rows, int cols) {
		for (int col = 0; col < 9; col++) {
			if (board[rows][col] == put)
				return false;
		}
		for (int row = 0; row < 9; row++) {
			if (board[row][cols] == put)
				return false;
		}
		int minr = (rows/3 )*3;
		int maxr = minr+2;
		int minc = (cols/3 )*3;
		int maxc = minc+2;
		
      for(int row=minr ; row<=maxr ; row++) {
    	  for(int col = minc ; col <= maxc ; col++) {
    		  if (board[row][col] == put) {
  				return false; }
    	  }
      }
      return true;
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
