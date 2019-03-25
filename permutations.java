/*
 * @author Vishesh Jain
 * @date   25-March-2019
 */
package lecture8;

import java.util.ArrayList;
import java.util.Scanner;

public class permutations {

	public static void main(String[] args) {
		Scanner a = new Scanner(System.in);
		String s = a.next();
		System.out.println(permutations(s).size());
	}

	public static ArrayList<String> permutations(String s) {

		char ch = s.charAt(0);
		if (s.length() == 1) {
			ArrayList<String> rr = new ArrayList<>();
			rr.add("" + ch);
			return rr;
		}
		ArrayList<String> rr = permutations(s.substring(1));
		ArrayList<String> mr = new ArrayList<>();
		for (int i = 0; i < rr.size(); i++) {
			StringBuilder temp = new StringBuilder(rr.get(i));
			for (int j = 0; j <= temp.length(); j++) {
				temp.insert(j, ch);
				mr.add(temp.toString());
				temp.deleteCharAt(j);
			}

		}
		return mr;
	}
}
