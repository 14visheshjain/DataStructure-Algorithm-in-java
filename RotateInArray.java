package lecture4;

import java.util.Scanner;

public class RotateInArray {
 static Scanner a= new Scanner(System.in);
	public static void main(String[] args) {
       int[] arr= takeinput();
       int b=arr.length;
       int[] newarr = new int[b];
       int rot= a.nextInt();
       rotate(arr,newarr , rot );
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
    public static void rotate(int[]arr , int[] newarr , int rot) {
    	 rot = rot%arr.length;
    	 if(rot<0)
    		 rot = rot + arr.length;
    	 
    	
    	int i = 0;
    	for(i=0 ; i<arr.length ; i++) {
          if(i<rot)    	
    		newarr[i] =arr[i +arr.length - rot];
          else
        	  newarr[i] =arr[i - rot];  
    	}
    	
    }

}
