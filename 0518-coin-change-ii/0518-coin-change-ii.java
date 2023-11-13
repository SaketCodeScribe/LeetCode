class Solution {
    public int change(int amount, int[] coins) {
        
        int i, j, n = coins.length;
        int[] dp = new int[amount+1];
        dp[0] = 1;
        for(i=1; i<=n; i++){
            int[] temp = new int[amount+1]; 
            for(j=0; j <= amount; j++)
                temp[j] = dp[j]+(j >= coins[i-1] ?temp[j-coins[i-1]]:0);
            dp = temp;
        }
        return dp[amount];
    }
}