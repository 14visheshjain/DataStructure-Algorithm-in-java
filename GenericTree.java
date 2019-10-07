package lecture9a17;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Scanner;

public class GenericTree {

	Scanner scn = new Scanner(System.in);

	private class Node {
		int data;
		ArrayList<Node> Children = new ArrayList<>();

	}

	private Node root;

	public GenericTree() {
		this.root = construct(null, -1);
	}

	private Node construct(Node parent, int ith) {

		if (parent == null) {
			System.out.println("Enter data for Root Node?");
		} else {
			System.out.println("Enter data for" + ith + "child of" + parent.data);
		}

		Node nn = new Node();
		nn.data = scn.nextInt();
		System.out.println("No of childrens of " + nn.data);
		int noc = scn.nextInt();
		for (int i = 0; i < noc; i++) {
			Node child = construct(nn, i);
			nn.Children.add(child);
		}
		return nn;
	}

	public void display() {
		display(this.root);

	}

	private void display(Node node) {
		String str = node.data + "->";
		for (Node child : node.Children) {
			str += child.data + ",";
		}
		str += ".";
		System.out.println(str);
		for (Node child : node.Children) {
			display(child);
		}

	}

	public int size() {
		return size(this.root);
	}

	private int size(Node node) {
		int sum = 0;
		for (Node child : node.Children) {
			sum += size(child);
		}
		return sum + 1;
	}

	public int max() {
		return max(this.root);
	}

	private int max(Node node) {
		int tm = node.data;
		for (Node child : node.Children) {
			int cm = max(child);
			tm = Math.max(cm, tm);
		}
		return tm;
	}

	public boolean find(int k) {
		return find(this.root, k);
	}

	private boolean find(Node node, int k) {
		if (k == node.data)
			return true;
		for (Node child : node.Children) {
			if (find(child, k))
				return true;
		}
		return false;
	}

	public int ht() {
		return ht(this.root);
	}

	private int ht(Node node) {
		int th = -1;
		for (Node child : node.Children) {
			int ch = ht(child);
			th = Math.max(ch, th);
		}
		return th + 1;
	}

	public void mirror() {
		mirror(this.root);
	}

	private void mirror(Node node) {
		ArrayList<Node> temp = new ArrayList<>();
		while (node.Children.size() != 0) {
			temp.add(node.Children.remove(node.Children.size() - 1));
		}
		node.Children = temp;
		for (Node child : node.Children) {
			mirror(child);
		}

	}

	public void preorder() {
		preorder(this.root);
	}

	private void preorder(Node node) {
		System.out.print(node.data + " ");
		for (Node child : node.Children) {
			preorder(child);
		}

	}

	public void postorder() {
		postorder(this.root);
	}

	private void postorder(Node node) {

		for (Node child : node.Children) {
			postorder(child);
		}
		System.out.print(node.data + " ");
	}

	public void levelOrder() {
		LinkedList<Node> queue = new LinkedList<>();
		queue.addLast(this.root);
		while (!queue.isEmpty()) {
			Node rn = queue.removeFirst();
			// print
			System.out.print(rn.data + " ");
			// child
			for (Node child : rn.Children) {
				queue.addLast(child);
			}
		}
		System.out.println();
	}

	public void levelOrderLW() {
		LinkedList<Node> queue = new LinkedList<>();
		queue.addLast(this.root);
		queue.addLast(null);

		while (!queue.isEmpty()) {
			Node rn = queue.removeFirst();
			if (rn == null) {
				System.out.println();
				if (!queue.isEmpty())
					queue.addLast(null);
			} else {
				// print
				System.out.print(rn.data + " ");
				// child
				for (Node child : rn.Children) {
					queue.addLast(child);
				}
			}
		}
		System.out.println();

	}

	public void levelOrderLW2() {
		LinkedList<Node> primary = new LinkedList<>();
		LinkedList<Node> helper = new LinkedList<>();
		primary.addLast(this.root);
		while (!primary.isEmpty()) {
			Node rn = primary.removeFirst();
			// print
			System.out.print(rn.data + " ");
			// child
			for (Node child : rn.Children) {
				helper.addLast(child);
			}
			if (primary.isEmpty()) {
				System.out.println();
				primary = helper;
				helper = new LinkedList<>();
			}
		}
	}
	public void levelOrderGG() {
		LinkedList<Node> stack = new LinkedList<>();
		LinkedList<Node> queue = new LinkedList<>();
        queue.addLast(this.root);
        int count  =1;
        while(!queue.isEmpty()) {
        	Node rn = queue.removeFirst();
        	//print
        	System.out.print(rn.data+" ");
        	//child
        	if(count%2==1) {
        	for(Node child : rn.Children) {
        		stack.addFirst(child);
        	}}
        	else {
        		for(int i = rn.Children.size()-1 ; i>=0 ; i--) {
        			stack.addFirst(rn.Children.get(i));
        		}
        	}
        	if(queue.isEmpty()) {
        		
        		queue = stack;
        		stack = new LinkedList<>();
        		count++ ;
        	}
        }
	}
	
	public void levelPrintRecurrsion(int tar) {
		levelPrintRecursion(this.root , 0 , tar);
		
	}

	private void levelPrintRecursion(Node node, int count, int tar) {
		if(count==tar){
		System.out.println(node.data+" ");
		return ;
		}
		for(Node child : node.Children) {
			levelPrintRecursion(child, count+1, tar);
		}
	}

	private class HeapMOver {
		int max = Integer.MIN_VALUE;
		int size = 0;
		int ht = 0;
		boolean find;

		// next
		Node pred;
		Node succ;
		Node jl;

	}

	public void multiSolver(int item) {
		HeapMOver mover = new HeapMOver();
		multisolver(item, mover, 0, this.root);
		System.out.println("ht--" + mover.ht);
		System.out.println("size--" + mover.size);
		System.out.println("find--" + mover.find);
		System.out.println("max--" + mover.max);
		System.out.println("pre--" + (mover.pred == null ? null : mover.pred.data));
		System.out.println("succ--" + (mover.succ == null ? null : mover.succ.data));
		System.out.println("jl--" + (mover.jl == null ? null : mover.jl.data));

	}

	private void multisolver(int item, HeapMOver mover, int level, Node node) {
		// update size
		mover.size++;

		// height
		if (mover.ht < level)
			mover.ht = level;

		// max
		if (mover.max < node.data)
			mover.max = node.data;
		// update succ
		if (mover.find == true && mover.succ == null)
			mover.succ = node;
		// find
		if (item == node.data)
			mover.find = true;
		// update pred
		if (mover.find == false)
			mover.pred = node;

		// jl
		if (node.data > item) {
			if (mover.jl == null || mover.jl.data > node.data)
				mover.jl = node;
		}
		for (Node child : node.Children) {
			multisolver(item, mover, level + 1, child);
		}
	}

	public void makeLinear() {
		makeLinear(this.root);
	}

	private void makeLinear(Node node) {
		Node child1 = node.Children.get(0);

	}

	private class Pair {
		Node node;
		boolean[] cd;
		int i;
	}

	public void preorderI() {
		LinkedList<Pair> stack = new LinkedList<>();
		Pair sp = new Pair();
		sp.node = this.root;
		stack.addFirst(sp);
		while (!stack.isEmpty()) {
			Pair tp = new Pair();
			tp = stack.getFirst();
			boolean[] cd2 = new boolean[tp.node.Children.size() + 1];
			tp.cd = cd2;

			if (tp.i <= tp.node.Children.size() && tp.cd[tp.i] == false) {
				if (tp.i == 0) {
					System.out.println(tp.node.data + " ");
					tp.i++;
				} else {
					Pair cp = new Pair();
					cp.node = tp.node.Children.get(tp.i - 1);
					stack.addFirst(cp);
					tp.i++;
				}

			} else {
				stack.removeFirst();
			}
		}
	}
}
