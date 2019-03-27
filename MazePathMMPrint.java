package lecture9;

import java.util.ArrayList;
import java.util.Scanner;

public class MazePathMMPrint {

	public static void main(String[] args) {
		Scanner a = new Scanner(System.in);

		int r1 = a.nextInt();
		int c1 = a.nextInt();
		int r2 = a.nextInt();
		int c2 = a.nextInt();
		Mazepathmm(r1, c1, r2, c2 , "");
	}

	public static void Mazepathmm(int sr, int sc, int er, int ec , String ans) {
		if (sr == er && sc == ec) {
			System.out.println(ans);
			}
		
	
		for (int row = 1; row + sr <= er; row++) {
		 Mazepathmm(sr + row, sc, er, ec , ans+"V" + row);
		
		}
		for (int col = 1; col + sc <= ec; col++) {
			 Mazepathmm(sr, sc + col, er, ec , ans+"H" + col);
		}
		for (int diagonal = 1; diagonal + sc <= ec && diagonal + sr <= er; diagonal++) {
		 Mazepathmm(sr + diagonal, sc + diagonal, er, ec , ans+"D"+diagonal);
		
		}
		
	}

}
