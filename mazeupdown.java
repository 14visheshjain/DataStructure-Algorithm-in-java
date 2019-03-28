/*
 * @author Vishesh Jain
 * @date   28-March-2019
 */
package lecture9a10;

import java.util.ArrayList;
import java.util.Scanner;

public class mazeupdown {
	static Scanner a = new Scanner(System.in);

	public static void main(String[] args) {

		
		int r2 = 3;
		int c2 = 3;
		boolean[][] visited = new boolean[r2 + 1][c2 + 1];
             
		int[][] blocked = { { 0, 1, 0, 0 }, { 0, 0, 0, 0 }, { 0, 1, 0, 0 }, { 0, 0, 1, 0 } };
		Mazepath1(blocked, 0, 0, "", visited);
	}


	public static void Mazepath1(int[][] blocked, int sr, int sc, String ans, boolean[][] visited) {
		if (sr == blocked.length-1 && sc == blocked[0].length-1) {
			System.out.println(ans);
			return;
		}

		if (sr >= blocked.length || sc >= blocked[0].length || sr < 0 || sc < 0 || blocked[sr][sc] == 1
				|| visited[sr][sc] == true) {
			return;
		}
		visited[sr][sc] = true;
		Mazepath1(blocked, sr + 1, sc, ans + "B", visited);
		Mazepath1(blocked, sr, sc + 1, ans + "R", visited);
		Mazepath1(blocked, sr - 1, sc, ans + "T", visited);
		Mazepath1(blocked, sr, sc - 1, ans + "L", visited);
		visited[sr][sc] = false;
	}

}