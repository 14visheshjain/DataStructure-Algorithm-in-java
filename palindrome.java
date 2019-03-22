/*
 * @author Vishesh Jain
 * @date   27-Feb-2019
 */
package lecture6;

import java.util.Scanner;

public class palindrome {

	public static void main(String[] args) {
		Scanner a = new Scanner(System.in);
 		String s = a.next();
         System.out.println(palindrome(s));  
	}

	public static boolean palindrome(String s) {
	for(int i =0 ; i<s.length()/2 ; i++ ) {
		if(s.charAt(i)!=s.charAt(s.length()-1-i))
			return false;
	}
	
	
	
return true ;}
}
