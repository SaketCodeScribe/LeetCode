class Solution {
    public boolean isMatch(String s, String p) {
        int m = s.length(), n = p.length(), i, j;
        boolean[] dp = new boolean[n+1], temp;
        i = 0;
        while (i<=n && (i == 0 || p.charAt(i-1) == '*'))
            dp[i++] = true;
        for(i=1; i<=m; i++){
            temp = new boolean[n+1];
            for(j=1; j<=n; j++){
                if (p.charAt(j-1) == '?' || p.charAt(j-1) == s.charAt(i-1))
                    temp[j] = dp[j-1];
                else if (p.charAt(j-1) == '*')
                    temp[j] = dp[j] || temp[j-1];
            }
            dp = temp;
        }
        return dp[n];
    }
}