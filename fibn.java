package lecture7;

import java.util.Scanner;

public class fibn {
	public static void main(String[] args) {
		Scanner a = new Scanner(System.in);
		int n = a.nextInt();
		System.out.println(fib(n));
	}

	public static int fib(int n) {
		if (n == 0)
			return 0;
		if (n == 1)
			return 1;

		return fib(n - 1) + fib(n - 2);
	}
}
