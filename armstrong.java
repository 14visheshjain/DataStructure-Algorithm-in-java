package lecture3;

import java.util.Scanner;

public class armstrong {

	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		int min = s.nextInt();
		int max = s.nextInt();
		printArmstrong(min, max);

	}

	public static void printArmstrong(int n1, int n2) {
		while (n1 <= n2) {
			boolean b;
			b = isArmstrong(n1);
			if (b)
				System.out.println(n1);
			n1++;
		}
	}

	public static boolean isArmstrong(int n) {
		boolean b = false;
		int c = 0;
		c = count(n);
		int power = c;
		int temp = n;
		int sum = 0, rem = 0;

		while (c > 0) {
			rem = temp % 10;
			sum = sum + (int) Math.pow(rem, power);
			temp /= 10;
			c--;
		}
		if (sum == n)
			b = true;

		return b;

	}

	public static int count(int n) {
		int i = 0;
		while (n > 0) {
			n /= 10;
			i++;
		}
		return i;
	}
}
