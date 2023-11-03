import java.util.* ;
import java.io.*; 
import java.util.ArrayList;

public class Solution {
    static int subsetOR(ArrayList<Integer> a) {
      int i, j, n = a.size(), m = 0;
      for(Integer val:a)
        m |= val;
      int[] dp = new int[1024];
      Arrays.fill(dp, (int)Math.pow(10,9));
      dp[0] = 0;
      for(i=0; i<=m; i++){
        for(j=1; j<=n; j++)
          dp[i|a.get(j-1)] = Math.min(dp[i|a.get(j-1)], dp[i]+1);
      }
      return dp[m];
    }
}
