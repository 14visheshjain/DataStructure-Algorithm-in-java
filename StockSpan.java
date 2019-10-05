package lecture9a14;

import java.util.Scanner;

import lecture9a13.Stack;

public class StockSpan {
	static Scanner a= new Scanner(System.in);
	public static void main(String[] args) throws Exception {

		int[] arr = takeinput();
		int[] ans = new int[arr.length];
	  ans =	stockSpan(arr, ans);
	  int i=0 ;
	  for(int val : ans) {
		  System.out.print( val+" " );
	     i++;       
	     }
	  System.out.print("END");
	}
	public static int[] stockSpan(int[] arr, int[] ans) throws Exception {
		Stack s = new Stack(100);
		for (int i = 0; i < arr.length; i++) {
			while (!s.isEmpty() && arr[s.peek()] < arr[i]) {
				s.pop(); 
			}
			if(s.isEmpty()) {
			ans[i]=i+1;	
			}else {
				ans[i]=i-s.peek();
			}
			s.push(i);
		}
		
		return ans;
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
}
