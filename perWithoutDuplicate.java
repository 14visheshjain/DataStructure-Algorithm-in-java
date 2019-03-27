package lecture9;

import java.util.Scanner;

public class perWithoutDuplicate {
	public static void main(String[] args) {

		Scanner a = new Scanner(System.in);
		String s = a.next();
		lexiperWD(s, "");

	}

	public static void lexiperWD(String ques, String ans) {
		if (ques.length() == 0) {
			System.out.println(ans);
			return;
		}
		String avoidD = "";
		for (int i = 0; i < ques.length(); i++) {
			char ch = ques.charAt(i);
			boolean check = true;
			for (int j = 0; j < avoidD.length(); j++) {
				if (ch == avoidD.charAt(j)) {
					check = false;
					break;

				}
			}
			if(check) {
			String ros = ques.substring(0, i) + ques.substring(i + 1);
		 	lexiperWD(ros, ans + ch);
		     avoidD = avoidD + ch;	}
		}
	}
}
