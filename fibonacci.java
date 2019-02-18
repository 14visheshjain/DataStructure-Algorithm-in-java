// Author:  Vishesh Jain
package first;

import java.util.Scanner;

public class fibonacci {

	public static void main(String[] args) {
		
		Scanner s = new Scanner(System.in);
		int n = s.nextInt();
		int a = 0, b = 1, sum = 0;
		
		while (n >= 0) {
			System.out.println(a);
			sum = a + b;
			a = b;
			b = sum;

			n--;
		}
	}

}
