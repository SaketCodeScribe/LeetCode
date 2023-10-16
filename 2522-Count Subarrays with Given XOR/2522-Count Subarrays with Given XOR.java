import java.io.*;
import java.util.* ;

public class Solution {
	public static int subarraysXor(ArrayList<Integer> arr, int x) {
		int i, ans = 0, n = arr.size();
		Map<Integer, Integer> map = new HashMap<>();
		int[] prefix = new int[n];
		prefix[0] = arr.get(0);
		map.put(0, 1);
		map.put(prefix[0], map.getOrDefault(prefix[0], 0)+1);
		if(prefix[0] == x)
			ans++;

		for(i=1; i<n; i++){
			prefix[i] = arr.get(i)^prefix[i-1];
			if (map.get(x^prefix[i]) != null)
				ans+= map.get(x^prefix[i]);
			map.put(prefix[i], map.getOrDefault(prefix[i], 0) + 1);

		}
		return ans;
	}
}