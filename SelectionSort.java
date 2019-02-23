package lecture5;

import java.util.Scanner;

public class SelectionSort {
 static Scanner s  = new Scanner(System.in);
	public static void main(String[] args) {
        int[] arr = takeinput();
        selectionSort(arr);
        display(arr);
	}
	public static void selectionSort(int[] arr) {
		int n =arr.length; 
		for(int counter =0 ; counter <n ; counter++) {
			int min = counter;
			for(int j=counter +1 ; j<=n-1 ; j++) {
				if(arr[j]<arr[min])
					min=j ;
			}
			int temp = arr[min];
			arr[min] = arr[counter];
			arr[counter] = temp;
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
