package lecture9a21;

import java.util.Comparator;

public class GenericFxnDemo {

	public static void main(String[] args) throws Exception {
		car[] cars = new car[5];
		cars[0] = new car(500, 100, "black");
		cars[2] = new car(400, 900, "red");
		cars[4] = new car(300, 300, "blue");
		cars[1] = new car(200, 600, "grey");
		cars[3] = new car(100, 500, "green");
//		display(cars);
//		bubbleSort(cars, new carSpeedComparator());
//		display(cars);
//		bubbleSort(cars , new carPriceComparator());
//		display(cars);
//		bubbleSort(cars , new carColourComparator());
//		display(cars);
		GenericLinkedList<car> ll = new GenericLinkedList<>();
		for(car val : cars ) {
			ll.addLast(val);
		}
		ll.display();
		ll.getFirst();
		ll.removeFirst();
		
		
	}

	public static <T> void display(T[] arr) {
		for (int i = 0; i < arr.length; i++) {
			System.out.println(arr[i]);
		}
		System.out.println("---------------");
	}

	public static <T extends Comparable<T>> void bubbleSort(T[] arr) {

		int n = arr.length;
		for (int counter = 0; counter < n - 1; counter++) {
			for (int j = 0; j < (n - counter - 1); j++) {
				if (arr[j].compareTo(arr[j + 1]) > 0) {
					T temp = arr[j];
					arr[j] = arr[j + 1];
					arr[j + 1] = temp;
				}
			}

		}
	}

	public static <T> void bubbleSort(T[] arr, Comparator<T> obj) {

		int n = arr.length;
		for (int counter = 0; counter < n - 1; counter++) {
			for (int j = 0; j < (n - counter - 1); j++) {
				if (obj.compare(arr[j], arr[j + 1]) > 0) {
					T temp = arr[j];
					arr[j] = arr[j + 1];
					arr[j + 1] = temp;
				}
			}

		}
	}
}
