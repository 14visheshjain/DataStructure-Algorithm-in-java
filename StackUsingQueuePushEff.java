package lecture9a15;

import lecture9a13.queue;
import lecture9a14.QueueReverseDisplay;
public class StackUsingQueuePushEff {
  DynamicQueue q = new DynamicQueue();
  public void push(int item) throws Exception {
	  try {
		  q.enqueue(item);
	  }catch(Exception e ) {
		  throw new Exception("Stack is Full!");
	  }
  }
  public int pop() throws Exception {
	  try{for(int i=1 ; i<q.size() ; i++) {
		  q.enqueue(q.dequeue());
	  }
	  int rv= q.dequeue();
	  return rv;}catch(Exception e) {
		  throw new Exception("Stack is Empty!");
	  }
  }
  public int size() {
	  return this.size();
  }
  public boolean isEmpty() {
	  
	  return this.isEmpty();
  }
  public boolean isFull() {
	  return this.isFull();
  }
  public void display() throws Exception {
	  System.out.println("-------------");
	  reverseDisplay(q,0); 
	  System.out.println(".");
	  System.out.println("------------");
	  
  }
  public static void reverseDisplay(DynamicQueue q , int i) throws Exception {
		if(q.size()==i) {
			return ;
			
		}
		int temp = q.dequeue();
		q.enqueue(temp);
		reverseDisplay(q,i+1);
		System.out.println(temp);
		
	}
  public int peek() throws Exception {
	  try{for(int i=1 ; i<q.size() ; i++) {
		  q.enqueue(q.dequeue());
	  }
	  int rv= q.getFront();
	  q.enqueue(q.dequeue());
	  return rv;}catch(Exception e) {
		  throw new Exception("Stack is Empty!");
	  }
  }
}
