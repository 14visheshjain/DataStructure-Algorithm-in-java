package lecture9a12;

import java.util.Scanner;

public class power {

	public static void main(String[] args) {
		Scanner a = new Scanner(System.in);
		int x = a.nextInt();
		int n = a.nextInt();
		System.out.println(power(x, n));

	}

	public static int power(int x, int n) {
		boolean check = false;
		if (n % 2 == 1)
			check = true;
		int multiplier = x;
		while (n > 1) {
			multiplier *= multiplier;
			n /= 2;
		}
		if (check)
			multiplier *= x;
		return multiplier;
	}

}
