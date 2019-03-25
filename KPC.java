/*
 * @author Vishesh Jain
 * @date   25-March-2019
 */
package lecture8;

import java.util.ArrayList;
import java.util.Scanner;

public class KPC {
  static Scanner a = new Scanner(System.in);
	public static void main(String[] args) {
	String s = a.next();
	System.out.println(kpc(s).size());

	}
	public static ArrayList<String> kpc(String s){
		if (s.length() == 0) {
			ArrayList<String> recres = new ArrayList<>();
			recres.add("");
			return recres;
		}
		char ch = s.charAt(0);
		ArrayList<String> recres = kpc(s.substring(1));
		
		 String tempst = getCode(ch);
		 ArrayList<String> myres = new ArrayList<>();
		for(int i = 0 ; i<tempst.length(); i++) {
			char take = tempst.charAt(i) ;
	       		for(String req : recres) {
				myres.add(take+req   );
			  }
	       	}
		
		
		return myres;
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