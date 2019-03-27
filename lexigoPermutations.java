package lecture9;

import java.util.Scanner;

public class lexigoPermutations {
	public static void main(String[] args) {
		Scanner a = new Scanner(System.in);
		String s = a.next();
		lexiper(s, "");
	}

	public static void lexiper(String ques, String ans) {
      if(ques.length()==0) {
    	  System.out.println(ans);
    	  return;
      }
      for(int  i =0 ; i< ques.length() ; i++) {
    	  char ch = ques.charAt(i);
    	  String ros = ques.substring(0, i) + ques.substring(i+1);
    	  lexiper(ros , ans+ch);
    	  }
	}
}
