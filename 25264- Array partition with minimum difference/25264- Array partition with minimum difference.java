class Solution {
    public static int minSubsetSumDifference(int []nums, int n) {
        int ans, sum, i, j, totsum;
        sum = Arrays.stream(nums).reduce(0, (tot,ele) -> tot+ele);
        boolean[] dp = new boolean[sum+1];
        dp[0] = true;
        
        for(i=1; i<=n; i++) {
        	boolean[] temp = new boolean[sum+1];
        	temp[0] = true;
        	for(j=1; j<=sum; j++)
        		temp[j] = (j >= nums[i-1] ? dp[j-nums[i-1]] : false) || dp[j];
        	dp = temp;
        }
        ans = Integer.MAX_VALUE;
        for(i=0; i<=sum; i++)
            if(dp[i])
                ans = Math.min(ans, Math.abs(2*i-sum));
        return ans;
    }
}