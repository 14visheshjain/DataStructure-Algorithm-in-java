/*
 * @author Vishesh Jain
 * @date   25-March-2019
 */
package lecture8;

import java.util.ArrayList;
import java.util.Scanner;

public class ReturnArrayList {
	static Scanner a = new Scanner(System.in);

	public static void main(String[] args) {
		String s = a.next();
	ArrayList<ArrayList<String>>r=	ArraypalindromeAL(s,0 , s.length()-1);
	System.out.println(r);
	}

	public static void Arraypalindrome(String s, String ans) {
		if (s.length() == 0) {
			System.out.println(ans);
	     return ;
		}
		for (int i = 1; i <= s.length(); i++) {
			if (palindrome(s.substring(0, i)))
				Arraypalindrome(s.substring(i), ans + s.substring(0, i) + " ");
		}
	}
	public static void Arraypalindrome2(String s, String ans, int si, int ei) {
		if (si>=ei) {
			System.out.println(ans);
			return ;
		}
		for (int i = si+1; i <= ei+1; i++) {
			String word = s.substring(si, i);
			if (palindrome(word))
				Arraypalindrome2(s, ans + word+ " ",i,ei);
		}
	}
	public static ArrayList<ArrayList<String>> ArraypalindromeAL(String s, int si, int ei) {
		if (si>ei) {
			ArrayList<ArrayList<String>> rr = new ArrayList<>();
			rr.add(new ArrayList<>());
			return rr;
		}
		ArrayList<ArrayList<String>> mr = new ArrayList<>();
		for (int i = si+1; i <= ei+1; i++) {
			String word = s.substring(si, i);
			if (palindrome(word)) {
				ArrayList<ArrayList<String>> rr =ArraypalindromeAL(s,i,ei);
			for(ArrayList<String> rral : rr) {
				rral.add(0,word);
			}
			mr.addAll(rr);
			}
		}
		return mr;
	}
	public static boolean palindrome(String s) {
		for (int i = 0; i < s.length() / 2; i++) {
			if (s.charAt(i) != s.charAt(s.length() - 1 - i))
				return false;
		}
		return true;

	}
}