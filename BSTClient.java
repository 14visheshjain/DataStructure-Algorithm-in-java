package lecture9a20;

public class BSTClient {

	public static void main(String[] args) {
		int[] in = { 10, 20, 30, 40, 50, 60, 70 };
		BinarySearchTree bst = new BinarySearchTree(in);
		bst.display();
		bst.printDec();
		bst.ReplaceWithSumOfLarger();
		bst.display();
		bst.printInRange(9, 65);
		bst.add(5);
		bst.display();
		bst.remove(50);
		bst.display();
	}

}
