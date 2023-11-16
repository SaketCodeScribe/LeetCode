class Solution {
    private final int MOD = -(int)Math.pow(10,9)+7;
    public int maxProfit(int[] prices, int fee) {
        int i, n = prices.length, buy = MOD, sell = 0;

        for(i=0; i<n; i++){
            buy = Math.max(buy, sell-prices[i]);
            sell = Math.max(sell, buy+prices[i]-fee);
        }
        return sell;
    }
}