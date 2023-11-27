class Solution {
    public int countSquares(int[][] matrix) {
        int i, j, m = matrix.length, n = matrix[0].length, ans = 0;
        int[][] dp = new int[m][n];

        for(i=0; i<n; i++){
            dp[0][i] = matrix[0][i];
            ans += dp[0][i];
        }
        for(i=1; i<m; i++){
            dp[i][0] = matrix[i][0];
            ans += dp[i][0];
        }
        for(i=1; i<m; i++){
            for(j=1; j<n; j++){
                if (matrix[i][j] == 1)
                    dp[i][j] = Math.min(dp[i][j-1], Math.min(dp[i-1][j], dp[i-1][j-1]))+1;
                ans += dp[i][j];
            }
        }
        return ans;
    }
}