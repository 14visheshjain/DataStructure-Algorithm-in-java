++package lecture9a15;

import java.util.ArrayList;
import java.util.Scanner;


public class LinkedList {
	
	private class node {
		int data;
		node next;
	}

	private node head;
	private node tail;
	private int size;

//o(1)
	public int getFirst() throws Exception {
		if (this.size == 0)
			throw new Exception("LL is Empty");
		return this.head.data;
	}

//O(1)
	public int getLast() throws Exception {
		if (this.size == 0)
			throw new Exception("LL is Empty");
		return this.tail.data;
	}

//O(n)
	public int getAt(int idx) throws Exception {
		if (this.size == 0)
			throw new Exception("LL is Empty");
		if (idx > this.size || idx < 0)
			throw new Exception("Invalid Index");
		node temp = new node();
		temp = head;
		for (int i = 0; i < idx; i++) {
			temp = temp.next;
		}
		return temp.data;
	}

//O(1)
	public void addLast(int item) {
		node nn = new node();
		nn.data = item;
		nn.next = null;

		// attach
		if (this.size > 0) 
			tail.next = nn;
		if (this.size == 0) {
			this.head = nn;
			this.tail = nn;
			this.size++;
		} else {
			this.tail = nn;
			this.size++;
		}

	}

//O(n)
	public void display() {
		node temp = head;
		System.out.println("-------------------");
		while (temp.next != null) {
			System.out.println(temp.data);
			temp = temp.next;
		}
		System.out.println(temp.data);
		System.out.println(".");
		System.out.println("---------------------");
	}

//O(1)
	public void addFirst(int item) {
		node nn = new node();
		nn.data = item;
		nn.next = null;

		// update
		if (this.size == 0) {
			this.head = nn;
			this.tail = nn;
			this.size++;
		} else {
			nn.next = head;
			this.head = nn;
			this.size++;
		}

	}

//O(n)
	private node getNodeAt(int idx) throws Exception {
		if (this.size == 0)
			throw new Exception("LL is Empty");
		if (idx > this.size || idx < 0)
			throw new Exception("Invalid Index");
		node temp = new node();
		temp = head;
		for (int i = 0; i < idx; i++) {
			temp = temp.next;
		}
		return temp;
	}

//O(n)
	public void addAt(int idx, int item) throws Exception {

		if (idx > this.size || idx < 0)
			throw new Exception("Invalid Index");
		if (idx == 0)
			addFirst(item);
		else if (idx == this.size)
			addLast(item);
		else {
			node nn = new node();
			node pn = getNodeAt(idx - 1);
			nn.data = item;
			nn.next = pn.next;
			pn.next = nn;
			this.size++;
		}
	}

//O(1)
	public int removeFirst() throws Exception {
		if (this.size == 0) {
			throw new Exception("LL is Empty");
		}

		int rv = this.head.data;
		if (this.size == 1) {
			this.head = null;
			this.tail = null;
			this.size--;
		} else {
			this.head = head.next;
			this.size--;
		}
		return rv;
	}

	// O(n)
	public int removeLast() throws Exception {
		if (this.size == 0) {
			throw new Exception("LL is Empty");
		}
		int rv = this.tail.data;
		if (this.size == 0) {
			this.head = null;
			this.tail = null;
			this.size--;
		} else {
			node pn = getNodeAt(this.size - 2);
			this.tail = pn;
			pn.next = null;
			this.size--;
		}
		return rv;
	}

//O(n)
	public int removeAt(int idx) throws Exception {

		if (idx > this.size || idx < 0)
			throw new Exception("Invalid Index");
		if (idx == 0)
			return removeFirst();
		else if (idx == this.size - 1)
			return removeLast();
		else {
			node pn = getNodeAt(idx - 1);
			node cn = pn.next;
			node nn = cn.next;
			int rv = cn.data;
			pn.next = nn;
			this.size--;
			return rv;
		}
	}

	public void reverseDI() throws Exception {
		node front = head;
		for (int i = 1; i <= this.size / 2; i++) {
			int temp = front.data;
			node back = this.getNodeAt(this.size - i);
			front.data = back.data;
			back.data = temp;
			front = front.next;
		}

	}

	public void reversePI() {
		node prevRef = head;
		node curRef = head.next;
		prevRef.next = null;
		node temp;
		for (int i = 1; i < this.size; i++) {
			temp = curRef.next;
			curRef.next = prevRef;
			prevRef = curRef;
			curRef = temp;

		}
		curRef = this.tail;
		this.tail = this.head;
		this.head = curRef;
	}

	public void reverseDR() {

		 reverseDR(this.head);

	}

	private node reverseDR(node Node) {
		if (Node == null) {

			return this.head;
		}
		int temp = Node.data;
		Node = reverseDR(Node.next);
		Node.data = temp;
		return Node.next;
	}

	public void reversePR() {
		reversePR(null, this.head);
		node temp = this.head;
		this.head = this.tail;
		this.tail = temp;
	}

	private void reversePR(node prev, node cur) {
		if (cur == null)
			return;

		reversePR(cur, cur.next);
		cur.next = prev;

	}

	private class mover {
		node left;
	}

	public void reverseDRHeap() {
		mover HeapMover = new mover();
		HeapMover.left = this.head;
		reverseDRHeap(HeapMover, this.head, 0);

	}

	private void reverseDRHeap(mover HeapMover, node Right, int count) {
		if (Right == null) {
			return;
		}
		reverseDRHeap(HeapMover, Right.next, count + 1);
		if (count >= this.size / 2) {
			int temp = HeapMover.left.data;
			HeapMover.left.data = Right.data;
			Right.data = temp;
			HeapMover.left = HeapMover.left.next;
		}

	}

	public void fold() {
		mover HeapMover = new mover();
		HeapMover.left = this.head;
		fold(HeapMover, this.head, 0);
	}

	private void fold(mover heapMover, node right, int i) {
		if (right == null) {
			return;
		}
		fold(heapMover, right.next, i + 1);
		if (i >= this.size / 2) {
			node temp = heapMover.left.next;
			heapMover.left.next = right;
			right.next = temp;
			heapMover.left = temp;
		}
		if (i == this.size / 2) {
			this.tail = right;
			tail.next = null;
		}
	}

	public int mid() {
		return mid(this.head, this.head);
	}

	public int mid(node slow, node fast) {
		if (fast == null || fast.next == null) {
			return slow.data;
		}
		slow = slow.next;
		fast = fast.next.next;
		return mid(slow, fast);

	}

	private node midNode() {
		node slow = this.head;
		node fast = this.head;
		while (fast.next != null && fast.next.next != null) {
			slow = slow.next;
			fast = fast.next.next;
		}
		return slow;

	}

	public int kFromEnd(int k) {
		node slow = this.head;
		node fast = this.head;
		for (int i = 1; i <= k; i++)
			fast = fast.next;
		while (fast != null) {
			slow = slow.next;
			fast = fast.next;
		}
		return slow.data;

	}

	public void kreverse(int k) throws Exception {
		LinkedList prev = null;
		while (this.size > 0) {
			LinkedList cur = new LinkedList();
			for (int i = 1; i <= k; i++) {
				cur.addFirst(this.removeFirst());
			}
			if (prev == null)
				prev = cur;
			else {
				prev.tail.next = cur.head;
				prev.size += cur.size;
				prev.tail = cur.tail;

			}
		}
		this.head = prev.head;
		this.tail = prev.tail;
		this.size = prev.size;
	}

	private LinkedList mergeTwoSortedLinkedList(LinkedList other) {
		node temp = this.head;
		node temp1 = other.head;
		LinkedList sorted = new LinkedList();
		while (temp != null && temp1 != null) {
			if (temp.data < temp1.data) {
				sorted.addLast(temp.data);
				temp = temp.next;
			} else {
				sorted.addLast(temp1.data);
				temp1 = temp1.next;
			}

		}
		if (temp == null) {
			while (temp1 != null) {
				sorted.addLast(temp1.data);
				temp1 = temp1.next;
			}
		}
		if (temp1 == null) {
			while (temp != null) {
				sorted.addLast(temp.data);
				temp = temp.next;
			}
		}
		return sorted;
	}

	public void mergeSort() {
		if (this.size == 1) {
			return;
		}
		node midn = this.midNode();
		node midnNext = midn.next;
		LinkedList fh = new LinkedList();
		fh.head = this.head;
		fh.tail = midn;
		fh.tail.next = null;
		fh.size = (this.size + 1) / 2;

		LinkedList sh = new LinkedList();
		sh.head = midnNext;
		sh.tail = this.tail;
		sh.size = this.size / 2;

		// get two smaller solved/sorted linked lists
		fh.mergeSort();
		sh.mergeSort();

		// merge fh and sh
		LinkedList merged = fh.mergeTwoSortedLinkedList(sh);
		// update
		this.head = merged.head;
		this.tail = merged.tail;
		this.size = merged.size;
	}

	public void DetectRemoveloop() {

		node slow = this.head;
		node fast = this.head;

		while (fast != null && fast.next != null) {
			slow = slow.next;
			fast = fast.next.next;
			if (fast == slow)
				break;
		}
		if (fast == slow) {
			node start = this.head;
			node loop = slow;
			while (start.next != loop.next) {
				start = start.next;
				loop = loop.next;
			}
			loop.next = null;

		} else {
			System.out.println("No Loop");
		}

	}

	public void llDummy() {
		node n1 = new node();
		n1.data = 10;
		node n2 = new node();
		n2.data = 20;
		node n3 = new node();
		n3.data = 30;
		node n4 = new node();
		n4.data = 40;
		node n5 = new node();
		n5.data = 50;
		node n6 = new node();
		n6.data = 60;
		n1.next = n2;
		n2.next = n3;
		n3.next = n4;
		n4.next = n5;
		n5.next = n6;
		n6.next = n3;
		this.head = n1;
		this.tail = null;
		this.size = 6;
	}

	public boolean palindrome() {
		mover2 m = new mover2();
		m.start =  this.head;
		return palindrome(m.start, this.head);

	}
    private class mover2{
    	node start ;
    }
	private boolean palindrome(node start, node end) {
		if (end == null) {
			return true;
		}
		if (palindrome(start, end.next)) {
			if (start.data == end.data)
				return true;

		} 
     return false;
	}
	 
	public void triplet(LinkedList one  ,LinkedList two ,int sum){
		this.mergeSort();
		one.mergeSort();
		two.mergeSort();
		one.reverseDR();
		node o1 = this.head;

		while (o1 != null) {
			node o2 = two.head;
			node o3 = one.head;
			while (o2!= null && o3 != null) {
				int temp = o1.data + o2.data + o3.data;
				if (temp > sum)
					o3 = o3.next;
				else if (temp < sum)
					o2 = o2.next;
				else {
					System.out.println(o1.data + " " + o2.data + " " + o3.data);
					return;
				}
				
			
			}
			o1 = o1.next;
		}

			
	}
}
