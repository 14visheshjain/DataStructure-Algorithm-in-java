package lecture9a14;

import java.util.Scanner;

import lecture9a13.Stack;

public class nexGreaterElement {
	static Scanner a = new Scanner(System.in);

	public static void main(String[] args) throws Exception {
		int n = a.nextInt();
		while (n-- > 0) {
			int[] arr = takeinput();
			int[] ans = new int[arr.length];
			ans = nextGreater(arr, ans);
			int i = 0;
			for (int val : ans) {
				System.out.println(arr[i] + "," + val + " ");
				i++;
			}
		}
	}

	public static int[] nextGreater(int[] arr, int[] ans) throws Exception {
		Stack s = new Stack(100);
		for (int i = 0; i < arr.length; i++) {
			while (!s.isEmpty() && arr[s.peek()] < arr[i]) {
				ans[s.pop()] = arr[i];
			}
			s.push(i);
		}
		while (!s.isEmpty()) {
			ans[s.pop()] = -1;
		}
		return ans;
	}

	public static int[] takeinput() {
		int[] array;
		//System.out.println(" enter size ");
		int n = a.nextInt();
		array = new int[n];
		for (int i = 0; i < n; i++) {
			array[i] = a.nextInt();
		}
		return array;
	}

}
