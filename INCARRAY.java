package lecture4;

import java.util.Scanner;
// NOT WORKING
public class INCARRAY {
  static Scanner s = new Scanner(System.in);
	public static void main(String[] args) {
      
      int[] arr = takeinput() ;
      int m = s.nextInt();
      while(m>=0) {
    	  int  a= s.nextInt();
    	  int b = s.nextInt();
    	  int k = s.nextInt();
    	  
    	increment(arr ,a,b,k );  
      m--;}
	}
	public static int[] takeinput() {
		int[] array;
		System.out.println(" enter size ");
		int n = s.nextInt();
		array = new int[n];
		for (int i = 0; i < n; i++) {
			array[i] = s.nextInt();
		}
		return array;
	}
	public static void increment(int[] arr , int a , int b , int k) {
		  for(int i=a ; i<=b ; i++) {
			  arr[i]+= k ;
		  }
			 
	}
}
