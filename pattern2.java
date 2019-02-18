package first;

import java.util.Scanner;

public class pattern2 {

	public static void main(String[] args) {
	Scanner s = new Scanner(System.in);
	int n = s.nextInt();
	int i=1,j=1;
	while(i<=n) {
		j=1;
		while(j<=n-i) {
			System.out.print(" ");
		j++;}
		j=1;
		while(j<= 2*i-1) {
			System.out.print("*");
		j++;}
		System.out.println("");
	i++;}

	}

}
