package lecture9a22;

public class HeapClient {

	public static void main(String[] args) {
	heap h  =new heap();
	h.add(10);
	h.display();
	h.add(20);
	h.display();
	h.add(3);
	h.display();
	h.add(40);
	h.display();
	h.add(5);
	h.display();
	h.add(1);
	h.display();
	h.add(70);
	h.display();
	h.add(80);
	h.display();
while(!h.isEmpty()) {
	System.out.println(h.remove());
	h.display();
}
	}

}
