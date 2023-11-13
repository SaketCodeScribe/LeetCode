class Solution{
    public int cutRod(int price[], int n) {
        int i, j;
        int[] dp = new int[n+1];
        
        for(i=1; i<=n; i++){
            for(j=1; j<=i; j++){
                if (i == j)
                    dp[i] = Math.max(dp[i],price[i-1]);
                dp[i] = Math.max(dp[i], dp[j]+dp[i-j]);
                
            }
        }
        return dp[n];
    }
}