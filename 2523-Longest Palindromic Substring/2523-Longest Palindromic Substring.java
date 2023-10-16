import java.util.Arrays;

public class Solution {	
	public static String longestPalinSubstring(String str) {
		int i, j, n = str.length();
		String ans="";
		boolean[][] dp = new boolean[n][n];

		for(i=0; i<n; i++){
			for(j=0; j<=i; j++){
				if(i==j)
					dp[j][i] = true;
				else if (j<i-1)
					dp[j][i] = dp[j+1][i-1] && (str.charAt(i) == str.charAt(j));
				else
					dp[j][i] = str.charAt(i) == str.charAt(j);
				if (dp[j][i] && ans.length() < i-j+1)
					ans = str.substring(j,i+1);
			}
		}
		return ans;
	}
}
