class Solution {
    private static final int MOD = 1000000007;
    public int countPalindromicSubsequences(String s) {
        int i, j, n = s.length();
        long[][] dp = new long[n][n];

        for(i=0; i<n; i++){
            for(j=i; j>=0; j--){
                if (i==j)
                    dp[j][i] = 1;
                else if(s.charAt(i) == s.charAt(j)){
                    int low = j+1, high = i-1;
                    while (low < i && s.charAt(low) != s.charAt(j))
                        low++;
                    while (high > j && s.charAt(high) != s.charAt(i))
                        high--;
                    dp[j][i] = (2*dp[j+1][i-1]-(low < high ? dp[low+1][high-1] : (low == high ? -1 : -2))+MOD)%MOD;
                }            
                else
                    dp[j][i] = (dp[j+1][i]+dp[j][i-1]-(j+1<=i-1 ? dp[j+1][i-1] : 0)+MOD)%MOD;
            }
        }
        return (int)dp[0][n-1]%MOD;
    }
}