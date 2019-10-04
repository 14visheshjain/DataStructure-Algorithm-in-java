package lecture9a13;

public class QueueClient {

	public static void main(String[] args) throws Exception {
		queue q = new queue ();
		q.enqueue(10);
		q.enqueue(20);
		q.enqueue(30);
		q.enqueue(40);
		q.enqueue(50);
        System.out.println(q.size());
        q.display();
        q.dequeue();
        q.dequeue();
        q.enqueue(60);
        q.enqueue(70);
        q.display();
        System.out.println(q.isFull());
        System.out.println(q.isEmpty());
        
	}

}
