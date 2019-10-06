package lecture9a15;

import lecture9a13.queue;

public class DynamicQueueClient {

	public static void main(String[] args) throws Exception {
		queue q = new DynamicQueue ();
		q.enqueue(10);
		q.dequeue();
		q.enqueue(20);
		q.enqueue(30);
		q.dequeue();
		q.enqueue(40);
		q.enqueue(50);
		q.enqueue(60);
		q.enqueue(70);
		q.enqueue(80);
		q.enqueue(90);
		q.enqueue(100);
		q.display();
		
	}

}
