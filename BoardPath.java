package lecture9;

//import java.util.Scanner;
shi se pahuchaya nhi tune board path shi kr jjjjjjjaaaaaaaaaaaddddddddddduuuuuuuuuuuuu
public class BoardPath {
	public static void main(String[] args) {
		boardpath(0, 10	, "");
	}
//	public static void main(String[] args) {
////		int cur =0;
////		int end = 3;
//		boardpath(0, 3, "");
//
//	}

	public static void boardpath(int cur, int end, String ans) {
		if (end == cur) {
			System.out.println(ans);

			return;
		}

		for (int dice = 1; dice <= 6 && dice + cur <= end; dice++) {

			boardpath(cur + dice, end, ans + dice);
		}

	}
}
