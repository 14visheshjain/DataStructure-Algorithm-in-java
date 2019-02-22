package lecture4;

import java.util.Scanner;

public class binarySearch {
	static Scanner s = new Scanner(System.in);

	public static void main(String[] args) {
		int[] arr = takeinput();
		System.out.println("item = ");
		int item = s.nextInt();
		System.out.println(binarySearch(arr, item));
	}

	public static int[] takeinput() {
		System.out.println("size?");
		int n = s.nextInt();
		int[] arr = new int[n];
		for (int i = 0; i < n; i++) {
			arr[i] = s.nextInt();

		}
		return arr;
	}

	public static int binarySearch(int[] arr, int item) {
		int mid, lo = 0, hi = arr.length - 1;
		while (lo <= hi) {
			mid = (lo + hi) / 2;
			if (arr[mid] > item) {
				hi = mid-1;
			} else if (arr[mid] < item) {
				lo = mid+1;
			} else
				return mid;

		}

		return -1;
	}

}
