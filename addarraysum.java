/*
 * @author Vishesh Jain
 * @date   27-Feb-2019
 */
package lecture6;

import java.util.ArrayList;
import java.util.Scanner;

public class addarraysum {
	static Scanner a = new Scanner(System.in);

	public static void main(String[] args) {
		int[] a = takeinput();
		int[] b = takeinput();
		System.out.println(sum(a, b));

	}

	public static int[] takeinput() {
		int[] array;
		System.out.println(" enter size ");
		int n = a.nextInt();
		array = new int[n ];
		
		for (int i = 0; i < n; i++) {
			array[i] = a.nextInt();
		}
		return array;
	}

public static ArrayList<Integer> sum(int[] one  , int[] two){
	ArrayList<Integer> list  = new ArrayList<>();
	int i = one.length-1;
	int j = two.length-1;
	int carry = 0;
	while(i>=0 || j>=0) {
		int sum = carry ;
		if(i>=0)
			sum += one[i];
		
        if(j>=0)
           sum += two[j];
        
        int rem = sum%10;
        list.add(0 , rem);
        carry = sum / 10;
        i--;
        j--;
}
	if(carry!=0)
		list.add(0 , carry);
return list;}

}
