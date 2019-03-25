/*
 * @author Vishesh Jain
 * @date   25-March-2019
 */
package lecture8;

import java.util.ArrayList;
import java.util.Scanner;

public class subsequencesWithAscii {
     static Scanner a = new Scanner(System.in);
	public static void main(String[] args) {
       String s = a.next();
        System.out.println(subsequences(s).size());       
	}
	public static ArrayList<String> subsequences(String s){
		if(s.length()==0) {
		ArrayList<String> RecRes=  new ArrayList<>();
		RecRes.add("");
		return RecRes;
		}
		char ch = s.charAt(0);
		ArrayList<String> Recres =  subsequences(s.substring(1));
		ArrayList<String>  MyRes = new ArrayList<>();
		for(String val : Recres ) {
			MyRes.add(val);
			MyRes.add(val+ ch);
			MyRes.add(val+(int)ch);
		}
		  return MyRes;
		
		
	}

}
