package lecture9a21;



public class GenericLinkedList<T> {
	private class Node {
		T data;
		Node next;
	}

	private Node head;
	private Node tail;
	private int size;

//o(1)
	public T getFirst() throws Exception {
		if (this.size == 0)
			throw new Exception("LL is Empty");
		return this.head.data;
	}

//O(1)
	public T getLast() throws Exception {
		if (this.size == 0)
			throw new Exception("LL is Empty");
		return this.tail.data;
	}

//O(n)
	public T getAt(int idx) throws Exception {
		if (this.size == 0)
			throw new Exception("LL is Empty");
		if (idx > this.size || idx < 0)
			throw new Exception("Invalid Index");
		Node temp = new Node();
		temp = this.head;
		for (int i = 0; i < idx; i++) {
			temp = temp.next;
		}
		return temp.data;
	}

//O(1)
	public void addLast(T item) {
		Node nn = new Node();
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
		Node temp = head;
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
	public void addFirst(T item) {
		Node nn = new Node();
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
	private Node getNodeAt(int idx) throws Exception {
		if (this.size == 0)
			throw new Exception("LL is Empty");
		if (idx > this.size || idx < 0)
			throw new Exception("Invalid Index");
		Node temp = new Node();
		temp = head;
		for (int i = 0; i < idx; i++) {
			temp = temp.next;
		}
		return temp;
	}

//O(n)
	public void addAt(int idx, T item) throws Exception {

		if (idx > this.size || idx < 0)
			throw new Exception("Invalid Index");
		if (idx == 0)
			addFirst(item);
		else if (idx == this.size)
			addLast(item);
		else {
			Node nn = new Node();
			Node pn = getNodeAt(idx - 1);
			nn.data = item;
			nn.next = pn.next;
			pn.next = nn;
			this.size++;
		}
	}

//O(1)
	public T removeFirst() throws Exception {
		if (this.size == 0) {
			throw new Exception("LL is Empty");
		}

		T rv = this.head.data;
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
	public T removeLast() throws Exception {
		if (this.size == 0) {
			throw new Exception("LL is Empty");
		}
		T rv = this.tail.data;
		if (this.size == 0) {
			this.head = null;
			this.tail = null;
			this.size--;
		} else {
			Node pn = getNodeAt(this.size - 2);
			this.tail = pn;
			pn.next = null;
			this.size--;
		}
		return rv;
	}

//O(n)
	public T removeAt(int idx) throws Exception {

		if (idx > this.size || idx < 0)
			throw new Exception("Invalid Index");
		if (idx == 0)
			return removeFirst();
		else if (idx == this.size - 1)
			return removeLast();
		else {
			Node pn = getNodeAt(idx - 1);
			Node cn = pn.next;
			Node nn = cn.next;
			T rv = cn.data;
			pn.next = nn;
			this.size--;
			return rv;
		}
	}
	public int find(T data) {
		int idx =0 ;
		Node node = this.head ;
		while(node!=null &&  !node.data.equals(data) ) {
			idx++;
			node = node.next;
		}
		
		if(node!=null && node.data.equals(data))
			return idx;
		return -1;
	}
	public boolean isEmpty() {
		return this.size==0;
	}
	
}
