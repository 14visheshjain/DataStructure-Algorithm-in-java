package lecture9a15;

import lecture9a13.Stack;

public class QueueUsingStackEnqueueEff {
	DynamicStack s = new DynamicStack();

	public void enqueue(int item) throws Exception {
		try {
			s.push(item);
            
		} catch (Exception e) {
			throw new Exception("Queue is full!");
		}
	}

	public int dequeue() throws Exception {
		try {
			DynamicStack temp = new DynamicStack();
			for (int i =1 ; i < s.size(); ) {
				temp.push(s.pop());
			}
			int rv = s.pop();
			while (!temp.isEmpty()) {
				s.push(temp.pop());
			}
			return rv;
		} catch (Exception e) {
			throw new Exception("Queue is Empty");
		}
	}

	public int size() {
		return s.size();
	}

	public int front() throws Exception {
		try {
			DynamicStack temp = new DynamicStack();
			for (int i = 1; i < s.size(); ) {
				temp.push(s.pop());
			}
			int rv = s.peek();
			while (!temp.isEmpty()) {
				s.push(temp.pop());
			}
			return rv;
		} catch (Exception e) {
			throw new Exception("Queue is Empty");
		}
	}

	public void display() throws Exception {
		DynamicStack temp = new DynamicStack();
		while(!s.isEmpty()) {
			temp.push(s.pop());
		}
		System.out.println("------------");
		while (!temp.isEmpty()) {
			int r = temp.pop();
			s.push(r);
			System.out.print(r + " ");
		}
		System.out.println(".");
		System.out.println("-----------------");
	}

    public boolean isEmpty() {
    	return this.isEmpty();
    }
    
    public boolean isFull() {
    	return this.isFull();
    }
 }