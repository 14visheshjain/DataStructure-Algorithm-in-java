/*
 * @author Vishesh Jain
 * @date   28-March-2019
 */
package lecture9a10;
//Given a text and a wildcard pattern, implement wildcard pattern matching algorithm that finds if wildcard pattern is matched with text. The matching should cover the entire text (not partial text).
//
//The wildcard pattern can include the characters ‘?’ and ‘*’
//‘?’ – matches any single character
//‘*’ – Matches any sequence of characters (including the empty sequence)

import java.util.Scanner;

import javax.rmi.ssl.SslRMIClientSocketFactory;

public class wildCardMatching {
	public static void main(String[] args) {
		Scanner a = new Scanner(System.in);
		String src = a.next();
		String pattern = a.next();
		System.out.println(wildCardMatching(src, pattern));
	}

	public static boolean wildCardMatching(String src, String pattern) {
		if (src.length() == 0 && pattern.length() == 0)
			return true;
		if (src.length() != 0 && pattern.length() == 0)
			return false;
		if (src.length() == 0 && pattern.length() != 0) {
			for (int i = 0; i < pattern.length(); i++) {
				if (pattern.charAt(i) != '*')
					return false;
			}
			return true;
		}
		char srcch = src.charAt(0);
		char patternch = pattern.charAt(0);
		String ros = src.substring(1);
		String rop = pattern.substring(1);
		boolean rr;
		if (srcch == patternch || patternch == '?') {
			rr = wildCardMatching(ros, rop);
		} else if (patternch == '*') {
			rr = wildCardMatching(src, rop) || wildCardMatching(ros, pattern);
		} else
			return false;

		return rr;
	}
}
