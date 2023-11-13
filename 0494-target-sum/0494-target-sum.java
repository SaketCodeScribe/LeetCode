class Solution {
    public int findTargetSumWays(int[] arr, int target) {
        int i, j, sum = Arrays.stream(arr).sum(), n = arr.length;
        sum += 1000;
        if((sum-target)%2 != 0)
            return 0;
            
        sum = (sum-target)/2;
        int len = Math.max(500, sum);
        int dp[] = new int[len+1];
        dp[500] = 1;
        for(i=1; i<=n; i++){
            int[] temp = new int[sum+1];
            for(j=0; j<=sum; j++)
                temp[j] = dp[j]+(arr[i-1]<=j ? dp[j-arr[i-1]] : 0);
            dp = Arrays.copyOf(temp,sum+1);
        }
        return dp[sum];
    }
}