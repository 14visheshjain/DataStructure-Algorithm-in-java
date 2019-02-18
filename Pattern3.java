// Author:  Vishesh Jain
//Pattern:-
//5
//    *
//   ***
//  *****
// *******
//*********
// *******
//  *****
//   ***
//    *
package first;

import java.util.Scanner;

public class Pattern3 {

	public static void main(String[] args) {
		Scanner a = new Scanner(System.in);
		int n = a.nextInt();
		int i=1,j=1;
		while(i<=n) {
			j=1;
			while(j<=n-i) {
				System.out.print(" ");
			j++;}
			j=1;
			while(j<= 2*i-1) {
				System.out.print("*");
			j++;}
			System.out.println("");
		i++;}
      		
		 i=n-1;
		 j=1;
		while(i>0) {
			j=1;
			while(j<=n-i) {
				System.out.print(" ");
			j++;}
			j=1;
			while(j<= 2*i-1) {
				System.out.print("*");
			j++;}
			System.out.println("");
		i--;}
	}

}
