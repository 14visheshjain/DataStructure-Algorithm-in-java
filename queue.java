package lecture9a13;

public class queue {
	protected int[] data;
	protected int front;
	protected int size;

	public queue() {
		this.data = new int[5];
		this.front = 0;
		this.size = 0;
	}
	public queue(int n) {
		this.data = new int[n];
		this.front = 0;
		this.size = 0;
	}
	public int size() {
		return this.size;
	}

	public boolean isEmpty() {
		return this.size == 0;
	}

	public boolean isFull() {
		return this.size == this.data.length;
	}

	public void enqueue(int item) throws Exception {
		if (isFull())
			throw new Exception("Queue is full .");
		int rear = (this.front + this.size) % this.data.length;
		this.data[rear] = item;
		this.size++;
	}

	public int dequeue() throws Exception {
		if (isEmpty())
			throw new Exception("Queue is Empty .");
		int rv = this.data[this.front];
		this.front = (this.front + 1) % this.data.length;
		this.size--;
		return rv;
	}

	public int getFront() throws Exception {
		if (this.size == 0)
			throw new Exception("Queue is Empty .");
		return this.data[this.front];
	}

	public void display() {
		System.out.println("----------------");
		for (int i = 0; i < this.size; i++) {
			int p = (this.front + i) % this.data.length;
			System.out.println(this.data[p]);
		}
		System.out.println(" .");
		System.out.println("---------------");
	}

}
