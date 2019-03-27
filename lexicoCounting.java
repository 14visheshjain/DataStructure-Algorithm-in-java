package lecture9;

import java.util.Scanner;

public class lexicoCounting {

	public static void main(String[] args) {
		Scanner a = new Scanner(System.in);
		int cur = a.nextInt();
		int end = a.nextInt();
		lexicoCounting(cur, end);
	}

	public static void lexicoCounting(int cur, int end) {
		if (cur > end) {
			return;
		}
		System.out.println(cur);
		int i = 0;
		if (cur == 0) {
			i = 1;
		}
		for( ; i<=9 ; i++) {
			lexicoCounting(cur*10+i , end);
		}
	}
}
