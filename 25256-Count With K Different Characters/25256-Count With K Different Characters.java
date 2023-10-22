import java.util.HashMap;
import java.util.Map;

public class Solution {
    static int atMost(String str, int k){
        int i,j, ans = 0, n = str.length(); 
        Map<Character, Integer> map = new HashMap<>();
        i=j=0;

        while(j<n){
            map.put(str.charAt(j), map.getOrDefault(str.charAt(j), 0) + 1);
            while (map.size() > k){
                map.put(str.charAt(i),map.get(str.charAt(i))-1);
                if (map.get(str.charAt(i++)) == 0)
                    map.remove(str.charAt(i-1));
            }
            ans += j-i+1;
            j++;
        }
        return ans;
    }
    public static int countSubStrings(String str, int k) {
        return atMost(str, k)-atMost(str, k-1);
    }
}

