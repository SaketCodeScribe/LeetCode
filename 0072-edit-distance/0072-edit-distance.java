class Solution {
    public int minDistance(String str1, String str2) {
        int i, j, m = str1.length(), n = str2.length();
        int[] dp = new int[n+1], temp = new int[n+1];
        
        for(i=0; i<=m; i++){
            temp = new int[n+1];
            for(j=0; j<=n; j++){
                if (i == 0 || j == 0)
                    temp[j] = i+j;
                else if (str1.charAt(i-1) == str2.charAt(j-1))
                    temp[j] = dp[j-1];
                else
                    temp[j] = Math.min(dp[j-1], 
                                Math.min(dp[j], temp[j-1]))+1;
            }
            dp = temp;
        }
        return dp[n];
    }
}