package lecture9a11;

public class quickSort {
public static void main(String[] args) {
	int[] arr = {20,10,30,30,3,2,40,14};
	quicksort(arr , 0 , arr.length-1);
	for(int val : arr) {
		System.out.print(val + " ");
	}
}
public static void quicksort(int[] arr , int lo , int hi) {
	if(lo>=hi) {
		return;
	}
	int left = lo;
	int right = hi;
	int mid = (lo+hi)/2;
	int pivot = arr[mid];
	while(left <= right) {
		while(arr[left]<pivot) {
			left++;
		}
		while(arr[right]>pivot) {
			right--;
		}
		if(left<=right) {
			int temp = arr[left];
			arr[left]=arr[right];
			arr[right]=temp;
			left++;
			right--;
		}
	}
	 quicksort(arr, lo, right);
	 quicksort(arr, left, hi);
  }
}
