package lecture7;

import java.util.Scanner;

public class allOccurInArray {
	static Scanner a = new Scanner(System.in);

	public static void main(String[] args) {
		int[] arr = takeinput();
		int n = a.nextInt();
		display(allOccur(arr, 0, n, 0));

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

	public static void display(int[] ar) {
		for (int val : ar) {
			System.out.print(val+" ");
		}
	}

	public static int[] allOccur(int[] arr, int vidx, int n, int count) {
		if (vidx == arr.length) {
			int[] newarr = new int[count];
			return newarr;
		}

		if (arr[vidx] == n)
			count++;
		int[] newarr = allOccur(arr, vidx + 1, n, count);
		if (arr[vidx] == n) {
			newarr[count - 1] = vidx;
			
		}
		return newarr;

	}

}
