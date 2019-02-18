// Author:  Vishesh Jain
package first;

import java.util.Scanner;

public class isprime {

	public static void main(String[] args) {
		
		Scanner s = new Scanner(System.in);
		int n = s.nextInt();
		int i = 2, j = 1;
		if(n==1)
			j=0;
		while (i <=(int) Math.sqrt(n) && n > 1) {
			if (n % i == 0) {
				j = 0;
				break;
			}
			i++;
		}
		if (j == 1)
			System.out.println("prime ");
		else
			System.out.println("not a prime");
	}

}
