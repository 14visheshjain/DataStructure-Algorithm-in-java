package lecture3;

import java.util.Scanner;

public class celciuostofaheraniet {

	public static void main(String[] args) {
		Scanner scn = new Scanner(System.in);
		int min = scn.nextInt();
		int max = scn.nextInt();
		int step = scn.nextInt();
        int temp = min;
        while(temp <= max) {
        	int c = (int)( (5/9.0)*(temp-32));
        	System.out.println(temp + "\t"+ c);
        temp +=step;}
	}

}
