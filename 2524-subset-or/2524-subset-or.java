import java.util.* ;
import java.io.*; 
import java.util.ArrayList;

public class Solution {
    static int subsetOR(ArrayList<Integer> a) {
      int i, j, k=0, n = a.size();
      for(i=0; i<n; i++)
        k |= a.get(i);
      int[][] dp = new int[k+1][n+1];
      Arrays.stream(dp).forEach(arr -> Arrays.fill(arr, Integer.MAX_VALUE));
      
      dp[0][0] = 0;
      for(i=0; i<=k; i++){
        for(j=0; j<n; j++){
          if (dp[i][j] != Integer.MAX_VALUE) {
                    dp[i | a.get(j)][j + 1] = Math.min(dp[i | a.get(j)][j + 1], dp[i][j] + 1);
                    dp[i][j + 1] = Math.min(dp[i][j + 1], dp[i][j]);
          }
        }
      }
      return dp[k][n];
    }
}
