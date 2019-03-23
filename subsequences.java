package lecture7;

import java.util.ArrayList;
import java.util.Scanner;

public class subsequences {

	public static void main(String[] args) {
    Scanner a = new Scanner(System.in);
    String s  = a.next();
    System.out.println(getSS(s).size());
    for(int i=0 ; i<getSS(s).size() ; i++)
    System.out.print(getSS(s).get(i)+" ");
	}

	public static ArrayList<String> getSS(String s){
		
		if(s.length() ==0) {
			ArrayList<String> recRes = new ArrayList<>();
			recRes.add("");
			return recRes;
		}
		char ch = s.charAt(0);
		ArrayList<String> recRes =new ArrayList<> ();
		 s.substring(1);
		recRes = getSS( s.substring(1) );
		ArrayList<String> myRes = new ArrayList<>();  
		for(String val : recRes) {
			myRes.add(val);
			//myRes.add(ch+val); 
		  }
		for(String val : recRes) {
			//myRes.add(val);
			myRes.add(ch+val); 
		  }
		return myRes ;
		
	}
}
