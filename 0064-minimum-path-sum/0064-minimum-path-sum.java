class Solution {
    public int minPathSum(int[][] grid) {
        int i, j, m = grid.length, n = grid[0].length;
        int[] dp, temp;
        dp = new int[n+1];
        Arrays.fill(dp, Integer.MAX_VALUE);
        for(i=0; i<m; i++) {
            temp = new int[n+1];
            Arrays.fill(temp, Integer.MAX_VALUE);
        	for(j=1; j<=n; j++) {
                if (i == 0 && j == 1)
                    temp[j] = grid[i][j-1];
                else
        		    temp[j] = grid[i][j-1] + Math.min(dp[j], temp[j-1]);
            }
            dp = temp;
        }
        return dp[n];
    }
}