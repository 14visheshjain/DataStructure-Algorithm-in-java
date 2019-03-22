/*
 * @author Vishesh Jain
 * @date   27-Feb-2019
 */
package lecture6;

import java.util.Scanner;

public class reverseinmath {

	public static void main(String[] args) {
		Scanner a = new Scanner(System.in);
		String s = a.next();
		System.out.println(reverse(s));
	}

	public static String reverse(String s) {
		String newst = "";
		int end = s.length();
		int begin = s.length() - 1;
		int j = 0;
		for (int i = s.length() - 1; i >= 0; i--) {

			if (Character.isDigit(s.charAt(i))) {
				begin = i;
				j = 1;
			} else {
				if (j == 0) {
					newst = newst + s.charAt(i);
					end = i;
					j = 0;
				}

				else	{	newst = newst + s.substring(begin, end);
				newst = newst + s.charAt(i);
				end = i;
				j = 0;}
			}

		}
		if (j == 1)
			newst = newst + s.substring(begin, end);

		return newst;
	}

}
