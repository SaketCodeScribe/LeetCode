class Solution {
    private final int MOD = -(int)Math.pow(10,9)+7;
    public int maxProfit(int k, int[] prices) {
        int n = prices.length, i, j;
        int[] buy = new int[k], sell = new int[k];
        Arrays.fill(buy, MOD);
        Arrays.fill(sell, MOD);

        for(i=0; i<n; i++){
            for(j=0; j<k; j++){
                buy[j] = Math.max(buy[j], (j > 0 ? sell[j-1] : 0) -prices[i]);
                sell[j] = Math.max(sell[j], buy[j]+prices[i]);
            }
        }
        return Arrays.stream(sell).max().getAsInt();
    }
}