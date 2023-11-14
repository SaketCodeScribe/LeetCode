class Solution {
    public String shortestCommonSupersequence(String str1, String str2) {
        int i, j, r1, r2, m = str1.length(), n = str2.length();
        int[][] dp = new int[m+1][n+1];
        StringBuilder ans = new StringBuilder();

        for(i=1; i<=m; i++){
            for(j=1; j<=n; j++){
                if (str1.charAt(i-1) == str2.charAt(j-1))
                    dp[i][j] = dp[i-1][j-1]+1;
                else
                    dp[i][j] = Math.max(dp[i][j-1], dp[i-1][j]);
            }
        }
        System.out.println(dp[m][n]);
        i = m;
        j = n;
        r1 = m;
        r2 = n;
        while(i > 0 && j > 0){
            if (str1.charAt(i-1) == str2.charAt(j-1)){
                ans = new StringBuilder(str1.substring(--i,r1)).append(str2.substring(j--,r2)).append(ans);
                r1 = i;
                r2 = j;
            }
            
            else if(dp[i][j-1]>dp[i-1][j])
                j--;
            else
                i--;
        }
        ans = new StringBuilder(str1.substring(0,r1)).append(str2.substring(0,r2)).append(ans);
        return ans.toString();
    }
}