package lecture7;

import java.util.Scanner;

public class maxFromEndOfArray {
	static Scanner a = new Scanner(System.in);

	public static void main(String[] args) {
		int[] arr = takeinput();
		int n = a.nextInt();
		System.out.println(findFend(arr, n, 0));
	}

	public static int[] takeinput() {
		int[] array;
		System.out.println(" enter size ");
		int n = a.nextInt();
		array = new int[n];
		for (int i = 0; i < n; i++) {
			array[i] = a.nextInt();
		}
		return array;
	}

	public static int findFend(int[] arr, int n, int vidx) {
		if (vidx == arr.length)
			return -1;
		int prev = findFend(arr, n, vidx + 1);

		if (prev == -1 && arr[vidx] == n) {

			return vidx;
		} else
			return prev;

	}
}
