class Solution {
    private final int MOD = -(int)Math.pow(10,9)+7;
    public int maxProfit(int[] prices) {
        int n = prices.length, i, sell = MOD, psell = 0, buy = MOD;

        for(i=0; i<n; i++){
            buy = Math.max(buy, psell-prices[i]);
            psell = Math.max(psell, sell);
            sell = Math.max(sell, buy+prices[i]);
        }
        return sell;
    }
}