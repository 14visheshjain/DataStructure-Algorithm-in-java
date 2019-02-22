package lecture4;
import java.util.Scanner ;

public class ReerseInArray {
     static Scanner  s = new Scanner(System.in);
	public static void main(String[] args) {
    int[] arr = takeinput();
    reverse(arr);
    display(arr);
    
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
	public static void reverse(int[] arr) {
		for(int i=0 ; i<= (arr.length-1)/2 ; i++ ) {
			int temp=arr[i];
			arr[i]=arr[arr.length - i -1] ; 
			arr[arr.length - i -1]=temp;
		}
	}
	public static void display(int[] a) {
		for (int val : a) {
			System.out.println(val);
		}
	}
}
