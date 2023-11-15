class Solution {
    private final int MOD = (int)Math.pow(10,9)+7;
    public int numWays(String[] words, String target) {
        int m = target.length(), n = words[0].length(), o = words.length, i, j, k;
        long[] dp = new long[n+1];
        int[][] charOcc = new int[n+1][26];

        for(i=1; i<=n; i++){
            for(String word:words)
                charOcc[i][word.charAt(i-1)-'a']++;
        }

        for(i=0; i<=m; i++){
            long[] temp = new long[n+1];
            for(j=0; j<=n; j++){
                if (i == 0)
                    temp[j] = 1;
                else if (j > 0){
                    temp[j] = (charOcc[j][target.charAt(i-1)-'a']*dp[j-1]+temp[j-1])%MOD;
                }
            }
            dp = temp;
        }
        return (int)dp[n];
    }
}