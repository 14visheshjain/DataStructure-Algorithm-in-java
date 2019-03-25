/*
 * @author Vishesh Jain
 * @date   25-March-2019
 */
package lecture8;

import java.util.ArrayList;
import java.util.Scanner;

public class BoardPath {

	public static void main(String[] args) {
		Scanner a = new Scanner(System.in);
		int cur = a.nextInt();
		int end = a.nextInt();
		System.out.println(ways(cur, end));

	}

public static ArrayList<String> ways( int cur , int end){
	if(end == cur) {
		ArrayList<String> rr = new ArrayList<>();
		rr.add("\n");
		return rr;
	}
	if(cur> end) {
		ArrayList<String> rr = new ArrayList<>();
		
		return rr;
	}
	ArrayList<String> mr = new ArrayList<>();
	ArrayList<String> rr = new ArrayList<>();
	for(int dice = 1 ; dice<=6 ; dice++) {
	     rr = ways(cur + dice , end);
	    for(String val : rr) {
	     mr.add( dice + val);
	     }
      }
return mr;
   }
}
