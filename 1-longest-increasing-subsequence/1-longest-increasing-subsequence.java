class Solution {
    public int lengthOfLIS(int[] nums) {
        int n = nums.length, i, j, ans = 1;
        int[] dp = new int[n];
        Arrays.fill(dp, 1);

        for(i=1; i<n; i++){
            for(j=0; j<i; j++)
                if (nums[i] > nums[j])
                    dp[i] = Math.max(dp[i], dp[j]+1);
                ans = Math.max(ans, dp[i]);
        }
        return ans;
    }
}