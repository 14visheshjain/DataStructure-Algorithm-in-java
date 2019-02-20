package lecture3;

import java.util.Scanner;

public class prime {

	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		int min = s.nextInt();
		int max = s.nextInt();
		printprimes(min , max);
		
	}

	public static void printprimes(int n1 , int n2) {
	      	while(n1<=n2) {
	      		boolean b ;
	      		b = isPrime(n1);
	      		if(b)
	      			System.out.println(n1);
	      		
	      	n1++;}
	}
	public static boolean isPrime(int n) {
		
		int i=2;
		boolean check  = true;
		while(i<=n/2) {
			if(n%i==0) {
				check=false;
				break;
			   }
			i++;
			}
		
	return(check); 
	  }
	
	}

