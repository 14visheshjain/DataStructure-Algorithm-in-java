package lecture9a11;

import java.util.Scanner;

public class MergeSort {

	public static void main(String[] args) {
		Scanner a = new Scanner(System.in);
		
		int [] arr = {20,10,30,5,3,2,40,15};
		int [] ans =mergeSort(arr, 0, arr.length-1);
            for(int val : ans)
            	System.out.print(val+" ");
	}

	public static int[] mergeSort(int[] arr, int lo, int hi) {
		if(lo==hi) {
			int[] br = new int [1];
			br[0]=arr[lo];
 			return br;
		}
		int mid =( lo + hi )/ 2;
        int[] fh = mergeSort(arr, lo, mid);
        int[]  sh = mergeSort(arr, mid+1, hi);
        int [] ans = mergeTwoSortedArray(fh, sh);
        return ans;
	}

	public static int[] mergeTwoSortedArray(int[] one, int[] two) {
		int i = 0;
		int j = 0;
		int k = 0;
		int[] ans = new int[one.length + two.length];
		while ((i < one.length) && j < two.length) {
			if (one[i] < two[j]) {
				ans[k] = one[i];
				i++;
				k++;
			} else {
				ans[k] = two[j];
				j++;
				k++;
			}
		}
		if (i == one.length) {
			while (j < two.length) {
				ans[k] = two[j];
				j++;
				k++;
			}
		}
		if (j == two.length) {
			while (i < one.length) {
				ans[k] = one[i];
				i++;
				k++;
			}
		}
		return ans;
	}

}
