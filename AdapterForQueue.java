package lecture9a15;

public class AdapterForQueue {

	public static void main(String[] args) throws Exception {
//		QueueUsingStackDequeueEff q = new QueueUsingStackDequeueEff();
//	//	q.display();
//		q.enqueue(10);
//		q.enqueue(20);
//		q.dequeue();
//		q.enqueue(30);
//		q.enqueue(40);
//		q.dequeue();
//		q.enqueue(50);
//		q.display();
//		System.out.println(q.front());
//		q.enqueue(60);
//		q.enqueue(70);
//		q.display();
		QueueUsingStackEnqueueEff q1 = new QueueUsingStackEnqueueEff();
		q1.display();
		System.out.println(q1.size());
			q1.enqueue(10);
			q1.enqueue(20);
			//q1.dequeue();
			q1.enqueue(30);
			q1.enqueue(40);
			q1.display();
			System.out.println(q1.front());
			System.out.println(q1.size());
			q1.dequeue();
			q1.enqueue(50);
			
			
			q1.enqueue(60);
			q1.enqueue(70);
			q1.display();
//	  StackUsingQueuePushEff s = new StackUsingQueuePushEff();
//	  s.push(10);
//	  s.push(20);
//	  s.pop();
//	  s.push(30);
//	  s.push(40);
//	  s.pop();
//	  s.push(50);
//	  s.display();
//	  System.out.println(s.peek());
//	  s.push(60);
//	  s.push(70);
//	  s.display();
	}

}
