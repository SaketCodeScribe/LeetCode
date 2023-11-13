public class Solution {
	private static final int MOD = (int)Math.pow(10, 9)+7;
	public static int countPartitions(int n, int d, int[] arr) {
		int sum, i, j;
    	sum = Arrays.stream(arr).reduce(0, (tot,ele) -> tot+ele)+d;
    	if ((sum & 1) > 0)
    		return 0;
    	sum /= 2;
    	long[] dp = new long[sum+1];
    	dp[0] = 1;
    	
    	for(i=1; i<=n; i++) {
    		long[] temp = new long[sum+1];
    		for(j=0; j<=sum; j++)
    			temp[j] = ((j >= arr[i-1] ? dp[j-arr[i-1]] : 0)+dp[j])%MOD;
    		dp = temp;
    	}
    	return (int)dp[sum];
	}
}