/*
 * @author Vishesh Jain
 * @date   28-March-2019
 */
package lecture9a10;

import java.util.Scanner;

public class parenthesis {
public static void main(String[] args) {
	
		Scanner a  =new Scanner(System.in);
    int n = a.nextInt() ;
    parenthesis(n , 0 ,0 , "");
}

public static void  parenthesis(int n , int open , int close , String ans) {
	if(close>n || open>n) {
		return ;
	}
	if(close>open) {
		return ;
	}
	if(open==n && close==n)
		System.out.println(ans);
	parenthesis(n , open+1,close , ans+"(");
	parenthesis(n , open , close+1,ans+")");
	
}
}
