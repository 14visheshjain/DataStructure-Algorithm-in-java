package lecture7;


import java.util.Scanner;

public class FormGreatestNum {
      static Scanner a  = new Scanner(System.in);
	public static void main(String[] args) {
         int[] arr = takeinput();
       
         bubbleSort(arr );
         for(int i = arr.length-1 ; i>=0 ; i--)
         System.out.print(arr[i]);
	} 
	public static int[] takeinput() {
		int[] array;
	//	System.out.println(" enter size ");
		int n = a.nextInt();
		array = new int[n];
		for (int i = 0; i < n; i++) {
			array[i] = a.nextInt();
		}
		return array;
	}
   
    public static void bubbleSort(int[] arr) {
    	
		int n = arr.length;
		for (int counter=0 ; counter<n-1 ; counter++) {
		    for(int j=0 ; j<(n-counter-1) ; j++) {
		    	String n1n2 = arr[j]+""+arr[j+1];
		    	String n2n1  = arr[j+1]+""+arr[j];
		    	
		    	if(Integer.parseInt(n1n2)>Integer.parseInt(n2n1)) {
		    		int temp = arr[j];
		    		arr[j]= arr[j+1];
		    		arr[j+1]=temp;
		    	}
		    }
		    	
		}
	}
}
