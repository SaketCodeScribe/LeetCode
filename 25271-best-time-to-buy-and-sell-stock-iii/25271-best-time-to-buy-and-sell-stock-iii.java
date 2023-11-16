class Solution {
    private final int MOD = -(int)Math.pow(10,9)+7;
    public int maxProfit(int[] prices) {
        int i, n = prices.length, s1 = MOD, s2 = MOD, b1 = MOD, b2 = MOD;

        for(i=0; i<n; i++){
            b1 = Math.max(b1, -prices[i]);
            b2 = Math.max(b2, s1-prices[i]);
            s1 = Math.max(s1, b1+prices[i]);
            s2 = Math.max(s2, b2+prices[i]);
        }
        return Math.max(s1, s2);
    }
}