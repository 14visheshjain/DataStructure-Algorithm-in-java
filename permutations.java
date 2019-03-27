package lecture9;

import java.util.Scanner;

public class permutations {

	public static void main(String[] args) {
		Scanner a = new Scanner(System.in);
		String s = a.next();
		permutations(s ,"");

	}

	public static void permutations(String s, String ans) {
       if(s.length()==0) {
    	   System.out.println(ans);
    	   return;
       }
		char ch = s.charAt(0);
       for(int i = 0 ; i<= ans.length() ;i++ ) {
    	  String temp = ans.substring(0 ,i) + ch + ans.substring(i) ; 
    	   permutations(s.substring(1) ,temp );
       }
       
	}
}
                    