package lecture3;

import java.util.Scanner;

public class upperlower {

	public static void main(String[] args) {
    Scanner scn = new Scanner(System.in);
    char n = scn.next().charAt(0);
    if(n>='a' && n<='z')
    	System.out.println("lowercase");
    else if( n>='A'  && n<='Z')
    	System.out.println("UPPERCASE");
    else 
    	System.out.println("Invalid");
   scn.close(); 
	}

}
