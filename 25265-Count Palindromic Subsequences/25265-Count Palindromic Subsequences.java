class Solution
{
    private final int MOD = (int)Math.pow(10,9)+7;
    long countPS(String str){
        int n = str.length(), i, j;
        long[][] dp = new long[n][n];
        
        for(i=0; i<n; i++){
            for(j=i; j>=0; j--){
                if (i==j)
                    dp[j][i] = 1;
                else{ 
                    if(str.charAt(j) ==  str.charAt(i))
                        dp[j][i] =  (j <= i-2 ? dp[j+1][i-1] : 0)+1;
                    dp[j][i] = (dp[j][i]+dp[j][i-1]+dp[j+1][i]-(j <= i-2 ? dp[j+1][i-1] : 0)+MOD)%MOD;
                }
            }
        }
        return dp[0][n-1];
    }
}