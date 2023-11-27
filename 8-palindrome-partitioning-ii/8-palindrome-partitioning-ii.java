class Solution {
    private final int MOD = (int)Math.pow(10,9);
    public int minCut(String s) {
        int i, j, n = s.length();
        int[] dp = new int[n];
        boolean[][] isPal = new boolean[n][n];
        Arrays.fill(dp, MOD);
        for(i=0; i<n; i++){
            for(j=i; j>=0; j--){
                if (i == j)
                    isPal[j][i] = true;
                else
                    isPal[j][i] = s.charAt(j) == s.charAt(i) && (j < i-1 ? isPal[j+1][i-1] : true);
                if (isPal[j][i])
                    dp[i] = Math.min(dp[i], (j > 0 ? dp[j-1] : -1)+1);
            }
        }
        return dp[n-1];
    }
}