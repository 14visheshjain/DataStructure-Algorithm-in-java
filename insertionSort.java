package lecture5;

import java.util.Scanner;

public class insertionSort {
	static Scanner s = new Scanner(System.in);

	public static void main(String[] args) {
		int[] arr = takeinput();
		insertionsort(arr);
		display(arr);
	}

	public static void insertionsort(int[] arr) {
       for(int counter =1; counter < arr.length  ; counter++) {
    	   int item = arr[counter];
    	   int j = counter -1;
    	   while(j>=0 && arr[j]>item) {
    		   arr[j+1] = arr[j];
    		   j--;
    	   }
    	   arr[j+1]=item;
       }
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
	public static void display(int[] a) {
		for (int val : a) {
			System.out.println(val);
		}
	}
}
