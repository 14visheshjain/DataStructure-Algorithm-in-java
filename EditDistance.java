package lecture9a24;

import javax.xml.ws.WebEndpoint;

public class EditDistance {

	public static void main(String[] args) {
//		System.out.println(EditDistanceBU("abcdaa", "agcfdaa"));
//		int[] arr = new int[500];
//		for (int i = 0; i < arr.length; i++) {
//			arr[i] = i + 1;
//		}
		int[] weight = {10,20,30,40,50};
		int[] price = {5,4,3,2,1};
		System.out.println(Knapsack01(weight,price,70 , 0, new int[weight.length+1][70+1] ) );
//		int[][] strg = new int[arr.length][arr.length];
//		System.out.println(WineTD(arr,0,arr.length-1,strg));
	}

	public static int editDistance(String s1, String s2) {
		if (s1.length() == 0 || s2.length() == 0) {
			return Math.max(s1.length(), s2.length());
		}
		char ch1 = s1.charAt(0);
		char ch2 = s2.charAt(0);
		String ros1 = s1.substring(1);
		String ros2 = s2.substring(1);
		int ans;
		if (ch1 == ch2) {
			ans = editDistance(ros1, ros2);
		} else {
			int i = editDistance(ros1, s2);
			int d = editDistance(s1, ros2);
			int r = editDistance(ros1, ros2);
			ans = Math.min(i, Math.min(r, d)) + 1;
		}
		return ans;
	}

	public static int EditDistanceBU(String s1, String s2) {
		int[][] arr = new int[s1.length() + 1][s2.length() + 1];

		for (int row = s1.length(); row >= 0; row--) {
			for (int col = s2.length(); col >= 0; col--) {
				if (row == s1.length()) {
					arr[row][col] = s2.length() - col;
					continue;
				}
				if (col == s2.length()) {
					arr[row][col] = s1.length() - row;
					continue;
				}
				if (s1.charAt(row) == s2.charAt(col)) {
					arr[row][col] = arr[row + 1][col + 1];
				} else {
					int i = arr[row + 1][col];
					int d = arr[row][col + 1];
					int r = arr[row + 1][col + 1];
					int ans = Math.min(i, Math.min(r, d)) + 1;
					arr[row][col] = ans;
				}
			}
		}
		return arr[0][0];
	}

	public static int MCMTD(int[] arr, int si, int ei, int[][] strg) {
		if (si + 1 == ei) {
			return 0;
		}
		if (strg[si][ei] != 0) {
			return strg[si][ei];
		}
		int min = Integer.MAX_VALUE;
		for (int k = si + 1; k < ei; k++) {
			int fm = MCMTD(arr, si, k, strg);
			int sm = MCMTD(arr, k, ei, strg);
			int self = arr[si] * arr[k] * arr[ei];
			int total = self + fm + sm;
			if (min > total)
				min = total;
		}
  
		strg[si][ei] = min;
		return min;

	}

	public static int MCMBU(int[] arr) {
		int[][] strg = new int[arr.length][arr.length];

		int n = arr.length;
m		for (int slide = 1; slide <= n - 2; slide++) {
			for (int si = 0; si <= n - slide - 2; si++) {
				int ei = si + slide + 1;
				int min = Integer.MAX_VALUE;
				for (int k = si + 1; k <= ei - 1; k++) {
					int fm = strg[si][k];
					int sm = strg[k][ei];
					int self = arr[si] * arr[k] * arr[ei];
					int total = self + fm + sm;
					if (min > total)
						min = total;
				}
				
				strg[si][ei] = min ;
 
			}

		}
		return strg[0][arr.length - 1];
	}
	public static int WineTD(int[] arr, int si , int ei  , int[][] strg) {
	int yr = arr.length-ei+si;
		if(si==ei) {
			return arr[si]*yr ;
			 
		}
		if(strg[si][ei]!=0)
			return strg[si][ei];
		int rr1 = WineTD(arr , si+1  , ei  ,strg) + arr[si]*yr;
		int rr2 = WineTD(arr , si , ei-1 , strg)+arr[ei]*yr;
		
		strg[si][ei]= Math.max(rr1, rr2);
		
		
		return strg[si][ei];
	}
	public static int WineBU(int[] arr) {
		int yr= arr.length ; 
		int[][] strg = new int[arr.length][arr.length];
		for(int slide=1 ; slide<=arr.length ; slide++) {
			for(int si = 0 ; si  <= arr.length-slide ; si++) {
				int ei = arr.length+si-yr ;
				if(si==ei) {
					strg[si][ei]=arr[si]*yr;
				 continue;
				}
				int fc = strg[si][ei-1] + yr*arr[ei];
				int sc = strg[si+1][ei] + yr*arr[si];
				
               int ans= Math.max(fc, sc);
               strg[si][ei] = ans;
				
			}
			yr--;
		}
		return strg[0][arr.length-1];
	}
	public static int Knapsack01(int[] weight ,int[] price , int cap , int vidx , int[][]strg){
		if(vidx==weight.length) {
			return 0 ;
		}
		if(strg[vidx][cap]!=0) {
			return strg[vidx][cap];
		}
		int exclude =  Knapsack01( weight , price,cap ,  vidx+1 ,strg);
		int include =0;
		if(cap>=weight[vidx]) {
			include = Knapsack01( weight ,price, cap -weight[vidx],  vidx+1 ,strg)+price[vidx];
		}
		int ans = Math.max(include, exclude);
		strg[vidx][cap] = ans;
		
		return ans;
	}
	public static void display(int[][] arr) {
		for (int row = 0; row < arr.length; row++) {
             for(int col = 0 ; col < arr[0].length ; col++) {
            	 System.out.print(arr[row][col] + "\t");
             }
            	 System.out.println();
		}
	}
}
