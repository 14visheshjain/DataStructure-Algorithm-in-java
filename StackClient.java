package lecture9a13;

public class StackClient {

	public static void main(String[] args) throws Exception {
		Stack s = new Stack();
		s.push(10);
		s.push(20);
		s.push(30);
		s.push(40);
		s.push(50);
		s.display();
//		s.pop();
//		s.pop();
//		s.pop();
//		s.display();
//		System.out.println(s.peek());
//		s.pop();
//		s.pop();
//		System.out.println();
          Reversedisplay(s);
		Stack temp = new Stack();
		s.display();
		ReverseStack(s, temp);
//
		s.display();
	}

	/// reverse display
	public static void Reversedisplay(Stack s) throws Exception {
		if (s.isEmpty())
			return;
		int a = s.pop();
		Reversedisplay(s);
		System.out.println(a);
		s.push(a);
	}

	/// reverse actual stack
	public static void ReverseStack(Stack s, Stack temp) throws Exception {
		if (s.isEmpty()) {
			filreverseStack(s, temp);
			return;
		}

		int a = s.pop();
		temp.push(a);
		ReverseStack(s, temp);

	}

	public static void filreverseStack(Stack s, Stack temp) throws Exception {
		if (temp.isEmpty())
			return;
		int a = temp.pop();
		filreverseStack(s, temp);
		s.push(a);
	}

}
