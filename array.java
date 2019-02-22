package lecture4;

import java.util.Scanner;

public class array {
	static Scanner a = new Scanner(System.in);

	public static void main(String[] args) {
		int[] arr = takeinput();
		display(arr);
		System.out.println("maximum value = " + max(arr));
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

	public static void display(int[] a) {
		for (int val : a) {
			System.out.println(val);
		}
	}

	public static int max(int[] arr) {
		int m = Integer.MIN_VALUE ;
		for (int val : arr) {
			if (m < val)
				m = val;
		}

		return m;
	}
}
