import java.util.Arrays;

public class Solution {

	private static final int MOD = 100000000;
	public static int mcm(int[] p){
		int i, j, k, n = p.length, ans;
		int[][] dp = new int[n][n];
		for(i=2; i<n; i++){
			for(j=i-1; j > 0; j--){
				if (i-j == 1)
					dp[j][i] = p[j-1]*p[j]*p[i];
				else{
					ans = MOD;
					for(k=j; k < i; k++)
						ans = Math.min(ans, dp[j][k]+dp[k+1][i]+p[j-1]*p[k]*p[i]);
					dp[j][i] = ans;
				}
			}
		}
		return dp[1][n-1];
	}


	
}