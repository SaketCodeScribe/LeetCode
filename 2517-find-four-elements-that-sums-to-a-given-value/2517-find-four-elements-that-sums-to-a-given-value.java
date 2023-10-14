import java.io.*;
import java.util.* ;

public class Solution {
  public static String fourSum(int[] arr, int target, int n) {
      int i, j;
      Map<Integer, int[]> map = new HashMap<>();
      
      for(i=0; i<n; i++){
        for(j=i+1; j<n; j++){
          map.put(arr[i]+arr[j], new int[]{i,j});
        }
      }
      for(i=0; i<n; i++){
        for(j=i+1; j<n; j++){
          if (map.get(target-arr[i]-arr[j]) != null && !checkIndex(map.get(target-arr[i]-arr[j]), new int[]{i,j}))
            return "Yes";
        }
      }
      return "No";
  }

  public static boolean checkIndex(int[] a, int[] b){
    return a[0] == b[0] || a[1] == b[1];
  }
}
