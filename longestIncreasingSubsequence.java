import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.StringTokenizer;

public class longestIncreasingSubsequence {

	public static int binarySearch(int[] nums, int l, int r, int val) {
		while (r - l > 1) {
			int m = l + (r - l) / 2;
			if (nums[m] >= val)
				r = m;
			else
				l = m;
		}
 
		return r;
	}
 
	public static int lis(int[] nums) {
 
		int N = nums.length;
		int[] ansTable = new int[N];
		int len = 1;
		ansTable[0] = nums[0];
		for (int x = 1; x < N; x++) {
			if (nums[x] < ansTable[0]) {
				ansTable[0] = nums[x];
			} else if (nums[x] > ansTable[len - 1]) {
				ansTable[len++] = nums[x];
			} else {
				ansTable[binarySearch(ansTable, -1, len - 1, nums[x])] = nums[x];
			}
		}
 
		return len;
	}
 
	public static void main(String[] args) throws IOException {
 
		BufferedReader f = new BufferedReader(new InputStreamReader(System.in));
		//PrintWriter out = new PrintWriter(System.out);
 
		int t = Integer.parseInt(f.readLine());
 
		for (int i = 0; i < t; i++) {
			int N = Integer.parseInt(f.readLine());
			int[] nums = new int[N];
			StringTokenizer st = new StringTokenizer(f.readLine());
			for (int x = 0; x < N; x++) {
				nums[x] = Integer.parseInt(st.nextToken());
			}
			int ans = Integer.MIN_VALUE;
			for (int x = 0; x < N; x++) {
				int[] newNums = new int[N];
				for (int y = 0; y < N; y++) {
					newNums[y] = nums[(x + y) % N];
				}
				ans = Math.max(ans, lis(newNums));
			}
			System.out.println(ans);
		}
 		
 
	}
 
	
}
