package lecture9a11;

import java.util.Scanner;

public class polynomial {
public static void main(String[] args) {
	Scanner a = new Scanner(System.in);
	int n = a.nextInt();
	int x= a.nextInt();
 	int power=1;
 	int sum=0;
	for(int i = 1 ; i<= n ; i++) {
		power *= x ;
		sum += (n+1-i)*power;
	}
	System.out.println(sum);
}
}
