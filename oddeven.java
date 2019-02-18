// Author:  Vishesh Jain
package first;

import java.util.Scanner;

public class oddeven {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner s = new Scanner(System.in);
		int n = s.nextInt();
		System.out.println(n);

		if (n % 2 == 0) {
			System.out.println("even");
		}
		else
			System.out.println("odd");
	}

}
