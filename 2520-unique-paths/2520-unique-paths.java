import java.util.* ;
import java.io.*; 
public class Solution {
	public static int uniquePaths(int m, int n) {
		int i, j;
		if (m == n && n == 1)
			return 1;
		int[] temp = new int[n+1], dp = new int[n+1];

		for(i=1; i<=m; i++){
			temp = new int[n+1];
			for(j=1; j<=n; j++){
				if (i == 1 || j == 1)
					temp[j] = 1;
				else 
					temp[j] = dp[j]+temp[j-1];
			}
			dp = temp;
		}
		return dp[n];
	}
}