package lecture7;

import java.util.Scanner;

public class findInArray {
	static Scanner a = new Scanner(System.in);

	public static void main(String[] args) {
		int[] arr = takeinput();
		int n = a.nextInt();
		System.out.println(find(arr, n, 0));
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

	public static int find(int[] arr, int n, int vidx) {
		if (vidx == arr.length)
			return -1;
		if (arr[vidx] == n)
			return vidx;
		else
			return (find(arr, n, vidx + 1));

	}
}
