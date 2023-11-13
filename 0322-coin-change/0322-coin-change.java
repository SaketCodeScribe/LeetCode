class Solution {
    private int mod = (int)Math.pow(10,8);
    public int coinChange(int[] coins, int amount) {
        int i, j, n = coins.length;
        int[] dp = new int[amount+1];
        Arrays.fill(dp,mod);

        dp[0] = 0;
        for(i=1; i<=n; i++){
            int[] temp = new int[amount+1];            
            Arrays.fill(temp,mod);
            for(j=0; j <= amount; j++)
                temp[j] = Math.min(dp[j],coins[i-1]<=j?temp[j-coins[i-1]]+1:mod);
            dp = Arrays.copyOf(temp,amount+1);
        }
        return dp[amount] < mod ? dp[amount] : -1;
    }
}