package lecture3;

import java.util.Scanner;

public class decorinc {

	//static Scanner s = new Scanner(System.in);

	public static void main(String[] args) {
 Scanner s = new Scanner(System.in);
		int n = s.nextInt();
		int j = 1;
		int retainer = 1;
		int prev = 0, check = 0;
		while (j <= n) {
			int a = s.nextInt();

			if (j == 1)
				prev = a;
			else if (prev <= a) {
				if (check != 1) {
					check = 1;
					retainer *= 10;
				}

			} else if (prev > a) {
				if (check != 2) {
					check = 2;
					retainer *= 10;
				}

			}
			prev = a;
			j++;
		}
		if (retainer <= 100)
			System.out.println("yes");
		else
			System.out.println("no");
	//	check(n);
		s.close();

	}

	public static void check(int n) {
//		Scanner a = new Scanner(System.in);
//		int j = 1;
//		int retainer = 1;
//		int prev = 0, check = 0;
//		while (j <= n) {
//			int a = s.nextInt();
//
//			if (j == 1)
//				prev = a;
//			else if (prev <= a) {
//				if (check != 1) {
//					check = 1;
//					retainer *= 10;
//				}
//
//			} else if (prev > a) {
//				if (check != 2) {
//					check = 2;
//					retainer *= 10;
//				}
//
//			}
//			prev = a;
//			j++;
//		}
//		if (retainer <= 100)
//			System.out.println("yes");
//		else
//			System.out.println("no");
	}
}