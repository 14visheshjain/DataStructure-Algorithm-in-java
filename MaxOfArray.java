package lecture7;

import java.util.Scanner;

public class MaxOfArray {
	static Scanner s = new Scanner(System.in);

	public static void main(String[] args) {

		int[] arr = takeinput();
		System.out.println(max(arr, 0));
	}

	public static int max(int[] arr, int vidx) {

		if (vidx == arr.length)
			return Integer.MIN_VALUE;

		int prev = max(arr, vidx + 1);
		if (arr[vidx] > prev)
			return arr[vidx];
		else
			return prev;
	}

	public static int[] takeinput() {
		int[] array;
		System.out.println(" enter size ");
		int n = s.nextInt();
		array = new int[n];
		for (int i = 0; i < n; i++) {
			array[i] = s.nextInt();
		}
		return array;
	}
}
