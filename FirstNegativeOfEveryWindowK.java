package lecture9a14;

import java.util.Scanner;

import lecture9a13.queue;
 
public class FirstNegativeOfEveryWindowK {
static Scanner a = new Scanner(System.in);
	public static void main(String[] args) throws Exception {
		int n =  a.nextInt();
		int[] arr = new int [n];
		int i=0;
         while(i<n) {
        	 arr[i] =  a.nextInt();
        	 i++;
         }
         int k=  a.nextInt();
         firstnegative(arr, k);
       
       
	}
	public static void  firstnegative(int [] arr, int k) throws Exception {
	
		queue q = new queue(100);
		for(int i=0 ; i<k ; i++)
			if(arr[i]<0)
				q.enqueue(i);
		
		for(int i=k ; i<arr.length ; i++) {
			//print
			if(q.isEmpty())
				System.out.println(0);
			else
				System.out.println(arr[q.getFront()]);
		//remove
			if( !q.isEmpty()&&q.getFront()<=i-k)
				q.dequeue();
			
		//insert
			if(arr[i]<0)
				q.enqueue(i);
				
		}
		if(q.isEmpty())
			System.out.println(0);
		else
			System.out.println(arr[q.getFront()]);
	}

}
