package lecture7;

import java.util.Scanner;

public class power {
	public static void main(String[] args) {
		Scanner a = new Scanner(System.in);
		int n = a.nextInt();
		int p = a.nextInt();
		System.out.println(power(n, p));
	}

	public static int power(int n, int p) {
		if (p == 0)
			return 1;

		return (power(n, p - 1) * n);

	}
}
