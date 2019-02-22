/*
 @author Vishesh Jain
 * @date   22-Feb-2019
 */
package lecture4;

import java.util.Scanner;

public class inverseOfArray {
static Scanner a= new Scanner(System.in);
	public static void main(String[] args) {
      int[] arr =takeinput();
      int[] newarr = new int[arr.length];
      inverse1(newarr , arr );
      display(newarr);
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
	public static void inverse1(int[] newarr , int[] arr) {
		for(int i=0 ; i<arr.length ; i++) {
			newarr[arr[i]]=i;
		}
	}
}
