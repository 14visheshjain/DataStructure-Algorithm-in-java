package lecture9a19;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Scanner;

public class BinaryTree {
	Scanner scn = new Scanner(System.in);

	private class Node {
		int data;
		Node left;
		Node right;

	}

	private Node root;

	public BinaryTree() {
		this.root = construct(null, true);
	}

	private Node construct(Node parent, boolean ilc) {
		if (parent == null) {
			System.out.println("Enter the data for root node");
		} else {
			if (ilc)
				System.out.println("Enter the data for left child of" + parent.data);
			else
				System.out.println("Enter the data for right child of" + parent.data);
		}
		int item = scn.nextInt();
		Node nn = new Node();
		nn.data = item;
		System.out.println("it has left child?");
		boolean hlc = scn.nextBoolean();
		if (hlc)
			nn.left = construct(nn, true);
		System.out.println("it has right child?");
		boolean hrc = scn.nextBoolean();
		if (hrc)
			nn.right = construct(nn, false);
		return nn;
	}

	public BinaryTree(int[] pre, int[] in) {
		this.root = construct2(pre, 0, pre.length - 1, in, 0, in.length - 1);
	}

	private Node construct2(int[] pre, int plo, int phi, int[] in, int inlo, int inhi) {
		if (plo > phi || inlo > inhi) {
			return null;
		}
		Node cn = new Node();
		// self
		cn.data = pre[plo];
		int si = inlo;
		while (pre[plo] != in[si]) {
			si++;
		}
		int nel = si - inlo;
		// left
		cn.left = construct2(pre, plo + 1, plo + nel, in, inlo, si - 1);
		// right

		cn.right = construct2(pre, plo + nel + 1, phi, in, si + 1, inhi);
		return cn;

	}

	public void display() {
		System.out.println("--------------------------");
		display(this.root);
		System.out.println("--------------------------");
	}

	// O(n)
	private void display(Node node) {
		if (node == null)
			return;
		String str = "";
		if (node.left == null) {
			str += ".";
		} else {
			str += node.left.data;
		}
		str += "->" + node.data + "<-";
		if (node.right == null) {
			str += ".";
		} else {
			str += node.right.data;
		}
		System.out.println(str);
		display(node.left);
		display(node.right);
	}

//O(n)
	public int size() {
		return size(this.root);
	}

	private int size(Node node) {
		if (node == null)
			return 0;

		int ls = size(node.left);
		int rs = size(node.right);
		return ls + rs + 1;
	}

//O(n)
	public int max() {
		return max(this.root);
	}

	private int max(Node node) {
		if (node == null)
			return Integer.MIN_VALUE;
		int lmax = max(node.left);
		int rmax = max(node.right);
		int max = lmax > rmax ? lmax : rmax;
		return max > node.data ? max : node.data;
	}

	// O(n)
	public boolean find(int item) {
		return find(item, this.root);
	}

	private boolean find(int item, Node node) {
		if (node == null)
			return false;
		if (item == node.data)
			return true;
		boolean ls = find(item, node.left);
		boolean rs = find(item, node.right);
		return ls || rs;

	}

	// O(n)
	public int ht() {
		return ht(this.root);
	}

	private int ht(Node node) {
		if (node == null)
			return -1;
		int lht = ht(node.left);
		int rht = ht(node.right);
		int maxht = lht > rht ? lht : rht;
		maxht++;
		return maxht;
	}

	/*
	 * The diameter of a tree (sometimes called the width) is the number of nodes on
	 * the longest path between two end nodes. The diagram below shows two trees
	 * each with diameter nine, the leaves that form the ends of a longest path are
	 * shaded (note that there is more than one path in each tree of length nine,
	 * but no path longer than nine nodes).
	 * 
	 */
	public int DiameterOfTree() {
		return DiameterOfTree(this.root);
	}

	private int DiameterOfTree(Node node) {
		if (node == null)
			return 0;
		int ld = DiameterOfTree(node.left);
		int rd = DiameterOfTree(node.right);
		int sp = ht(node.left) + ht(node.right) + 2;
		return Math.max(sp, Math.max(ld, rd));
	}

	private class Diapair {
		int ht = -1;
		int diameter = 0;
	}

	public int Diameter2() {
		return Diameter2(this.root).diameter;
	}

	private Diapair Diameter2(Node node) {
		if (node == null)
			return new Diapair();

		Diapair ldp = Diameter2(node.left);
		Diapair rdp = Diameter2(node.right);
		Diapair np = new Diapair();

		np.ht = Math.max(ldp.ht, rdp.ht) + 1;

		int lht = ldp.ht;
		int rht = rdp.ht;
		int sd = lht + rht + 2;
		np.diameter = Math.max(sd, Math.max(ldp.diameter, rdp.diameter));
		return np;
	}

	private class BalPair {

		int ht = -1;
		boolean isBal = true;
	}

	public boolean isBalanced() {
		return isBalanced(this.root).isBal;
	}

	private BalPair isBalanced(Node node) {
		if (node == null)
			return new BalPair();

		BalPair lbp = isBalanced(node.left);
		BalPair rbp = isBalanced(node.right);

		BalPair np = new BalPair();
		np.ht = Math.max(lbp.ht, rbp.ht) + 1;

		if (Math.abs(lbp.ht - rbp.ht) > 1 || !lbp.isBal || !rbp.isBal)
			np.isBal = false;

		return np;
	}

	public void preorder() {
		preorder(this.root);
		System.out.println();
	}

	private void preorder(Node node) {
		if (node == null)
			return;
		// self
		System.out.print(node.data + " ");
		// left
		preorder(node.left);
		// right
		preorder(node.right);

	}

	private class Pair {
		Node node;
		boolean sd;
		boolean ld;
		boolean rd;
	}

	public void preorderIterative() {
		LinkedList<Pair> stack = new LinkedList<>();
		Pair sp = new Pair();
		sp.node = this.root;
		stack.addFirst(sp);
		while (!stack.isEmpty()) {
			Pair tp = new Pair();
			tp = stack.getFirst();

			if (tp.node == null) {
				stack.removeFirst();
				continue;
			}
			if (tp.sd == false) {
				System.out.print(tp.node.data + " ");
				tp.sd = true;
			} else if (tp.ld == false) {
				Pair lp = new Pair();
				lp.node = tp.node.left;
				stack.addFirst(lp);
				tp.ld = true;
			} else if (tp.rd == false) {
				Pair rp = new Pair();
				rp.node = tp.node.right;
				stack.addFirst(rp);
				tp.rd = true;
			} else {
				stack.removeFirst();
			}
		}
		System.out.println();
	}

	public class bstPair {
		boolean isBST = true;
		int max = Integer.MIN_VALUE;
		int min = Integer.MAX_VALUE;

	}

	public boolean isBST() {
		return isBst(this.root).isBST;
	}

	private bstPair isBst(Node node) {
		if (node == null) {
			return new bstPair();
		}
		bstPair lp = isBst(node.left);
		bstPair rp = isBst(node.right);
		bstPair sp = new bstPair();
		sp.max = Math.max(node.data, Math.max(lp.max, rp.max));
		sp.min = Math.min(node.data, Math.min(lp.min, rp.min));
		if (node.data < lp.max || node.data > rp.min || !lp.isBST || !rp.isBST) {
			sp.isBST = false;
		}
		return sp;
	}

	private class VOPair {
		int data;
		int hl;
		int vl;

		@Override
		public String toString() {
			return this.data + "";
		}
	}

	public void verticalOrderDisplay() {
		HashMap<Integer, ArrayList<VOPair>> map = new HashMap<>();
		verticalOrderDisplay(map, this.root, 0, 0);
		ArrayList<Integer> keylist = new ArrayList<>(map.keySet());
		Collections.sort(keylist);

		for (int key : keylist) {
			ArrayList<VOPair> list = map.get(key);
			Collections.sort(list, new Compare());
			System.out.println(list);
		}
	}

	private void verticalOrderDisplay(HashMap<Integer, ArrayList<VOPair>> map, Node node, int hl, int vl) {
		if (node == null) {
			return;
		}
		VOPair np = new VOPair();
		np.data = node.data;
		np.hl = hl;
		np.vl = vl;
		if (!map.containsKey(vl)) {
			map.put(vl, new ArrayList<>());
		}
		map.get(vl).add(np);
		verticalOrderDisplay(map, node.left, hl + 1, vl - 1);
		verticalOrderDisplay(map, node.right, hl + 1, vl + 1);
	}

	public class Compare implements Comparator<VOPair> {

		@Override
		public int compare(VOPair o1, VOPair o2) {
			return o1.hl - o2.hl;
		}

	}

	public void printkFar(int data, int k) {
		printKFar(this.root, data, k);
	}

	private int printKFar(Node node, int data, int k) {
		if (node == null) {
			return -1;
		}
		if (node.data == data) {
			printKDown(node, 0, k);
			return 0;
		}

		int ld = printKFar(node.left, data, k);
		if (ld != -1) {

			if (ld + 1 == k) {
				System.out.print(node.data + " ");
			}

			printKDown(node.right, 0, k - ld - 2);

			return ld + 1;
		}
		int rd = printKFar(node.right, data, k);
		if (rd != -1) {
			if (rd + 1 == k) {
				System.out.print(node.data + " ");
			}

			printKDown(node.left, 0, k - rd - 2);

			return rd + 1;
		}
		return -1;
	}

	private void printKDown(Node node, int count, int k) {
		if (k < 0 || node == null) {
			return;
		}
		if (k == count) {
			System.out.print(node.data + " ");
			return;
		}

		printKDown(node.left, count + 1, k);
		printKDown(node.right, count + 1, k);

	}
}
