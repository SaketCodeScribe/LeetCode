class Solution {
    private static final int MOD = (int)Math.pow(10,9);
    public int minCost(int n, int[] cuts) {
        int i, j, k, m = cuts.length;
        int[] arr = new int[m+2];
        for(i=0; i<m; i++)
            arr[i+1] = cuts[i];
        m = arr.length;
        arr[m-1] = n;
        int[][] dp = new int[m-1][m-1];
        Arrays.stream(dp).forEach(array -> Arrays.fill(array, MOD));
        Arrays.sort(arr);
        for(i=1; i<m-1; i++){
            for(j=i; j>0; j--){
                if (i == j)
                    dp[j][i] = arr[i+1]-arr[j-1];
                else{
                    for(k=j; k<=i ; k++)
                        dp[j][i] = Math.min(dp[j][i], (j == k ? 0 : dp[j][k-1])+(i == k ? 0 : dp[k+1][i])+arr[i+1]-arr[j-1]);
                }
            }
        }
        return dp[1][m-2];
    }
}