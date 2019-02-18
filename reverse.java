// Author:  Vishesh Jain

package first;

import java.util.Scanner;

public class reverse {

	public static void main(String[] args) {
		
		Scanner s = new Scanner(System.in);
		int n= s.nextInt();
		int temp = n ,count=0;
 		while(temp >0) {
			temp  = temp/10;
			count++;
		}
		int rev=0 ;
		while(count > 0) {
			rev = rev*10 + (n%10);
			n=n/10;
			count--;
		}
		System.out.println(rev);
	}

}
