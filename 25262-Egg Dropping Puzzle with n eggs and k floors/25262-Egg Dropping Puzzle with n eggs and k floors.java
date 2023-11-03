class Solution 
{
    //Function to find minimum number of attempts needed in 
    //order to find the critical floor.
    static int eggDrop(int n, int k) {
        int i, j, e;
        long[][] dp = new long[k+1][n+1];
        
        Arrays.stream(dp).forEach(arr -> Arrays.fill(arr, (long)Math.pow(10,9)));
        for(e=0; e<=n; e++)
            dp[0][e] = 0;
        for(i=1; i<=k; i++){
            for(j=1; j<=i; j++){
                for(e=1; e<=n; e++){
                    if (i == 1)
                        dp[i][e] = 1;
                    else if (e == 1)
                        dp[i][e] = i;
                    else
                        dp[i][e] = Math.min(dp[i][e], Math.max(dp[i-j][e], dp[j-1][e-1])+1);
                }
            }
        }
        return (int)dp[k][n];
	}
}