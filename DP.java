package lecture9a23;
import java.math.BigInteger;
import java.util.Arrays;
import java.util.Scanner;

public class DP {

	public static void main(String[] args) {
		Scanner a = new Scanner(System.in);
		String s1 = a.next();
		String s2 = a.next();
		System.out.println(LCSBU(s1, s2));
		int n = 3;
		System.out.println(LCSBU("wwabcdaaaqwertyuiop", "wwagcdefaaaqwertyuiop"));

	}

	public static int fib(int n, int[] strg) {
		if (n == 0)
			return 0;
		if (n == 1)
			return 1;
		if (strg[n] != 0)
			return strg[n];
		int fnm1 = fib(n - 2, strg);
		int fnm2 = fib(n - 1, strg);
		int fnm = fnm1 + fnm2;
		strg[n] = fnm;
		return fnm;
	}

	private static int fibBU1(int n) {
		int[] strg = new int[n + 1];
		strg[0] = 0;
		strg[1] = 1;
		for (int i = 2; i <= n; i++) {
			int temp = strg[i - 1] + strg[i - 2];
			strg[i] = temp;
		}
		return strg[n];

	}

	

	private static long fibBUspaceEff1(int n) {
		long[] strg = new long[2];
		strg[0] = 0;
		strg[1] = 1;
		for (int i = 2; i <= n; i++) {
			long temp = strg[0] + strg[1];
			strg[0] = strg[1];
			strg[1] = temp;
		}
		return strg[1];
	}

	public static int boardpathTD(int cur, int end, int[] strg) {
		if (end == cur) {
			return 1;
		}
		if (cur > end) {
			return 0;
		}
		if (strg[cur] != 0) {
			return strg[cur];
		}
		int count = 0;
		for (int dice = 1; dice <= 6; dice++) {

			count += boardpathTD(cur + dice, end, strg);
		}
		strg[cur] = count;
		return count;
	}

	public static int boardpathBU(int cur, int end) {
		int[] arr = new int[end + 6];
		arr[end] = 1;

		for (int i = end - 1; i >= 0; i--) {
			for (int j = 1; j <= 6; j++) {
				arr[i] += arr[i + j];
			}
		}
		return arr[0];
	}

	public static int boardpathBUSpaceEff(int cur, int end) {
		int[] arr = new int[6];
		arr[0] = 1;
		
		int sum = 0;
		for (int i = end - 1; i >= cur; i--) {
			sum = sum + arr[0];

			int rn = arr[5];
			for (int j = 5; j > 0; j--) {
				arr[j] = arr[j - 1];
			}
			arr[0] = sum;
			sum = sum - rn;
		}
		return arr[0];
	}

	public static int MazepathBU(int sr, int sc, int er, int ec) {
		int[][] arr = new int[er + 2][ec + 2];
		arr[er][ec + 1] = 1;

		for (int i = ec; i >= sc; i--) {
			for (int j = er; j >= sr; j--) {
				int a1 = arr[j][i + 1];
				int a2 = arr[j + 1][i];
				arr[j][i] = a1 + a2;
			}
		}
		return arr[sr][sc];
	}

	public static int MazepathBUSpaceEff(int sr, int sc, int er, int ec) {
		int[] arr = new int[ec + 1];
		arr[ec] = 1;

		for (int i = ec; i >= sc; i--) {
			for (int j = er; j >= sr; j--) {

				int sum = arr[0] + arr[ec];
				if (j == er) {
					sum = 1;
				}
				for (int k = ec; k > sc; k--) {
					arr[k] = arr[k - 1];
				}
				arr[0] = sum;
			}
		}
		return arr[0];
	}

	public static int MazepathBUSE(int er, int ec) {
		int[] arr = new int[ec + 1];
		Arrays.fill(arr, 1);

		for (int j = er - 1; j >= 0; j--) {

			for (int k = ec - 1; k >= 0; k--) {
				arr[k] = arr[k + 1] + arr[k];
			}

		}

		return arr[0];
	}

//	public static int coinChange(int n , int[] arr) {
//		
//		
//	}
	public static int LCS(String s1, String s2) {
		if (s1.length() == 0 || s2.length() == 0) {
			return 0;
		}
		char ch1 = s1.charAt(0);
		char ch2 = s2.charAt(0);

		String ros1 = s1.substring(1);
		String ros2 = s2.substring(1);

		int ans = 0;
		if (ch1 == ch2) {
			ans = LCS(ros1, ros2) + 1;
		} else {
			int rr1 = LCS(s1, ros2);
			int rr2 = LCS(ros1, s2);
			ans = Math.max(rr1, rr2);
		}
		return ans;
	}

	public static int LCSBU(String s1, String s2) {
		int[][] arr = new int[s1.length() + 1][s2.length() + 1];
		for (int row = s1.length() - 1; row >= 0; row--) {
			for (int col = s2.length() - 1; col >= 0; col--) {
				if (s1.charAt(row) == s2.charAt(col)) {
					arr[row][col] = arr[row + 1][col + 1] + 1;
				} else {
					arr[row][col] = Math.max(arr[row + 1][col], arr[row][col + 1]);
				}
			}
		}
		return arr[0][0];
	}
}
