package lecture9;

import java.util.Scanner;

public class toss {

	public static void main(String[] args) {
		Scanner a = new Scanner(System.in);
		int n = a.nextInt();
		toss(n, "");
	}

	public static void toss(int n, String ans) {
		if (n == 0) {
			System.out.println(ans);
			return;
		}
		String myansH = ans+"H" ;
		toss(n-1 ,myansH);
		String myansT = ans+ "T";
		toss(n-1,myansT);
		
	}
}
