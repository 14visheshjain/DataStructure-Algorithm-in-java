/*
 * @author Vishesh Jain
 * @date   25-March-2019
 */
package lecture8;

import java.util.ArrayList;
import java.util.Scanner;

public class MazepathMultiMove {

	public static void main(String[] args) {
		Scanner a = new Scanner(System.in);

		int r1 = a.nextInt();
		int c1 = a.nextInt();
		int r2 = a.nextInt();
		int c2 = a.nextInt();
		System.out.println(Mazepathmm(r1, c1, r2, c2).size());
	}

	public static ArrayList<String> Mazepathmm(int sr, int sc, int er, int ec) {
		if (sr == er && sc == ec) {
			ArrayList<String> rr = new ArrayList<>();
			rr.add("\n");
			return rr;
		}
		if (sr > er || sc > ec) {
			ArrayList<String> rr = new ArrayList<>();
			return rr;
		}
		ArrayList<String> mr = new ArrayList<>();
		for (int row = 1; row + sr <= er; row++) {
			ArrayList<String> rr = Mazepathmm(sr + row, sc, er, ec);
			for (String val : rr) {
				mr.add("V" + row + val);
			}
		}
		for (int col = 1; col + sc <= ec; col++) {
			ArrayList<String> rr = Mazepathmm(sr, sc + col, er, ec);

			for (String val : rr) {
				mr.add("H" + col + val);
			}
		}
		for (int diagonal = 1; diagonal + sc <= ec && diagonal + sr <= er; diagonal++) {
			ArrayList<String> rr = Mazepathmm(sr + diagonal, sc + diagonal, er, ec);
			for (String val : rr) {
				mr.add("D" + diagonal+ val);
			}
		}
		return mr;
	}

}
