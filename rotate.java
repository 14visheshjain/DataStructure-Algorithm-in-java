package lecture2;

import java.util.Scanner;

public class rotate {

	public static void main(String[] args) {

		Scanner a = new Scanner(System.in);
		int n = a.nextInt();
		int rot = a.nextInt();
		int temp = n;
		int count = 0;
		while (temp != 0) {
			temp /= 10;
			count++;
		}
		
		if (rot < 0) {
			rot = count + rot;
		}
		rot = rot % count;
		
		// rotate
		int divisor = (int) Math.pow(10, rot);
		int rem = n % divisor;
		int quotient = n / divisor;
		int multiplier = (int) Math.pow(10, count - rot);
		int ans = quotient + rem * multiplier;

		System.out.println(ans);
		a.close();
	}
}