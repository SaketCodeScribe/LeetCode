class Solution {
    private static final int MOD = (int)Math.pow(10,4);
    public int longestWPI(int[] hours) {
    	int ans=0, i, n = hours.length;
    	int[] preSum = new int[n+1];
    	int[] mark = new int[(int) (2*MOD+1)];
    	Arrays.fill(mark,  Integer.MAX_VALUE);
        mark[0] = 0;
    	preSum[1] = hours[0] > 8 ? 1 : -1;
    	mark[MOD+preSum[1]] = 1;
        ans = preSum[1] > 0 ? 1 : 0;
    	for(i=2; i<=n; i++) {
    		preSum[i] = preSum[i-1]+(hours[i-1] > 8 ? 1 : -1);
    		if (preSum[i] > 0)
    			ans = i;
    		else
    			ans = Math.max(ans, i-mark[MOD+preSum[i]-1]);
    		mark[MOD+preSum[i]] = Math.min(i, mark[MOD+preSum[i]]);
    	}
        return ans;
    }
}