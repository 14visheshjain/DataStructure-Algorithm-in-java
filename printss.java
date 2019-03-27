package lecture9;

import java.util.Scanner;

public class printss {

	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		String a = s.next();
		printss(a, "");
	}

	public static void printss(String s, String ans) {
		if (s.length() == 0) {
			System.out.println(ans);
			return;
		}
		char ch = s.charAt(0);
		String ros = s.substring(1);
		printss(ros, ans);
		printss(ros, ans + ch);
		printss(ros, ans + (int) ch);
	}
}
