package lecture9a20;

public class BinarySearchTree {
	private class Node {
		int data;
		Node left;
		Node right;
	}

	private Node root;

	public BinarySearchTree(int[] in) {
		this.root = construct(in, 0, in.length - 1);
	}

	private Node construct(int[] in, int ilo, int ihi) {
		if (ilo > ihi) {
			return null;
		}
		int mid = (ilo + ihi) / 2;
		Node nn = new Node();
		nn.data = in[mid];

		// left
		nn.left = construct(in, ilo, mid - 1);
		// right
		nn.right = construct(in, mid + 1, ihi);
		return nn;
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
		if (node.right == null) {
			return node.data;
		}
		return max(node.right);
	}

	// O(n)
	public boolean find(int item) {
		return find(item, this.root);
	}

	private boolean find(int item, Node node) {
		if (node == null)
			return false;
		if (node.data > item) {
			return find(item, node.left);
		} else if (node.data < item) {
			return find(item, node.right);
		} else {
			return true;
		}

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

	public void printDec() {

		printDec(this.root);
		System.out.println("");
	}

	// O(n)
	private void printDec(Node node) {
		if (node == null)
			return;
		printDec(node.right);

		System.out.print(node.data + " ");
		printDec(node.left);

	}

	public void ReplaceWithSumOfLarger() {
		HeapMover mover = new HeapMover();
		ReplaceWithSumOfLarger(this.root, mover);
	}

	private class HeapMover {
		int sum = 0;
	}

	// O(n)
	private void ReplaceWithSumOfLarger(Node node, HeapMover mover) {
		if (node == null) {
			return;
		}
		ReplaceWithSumOfLarger(node.right, mover);

		int temp = node.data;
		node.data = mover.sum;
		mover.sum += temp;

		ReplaceWithSumOfLarger(node.left, mover);

	}

	public void printInRange(int lo, int hi) {
		printInRange(this.root, lo, hi);
	}

	private void printInRange(Node node, int lo, int hi) {
		if (node == null)
			return;
		if (hi < node.data) {
			printInRange(node.left, lo, hi);
		} else if (node.data < lo) {
			printInRange(node.right, lo, hi);
		} else {
			printInRange(node.left, lo, hi);
			System.out.println(node.data);
			printInRange(node.right, lo, hi);
		}
	}

	public void add(int item) {
		add(this.root, item);
	}

	private void add(Node node, int item) {

		if (node.data > item) {
			if (node.left == null) {
				Node nn = new Node();
				nn.data = item;
				nn.left = null;
				nn.right = null;
				node.left = nn;
				return;
			}
			add(node.left, item);
		} else {
			if (node.right == null) {
				Node nn = new Node();
				nn.data = item;
				nn.left = null;
				nn.right = null;
				node.right = nn;
				return;
			}
			add(node.right, item);
		}
	}

	public void remove(int item) {

		remove(null, this.root, item);
	}

	private void remove(Node parent, Node node, int item) {

		if (node.data > item) {
			remove(node, node.left, item);
		} else if (node.data < item) {
			remove(node, node.right, item);
		} else {
			if (node.left == null && node.right == null) {
				if (parent.right == node)
					parent.right = null;
				else
					parent.left = null;
			} else if (node.left == null) {
				if (parent.right == node)
					parent.right = node.right;
				else
					parent.left = node.right;
			} else if (node.right == null) {
				if (parent.right == node)
					parent.right = node.left;
				else
					parent.left = node.left;
			} else {
				int temp = max(node.left);
				remove(node, node.left, temp);
				node.data = temp;
			}
		}

	}

}
