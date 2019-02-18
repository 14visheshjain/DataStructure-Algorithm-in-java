// Author:  Vishesh Jain
package first;

import java.util.Scanner;

public class hcf {

	public static void main(String[] args) {
		System.out.println("enter two numbers");
		Scanner s = new Scanner(System.in);
//		int n1=s.nextInt();
//		int n2=s.nextInt();
//		int i=1,hcf=1;
//		while(i<=(n1) && i<=(n2)) {
//			if(n1%i==0 && n2%i==0)
//				hcf=i;
//		i++;}
//System.out.println(hcf);
		int divisor = s.nextInt();
		int divident = s.nextInt();
		int rem;
		while (divident % divisor != 0) {
			rem = divident % divisor;
			divident = divisor;
			divisor = rem;
		}
		System.out.println(divisor);
	}

}
