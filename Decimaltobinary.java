package lecture2;

import java.util.Scanner;

public class Decimaltobinary {

	public static void main(String[] args) {
		Scanner a = new Scanner(System.in);
		int n = a.nextInt();
		int ans=0 , multiplier =1;
		while(n!=0) {
			int rem;
			rem= n%2;
			ans = ans +(rem * multiplier);
			n=n/2;
			multiplier *=10; 
		}
System.out.println(ans);

	}

}
