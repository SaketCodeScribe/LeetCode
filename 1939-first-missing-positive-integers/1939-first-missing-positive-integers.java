import java.util.* ;
import java.io.*; 
public class Solution {
	public static int firstMissing(int[] arr, int n) {
		int i;
		for(i=0; i<n; i++){
			if (arr[i] <= 0 || arr[i] > n)
				arr[i] = n+1;
		}	

		for(i=0; i<n; i++){
			if (Math.abs(arr[i]) <= n)
				arr[Math.abs(arr[i])-1] = -Math.abs(arr[Math.abs(arr[i])-1]);
		}	
		for(i=0; i<n; i++){
			if (arr[i] > 0)
				return i+1;
		}
		return n+1;
	}
}
