class Solution {
    public int numDistinct(String s, String t) {
        int n = s.length(), m = t.length(), i, j;
        int[] dp = new int[n+1], temp;

        for(i=0; i<=m; i++){
            temp = new int[n+1];
            for(j=0; j<=n; j++){
                if (i == 0)
                    temp[j] = 1;
                else{
                    if (j == 0)
                        continue;
                    temp[j] = temp[j-1];
                    if (s.charAt(j-1) == t.charAt(i-1))
                        temp[j] += dp[j-1];
                }
            }
            dp = temp;
        }
        return dp[n];
    }
}