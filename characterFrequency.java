package lecture9a22;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

public class characterFrequency {

	public static void main(String[] args) {
		Scanner a = new Scanner(System.in);
       String s = a.next();
      System.out.println( characterFreq(s));
	}

	private static char characterFreq(String s) {
		HashMap<Character, Integer> h = new HashMap<>();
		for(int i=0 ; i<s.length() ; i++) {
			char ch = s.charAt(i);
			if(h.containsKey(ch)) {
				h.put(ch, h.get(ch)+1);
			}else {
				h.put(ch , 1);
			}
		}
		int max = Integer.MIN_VALUE;
		char ans = ' ' ;
		ArrayList<Character> arr = new ArrayList<>(h.keySet());
		for(char key : arr) {
		if(h.get(key)>max) {
			max= h.get(key);
			ans = key ; }
		}
		return ans ;
	}

}
