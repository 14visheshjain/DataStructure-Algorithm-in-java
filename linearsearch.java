package lecture4;

import java.util.Scanner;

public class linearsearch {
	static Scanner s = new Scanner(System.in);

	public static void main(String[] args) {

		int[] arr = takeinput();
		System.out.println("item = ");
		int item = s.nextInt();
		System.out.println(linearSearch(arr, item));
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

	public static int linearSearch(int[] arr, int item) {
		for (int i = 0; i < arr.length; i++) {
			if (arr[i] == item)
				return i;
		}

		return -1;
	}

}
