class Solution {
    public int longestPalindromeSubseq(String s) {
        int i, j, n = s.length();
        int[] dp = new int[n], temp;

        for(i=0; i<n; i++){
            temp = new int[n];
            for(j=i; j>=0; j--){
                if (i == j)
                    temp[j] = 1;
                else if (s.charAt(i) == s.charAt(j))
                    temp[j] = dp[j+1]+2;
                else
                    temp[j] = Math.max(temp[j+1], dp[j]);
            }
            dp = temp;
        }
        return dp[0];
    }
}