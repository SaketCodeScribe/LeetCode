class Solution {
    public int findNumberOfLIS(int[] nums) {
        int i, j, n = nums.length, lis = 1, ans = 1;
        int[] dp = new int[n];
        int[] freq = new int[n];
        Arrays.fill(dp,1);
        Arrays.fill(freq,1);

        for(i=1; i<n; i++){
            for(j=0; j<i; j++){
                if (nums[i] > nums[j]){
                    if (dp[i] < dp[j]+1){
                        dp[i] = dp[j]+1;
                        freq[i] = freq[j];
                    }
                    else if (dp[i] == dp[j]+1)
                        freq[i] += freq[j];
                }
            }
            if (dp[i] == lis){
                ans += freq[i];
            }
            else if (dp[i] > lis){
                lis = dp[i];
                ans = freq[i];
            }
        }
        return ans;
    }
}