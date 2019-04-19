package lecture9a12;

import java.util.Arrays;
import java.util.Scanner;

public class SieveOfEratostheves {

	public static void main(String[] args) {
		Scanner a = new Scanner(System.in);

		int n = a.nextInt();

		SOE(n);
	}

	public static void SOE(int n) {
		boolean[] arr = new boolean[n + 1];
		Arrays.fill(arr, true);
		arr[0] = false;
		arr[1] = false;
		for (int table = 2; table * table <= n; table++) {
			if (arr[table] == false) {
				continue;
			}
			for (int multiplier = 2; table * multiplier <= n; multiplier++) {
				arr[table * multiplier] = false;

			}
		}
		for (int i = 0; i <= n; i++)
			if (arr[i])
				System.out.println(i);
	}

}
