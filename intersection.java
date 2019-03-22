/*
 * @author Vishesh Jain
 * @date   27-Feb-2019
 */
package lecture6;

import java.util.ArrayList;
import java.util.Scanner;

public class intersection {
	static Scanner a = new Scanner(System.in);

	public static void main(String[] args) {
		int[] a = takeinput();
		int[] b = takeinput();
    System.out.println(intersection(a,b));
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

//	public static ArrayList<Integer> intersection(int[] one, int[] two) {
//		ArrayList<Integer> list = new ArrayList<>();
//		int j = 0;
//		for (int i = 0; i < one.length; i++) {
//			while (j < two.length &&(one[i] >= two[j])  ) {
//
//				if (one[i] == two[j]) {
//					list.add(one[i]);
//					j++;
//					break;
//					
//				}
//				j++;
//			}
//		}
//		return list;
//	}
	public static ArrayList<Integer> intersection(int[] one, int[] two) {
		ArrayList<Integer> list = new ArrayList<>();
		int j = 0;
		int i = 0;
		
			while (i<one.length && j<two.length  ) {
                 if(one[i] > two[j])
                	 j++;
                 else if(one[i] < two[j])
			      i++;
                 else {
                	 list.add(one[i]);
                	 i++;
                	 j++;}
			}
		
		return list;
	}
	
}
