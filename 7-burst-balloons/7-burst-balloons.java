class Solution {
    public int maxCoins(int[] nums) {
        int i, j, k, n = nums.length;
        int[][] dp = new int[n][n];

        for(i=0; i<n; i++){
            for(j=i; j>=0; j--){
                if (i==j)
                    dp[j][i] = (i == 0 ? 1:nums[i-1])*nums[i]*(i == n-1 ? 1: nums[i+1]);
                else{
                    for(k=j; k<=i; k++)
                        dp[j][i] = Math.max(dp[j][i],(j == k ? 0 : dp[j][k-1])+(i == k ? 0 : dp[k+1][i])+(j == 0 ? 1 : nums[j-1])*nums[k]*(i == n-1 ? 1 : nums[i+1]));
                }
            }
        }
        return dp[0][n-1];
    }
}