/*
 * @author Vishesh Jain
 * @date   25-March-2019
 */
package lecture8;

import java.util.ArrayList;
import java.util.Scanner;

public class MazePath {

	public static void main(String[] args) {
		Scanner a = new Scanner(System.in);

		 int r1 = a.nextInt();
		 int c1 = a.nextInt();
		int r2 = a.nextInt();
		
		int c2 = a.nextInt();
		ArrayList<String> mr = Mazepath(1, 1, r2, c2);
		System.out.println(mr.size());
		for (String val : mr)
			System.out.print(val + " ");
	}

	public static ArrayList<String> Mazepath(int sr, int sc, int er, int ec) {
		if (sr == er && sc == ec) {
			ArrayList<String> rr = new ArrayList<>();
			rr.add("");
			return rr;
		}
		if (sr > er || sc > ec) {
			ArrayList<String> rr = new ArrayList<>();
			return rr;
		}
		ArrayList<String> mr = new ArrayList<>();
		ArrayList<String> rr = Mazepath(sr + 1, sc, er, ec);
		for (String val : rr) {
			mr.add("V" + val);
		}

		rr = Mazepath(sr, sc + 1, er, ec);
		for (String val : rr) {
			mr.add("H" + val);
		}
		if (sr == sc || sr + sc == er + 1) {
			rr = Mazepath(sr + 1, sc + 1, er, ec);
			for (String val : rr) {
				mr.add("D" + val);
			}
		}
		return mr;
	}

}
