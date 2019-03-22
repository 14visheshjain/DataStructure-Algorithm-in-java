/*
 * @author Vishesh Jain
 * @date   27-Feb-2019
 */
package lecture6;

import java.util.Scanner;

public class substring {

	public static void main(String[] args) {
		Scanner a = new Scanner(System.in);
		String s = a.next();
		substring(s);
	}

	public static void substring(String s) {
           for(int  i= 0 ; i<s.length(); i++) {
        	   for(int j = i+1 ; j<=s.length() ; j++) {
        		   System.out.println(s.substring(i, j));
        	   }
           }
	}

}
