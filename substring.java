package lecture9a11;

import java.util.Scanner;

public class substring {

	public static void main(String[] args) {
		Scanner a = new Scanner(System.in);
		String s = a.next();
		int count = s.length();
		System.out.println(palindrome(s));

	}

	public static int palindrome(String s) {
		int count = 0;
		for (int i = 0; i < s.length(); i++) {
			for (int orbit = 0; orbit + i < s.length() && i - orbit >= 0; orbit++) {
				if (s.charAt(i - orbit) == s.charAt(i + orbit))
					count++;
				else
					break;
			}
		}
		
		for (float i = 0.5f; i < s.length(); i++) {
			for (float orbit = 0.5f; orbit + i < s.length() && i - orbit >= 0; orbit++) {
				if (s.charAt((int)(i - orbit)) == s.charAt((int)(i + orbit)))
					count++;
			else 
				break;
		}
		}
		return count;
		
	}
}
