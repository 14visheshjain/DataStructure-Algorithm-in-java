package lecture9a15;

import java.util.Scanner;

public class LLClient {
static Scanner	 scn = new Scanner(System.in);
	public static void main(String[] args) throws Exception {
//		LinkedList l = new LinkedList();
//		l.addLast(1);
//		l.addLast(20);
//
//		l.addLast(2);
//		l.addLast(3);
//		l.addLast(4);
//		l.addLast(15);
//		l.addLast(10);
//
//		l.addLast(5);
//		l.addLast(6);
//		l.addLast(7);
//		l.addLast(7);
//		System.out.println(l.getFirst());
//		System.out.println(l.getLast());
//		System.out.println(l.getAt(3));
//		l.display();
//        l.reverseDI();
//        l.display();
//        l.reversePI();
//        l.display();
//        l.reverseDRHeap();
//        l.display();
////        System.out.println(l.mid());
//        l.delete();
//        l.display(); 
//        l.addLast(80);
//        l.addLast(90);
//   l.display();
//        System.out.println(l.kFromEnd(4));
//        l.kreverse(3);
//        l.display();
//        l.mergeSort();
////        l.display();
//       l.llDummy();
//        l.DetectRemoveloop();
//        l.display();
	int N = scn.nextInt();
	int m = scn.nextInt();int o = scn.nextInt();
		
		LinkedList list = new LinkedList();

		for (int i = 0; i < N; i++) {
			list.addLast(scn.nextInt());
		}

		LinkedList list1 = new LinkedList();

		for (int i = 0; i < m; i++) {
			list.addLast(scn.nextInt());
		}

		LinkedList list2 = new LinkedList();

		for (int i = 0; i < o; i++) {
			list.addLast(scn.nextInt());
		}

		int sum = scn.nextInt();
		list.triplet(list1 , list2 , sum);
		list.display();
	}

}
