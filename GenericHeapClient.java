package lecture9a22;

import java.lang.reflect.Array;
import java.util.ArrayList;

import lecture9a21.car;

public class GenericHeapClient {

	public static void main(String[] args) {
		GenericHeap<car> h = new GenericHeap<>();
		car[] cars = new car[5];
		cars[0] = new car(500, 100, "black");
		cars[2] = new car(400, 900, "red");
		cars[4] = new car(300, 300, "blue");
		cars[1] = new car(200, 600, "grey");
		cars[3] = new car(100, 500, "green");
		int i = 5;

		h.add(cars[0]);
		h.display();
		h.add(cars[1]);
		h.display();
		h.add(cars[2]);
		h.display();
		h.add(cars[3]);
		h.display();
		h.add(cars[4]);
		h.display();
//
		while (!h.isEmpty()) {
			System.out.println();
			System.out.println(h.remove());
			h.display();
		}
//		ArrayList<ArrayList<Integer>> list = new ArrayList<>();
//		list.add(new ArrayList<>());
//		list.add(new ArrayList<>());
//		list.add(new ArrayList<>());
//		list.get(0).add(10);
//		list.get(0).add(20);
//		list.get(0).add(30);
//		list.get(0).add(40);
//		list.get(1).add(2);
//		list.get(1).add(3);
//		list.get(1).add(5);
//		list.get(1).add(7);
//		list.get(2).add(6);
//		list.get(2).add(15);
//		list.get(2).add(23);
//		list.get(2).add(50);
//		System.out.println(mergekSortedLists(list));
		ArrayList<Integer> arr = new ArrayList<>();
		arr.add(99);
		arr.add(10);
		arr.add(800);
		arr.add(12);
		arr.add(70);
		arr.add(96);
		arr.add(101);
		arr.add(1);
		System.out.println(kLargestElement(arr,3));
	}

	public static ArrayList<Integer> mergekSortedLists(ArrayList<ArrayList<Integer>> lists) {
		ArrayList<Integer> ans = new ArrayList<>();
		
		GenericHeap<store> gh = new GenericHeap<>();
		int i=0 ;
		while(i<lists.size()) {
			store ns = new store();
			ns.data=lists.get(i).remove(0);
			ns.listNo=i;
			gh.add(ns);
			i++;
		}
		while(!gh.isEmpty()) {
			//smallest number
			store ds = gh.remove();
			ans.add(ds.data);
			if(!lists.get(ds.listNo).isEmpty()) {
				store ns = new store();
				ns.data=lists.get(ds.listNo).remove(0);
				ns.listNo=ds.listNo;
				gh.add(ns);
			}	
		}
		return ans;
	}

    public static ArrayList<Integer> kLargestElement (ArrayList<Integer> lists , int k ){
    	ArrayList<Integer> ans = new ArrayList<>();
    	GenericHeap<store> gh = new GenericHeap<>();
    	for(int i=0 ; i<k ; i++) {
    		store st = new store();
    		st.data= lists.get(0);
    		gh.add(st);
    	}
    	for(int i =k-1 ; i<lists.size() ; i++) {
    		if(gh.getHP().data<lists.get(i)) {
    		store st =	gh.remove();
    		st.data = lists.get(i);
    		gh.add(st);
    		}
    	}
    	while(!gh.isEmpty()) {
    		ans.add(0, gh.remove().data);
    	}
		return ans;
	
    }
}
