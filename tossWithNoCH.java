package lecture9;

import java.util.Scanner;

public class tossWithNoCH {

	public static void main(String[] args) {
		Scanner a = new Scanner(System.in);
		int n = a.nextInt();
		toss(n, "" , true);
	}

//	public static void toss(int n, String ans) {
//		if (n == 0) {
//			System.out.println(ans);
//			return;
//		}
//		if (ans.length() == 0) {
//			String myansH = ans + "H";
//			toss(n - 1, myansH);
//		}
//		if (ans.length() > 0 && ans.charAt(ans.length() - 1) != 'H') {
//			String myansH = ans + "H";
//			toss(n - 1, myansH);
//		}
//		String myansT = ans + "T";
//		toss(n - 1, myansT);
//
//	}
	public static void toss(int n, String ans , boolean flag) {
		if (n == 0) {
			System.out.println(ans);
			return;
		}
		
		if (flag) {
			String myansH = ans + "H";
			toss(n - 1, myansH , false);
		}
		String myansT = ans + "T";
		toss(n - 1, myansT , true);

	}
}
