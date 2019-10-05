package lecture9a14;
import java.util.Scanner;
import lecture9a13.queue;

public class QueueReverseDisplay {
static Scanner a = new Scanner(System.in);
	public static void main(String[] args) throws Exception {
		  queue q = new queue(100);
		  int n = a.nextInt();
            while(n-->0) {
            	int item = a.nextInt();
            	q.enqueue(item );
            }
   reverseDisplay(q,0);    
   q.display();
	}
	public static void reverseDisplay(queue q , int i) throws Exception {
		if(q.size()==i) {
			return ;
			
		}
		int temp = q.dequeue();
		q.enqueue(temp);
		reverseDisplay(q,i+1);
		System.out.println(temp);
		
	}
	

}
