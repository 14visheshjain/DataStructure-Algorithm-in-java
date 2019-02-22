package lecture4;

import java.util.Scanner;

public class BubbleSort {
	static Scanner a = new Scanner(System.in);

	public static void main(String[] args) {
		int[] arr = takeinput();
		bubbleSort(arr);
		display(arr);
	}

	public static int[] takeinput() {
		System.out.println("size?");
		int n = a.nextInt();
		int[] arr = new int[n];
		for (int i = 0; i < n; i++) {
			arr[i] = a.nextInt();

		}
		return arr;
	}

	public static void display(int[] a) {
		for (int val : a) {
			System.out.println(val);
		}
	}

	public static void bubbleSort(int[] arr) {

		int n = arr.length;
		for (int counter = 0; counter < n - 1; counter++) {
			for (int j = 0; j < (n - counter - 1); j++) {
				if (arr[j] > arr[j + 1]) {
					int temp = arr[j];
					arr[j] = arr[j + 1];
					arr[j + 1] = temp;
				}
			}

		}
	}

}
