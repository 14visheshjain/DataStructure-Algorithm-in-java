package lecture2;

import java.util.Scanner;

public class decimaltoanybase {

	public static void main(String[] args) {
		Scanner a = new Scanner(System.in);
		int n = a.nextInt();
		int dst = a.nextInt();

		int ans = 0;
		int rem = 0;
		int multiplier = 1;
		while (n != 0) {
			rem = n % dst;
			ans = ans + (rem * multiplier);
			multiplier *= 10;
			n = n / dst;
		}
		System.out.println(ans);
		a.close();
	}

}
