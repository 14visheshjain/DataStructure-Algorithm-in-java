package lecture5;

import java.util.Scanner;

public class SpiralDisplay {
	static Scanner s = new Scanner(System.in);

	public static void main(String[] args) {
int[][] arr  = takeinput();
  Spiraldisplay(arr);
	}
	
	public static void Spiraldisplay(int[][] arr) {
		int maxCol = arr[0].length-1,minCol=0 , minRow=0 , maxRow=arr.length-1; 
	     int  count =0 ;
	     int max = arr.length * arr[0].length ;
	     while(count<max) {
	    	 // first col
	    	 for(int row = minRow ; row<=maxRow && count<max ; row++) {
	    		 System.out.print(arr[row][minCol] + " ");
	    		 count++;
	    	 }
	    	 minCol++;
	    	 // last row
	    	 for(int col = minCol ; col <= maxCol && count<max ; col++) {
	    		 System.out.print(arr[maxRow][col] + " ");
	    		 count++;
	    	 }
	    	 maxRow--;
	    	 // last col
	    	 for(int row = maxRow; row>=minRow && count<max ; row--) {
	    		 System.out.print(arr[row][maxCol] + " ");
	    		 count++;
	    	 }
	    	 maxCol--;
	    	 // first row
	    	 
	    	 for(int col = maxCol ; col>=minCol && count<max ; col--) {
	    		 System.out.print(arr[minRow][col] + " ");
	    		 count++;
	    	 }
	    	 minRow++;
	     }
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
}
