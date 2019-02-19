package lecture2;

import java.util.Scanner;

public class inverse {

	public static void main(String[] args) {
		Scanner a = new Scanner(System.in);
		int n = a.nextInt();
		int ans = 0;
		int count = 1;
		int multiplier;
		while (n != 0) {
			int rem = n % 10;
			rem--;
			multiplier = (int) Math.pow(10, rem);
            n /= 10;
            ans = ans + (count*multiplier); 
			
			count++;
		}
		System.out.println(ans);
	}

}
