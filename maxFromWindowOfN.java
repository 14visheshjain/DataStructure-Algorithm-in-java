package lecture9a14;

import java.util.Scanner;

import lecture9a13.queue;

public class maxFromWindowOfN {
	static Scanner a = new Scanner(System.in);

	public static void main(String[] args) throws Exception {
		int n = a.nextInt();
		int[] arr = new int[n];
		int i = 0;
		while (i < n) {
			arr[i] = a.nextInt();
			i++;
		}
		int k = a.nextInt();
		max(arr, k);

	}

	public static void max(int[] arr, int k) throws Exception {

		queue q = new queue(1);
		int max = Integer.MIN_VALUE;
		for (int i = 0; i < k; i++)
			if (arr[i] > max) {
				max=arr[i];
         		try{q.dequeue();}catch(Exception e) {
         			
         		}}
		
				q.enqueue(i);
			}

		for (int i = k; i < arr.length; i++) {
			System.out.println(arr[q.getFront()]);
			// remove
			if (!q.isEmpty() && q.getFront() <= i - k)
				q.dequeue();

			// insert
			if (arr[i] > max) {
				max=arr[i];
				q.enqueue(i);}

		}
	
			System.out.println(arr[q.getFront()]);
	}

}
