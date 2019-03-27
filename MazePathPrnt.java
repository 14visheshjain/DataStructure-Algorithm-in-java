package lecture9;

import java.util.ArrayList;
import java.util.Scanner;

public class MazePathPrnt {
	public static void main(String[] args) {
		Scanner a = new Scanner(System.in);

		int r1 = a.nextInt();
		int c1 = a.nextInt();
		int r2 = a.nextInt();
		int c2 = a.nextInt();
		Mazepath1(r1, c1, r2, c2 , "");
	}

	public static void Mazepath1(int sr, int sc, int er, int ec, String ans) {
		if (sr == er && sc == ec) {
			System.out.println(ans);
		}
 
	
	   if(sr<er)
		   Mazepath1(sr+1, sc , er, ec, ans+"V");
		 
	   if(sc<ec) {
		   Mazepath1(sr, sc + 1, er, ec , ans+"H");
		}
	   if(sc<ec && sr<er) {
		   Mazepath1(sr+1, sc + 1, er, ec , ans+"D");
	   }
}
}