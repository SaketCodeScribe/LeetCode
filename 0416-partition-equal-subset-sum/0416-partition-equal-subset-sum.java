class Solution {
    public boolean canPartition(int[] nums) {
        int sum, n = nums.length, i, j;
        sum = Arrays.stream(nums).reduce(0, (tot,ele) -> tot+ele);
        if ((sum & 1) > 0 )
        	return false;
        sum /= 2;
        boolean[] dp = new boolean[sum+1];
        dp[0] = true;
        
        for(i=1; i<=n; i++) {
        	boolean[] temp = new boolean[sum+1];
        	temp[0] = true;
        	for(j=1; j<=sum; j++)
        		temp[j] = (j >= nums[i-1] ? dp[j-nums[i-1]] : false) || dp[j];
        	dp = temp;
        }
        return dp[sum];
    }
}