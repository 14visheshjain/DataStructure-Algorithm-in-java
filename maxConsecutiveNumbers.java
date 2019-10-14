package lecture9a22;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

public class maxConsecutiveNumbers {
	static Scanner a = new Scanner(System.in);

	public static void main(String[] args) {

		int[] arr = {2,12,9,16,10,5,3,20,25,11,1,8,6};
		maxConsecutive( arr);

	}

	private static void maxConsecutive(int[] arr) {
		HashMap<Integer, Boolean> h = new HashMap<>();
		for (int val : arr) {
			if (h.containsKey(val - 1)) {
				h.put(val, false);
			} else {
				h.put(val, true);
			}
			if (h.containsKey(val + 1)) {
				h.put(val + 1, false);
			}
		}
		int maxcount = 0 ;
		int starting = 0;
		for (Integer key : h.keySet()) {
			if (h.get(key)) {
				int count = 0;
				while (h.containsKey(key + count)) {
					count++;
				}
				if (count > maxcount) {
					maxcount = count;
					starting = key;
				}
			}
		}
      for(int i = starting  ;  i< starting + maxcount ; i++) {
    	  System.out.println(i);
      }
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
