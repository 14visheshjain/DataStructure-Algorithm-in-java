package lecture9;

import java.util.Scanner;

public class kpc {

	public static void main(String[] args) {
		Scanner a = new Scanner(System.in);
		String s = a.next();
		kpc(s, "");
	}

	public static void kpc(String s, String ans) {
		if (s.length() == 0) {
			System.out.println(ans);
			return;
		}
		char ch = s.charAt(0);
		String temp = getCode(ch);
		String ros = s.substring(1);
		for (int i = 0; i < temp.length(); i++) {
			kpc(ros, ans + temp.charAt(i));
		}
	}

	public static String getCode(char ch) {

		if (ch == '1')
			return "abc";
		else if (ch == '2')
			return "def";
		else if (ch == '3')
			return "ghi";
		else if (ch == '4')
			return "jk";
		else if (ch == '5')
			return "lmno";
		else if (ch == '6')
			return "pqr";
		else if (ch == '7')
			return "stu";
		else if (ch == '8')
			return "vwx";
		else if (ch == '9')
			return "yz";
		else if (ch == '0')
			return "@#";
		else
			return "";

	}
}
