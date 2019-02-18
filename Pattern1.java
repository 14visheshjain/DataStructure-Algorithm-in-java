// Author:  Vishesh Jain
package first;

import java.util.Scanner;

public class Pattern1 {

	public static void main(String[] args) {
		Scanner a = new Scanner(System.in);
		int n = a.nextInt();
		int i=1,j;
		while(i<=n) {
			j=1;
			while(j<=i) {
				System.out.print("*");
				j++;
 			}
			System.out.println();
			i++;
		}

	}

}
