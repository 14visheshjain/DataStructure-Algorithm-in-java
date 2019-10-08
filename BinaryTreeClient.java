package lecture9a19;

public class BinaryTreeClient {

	public static void main(String[] args) {
		//10 true 20 true  40 false false true 50 false false true 30 false false
		int[] pre= {10,20,40,30,50,60,70};
		int[] in = {20,40,10,60,50,70,30};
		//int[] pre = {10 ,20,40,50,100,1,2,80,30,70,90,12,13};
		//int[] in = {40,20,1,100,2,50,80,10,70,30,12,90,13};
		BinaryTree bt = new BinaryTree() ;
		
//		bt.printkFar(30, 3);
	//	BinaryTree bt = new BinaryTree() ;
	bt.display();
//		System.out.println(bt.size());
//		System.out.println(bt.max());
//		System.out.println(bt.find(90));
//		System.out.println(bt.ht());
//		//Diameter
//		// 10 true 20 true 30 true 40 true 50 false false false false true 60 false true 70 false true 80 false false true 90 false false
	System.out.println(bt.DiameterOfTree());
		System.out.println(bt.Diameter2());
//		System.out.println(bt.isBalanced());
//		bt.preorder();
//		bt.preorderIterative();
//       System.out.println(bt.isBST());
	//	bt.verticalOrderDisplay();
	}

}
