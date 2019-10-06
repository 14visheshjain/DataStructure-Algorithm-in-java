package lecture9a15;

import lecture9a13.Stack;

public class QueueUsingStackDequeueEff {
	Stack s = new DynamicStack();

	public void enqueue(int item) throws Exception {
		try {
			Stack temp = new DynamicStack();
			while (!s.isEmpty()) {
				temp.push(s.pop());
			}
			s.push(item);
			while (!temp.isEmpty()) {
				s.push(temp.pop());
			}

		} catch (Exception e) {
			throw new Exception("Queue is Full");
		}

	}

	public int dequeue() throws Exception {
		try {
			return s.pop();
		} catch (Exception e) {
			throw new Exception("Queue is Full");
		}
	}
    
    public void display() throws Exception {
	  try { s.display();
	  }catch (Exception e) {
			throw new Exception("Queue is Empty");
		}
   }
   
    public int front() throws Exception {
		  try {  return s.peek();
		  }catch (Exception e) {
				throw new Exception("Queue is Empty");
			}
	   }
  
    public boolean isEmpty() throws Exception {
	 return s.isEmpty();	  
	   }
   
    public boolean isFull() throws Exception {
		 return s.isFull();	  
		   }
   
    public int size (){
	   return s.size();
   }
}
