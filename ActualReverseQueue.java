package lecture9a14;
import java.util.Scanner;
import lecture9a13.queue;

public class ActualReverseQueue {
static Scanner a = new Scanner(System.in);
	public static void main(String[] args) throws Exception {
		  queue q = new queue(100);
		  int n = a.nextInt();
            while(n-->0) {
            	int item = a.nextInt();
            	q.enqueue(item);
            }
   Actualreverse(q);
   q.display();
	}
	public static void Actualreverse(queue q) throws Exception {
		if(q.isEmpty()) {
			return ;
		}
		int temp = q.dequeue();
		Actualreverse(q);
		q.enqueue(temp);
		
		
		
		
	}

}
