package lecture9a17;

public class GenericClient {

	public static void main(String[] args) {
		//10 3 20 2 50 0 60  0 30 1 70 0 40 2 80 0 90 0 
		GenericTree gt= new GenericTree(); 
          gt.display();
         // gt.multiSolver(90);
		System.out.println(gt.size());
		System.out.println(gt.max());
		System.out.println(gt.find(100));
		System.out.println(gt.ht());
		//gt.display();
	//	gt.mirror();
	//	gt.display();
//		gt.postorder();
//		System.out.println();
//		gt.preorder();
//		gt.levelOrderLW2();
//		gt.preorderI();
	//	gt.levelOrderGG();
//		gt.levelPrintRecurrsion(1);
		gt.multiSolver(20);
	}

}
