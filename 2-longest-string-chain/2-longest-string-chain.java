class Solution {
    public int longestStrChain(String[] words) {
        int i, j, n = words.length, ans = 1;
        Map<String, Integer> map  = new HashMap<String, Integer>();
        Arrays.sort(words, (a,b) -> a.length()-b.length());

        for(i=0; i<n; i++){
            int best = 1;
            for(j=0; j<words[i].length(); j++){
                String word = words[i].substring(0,j)+words[i].substring(j+1);
                best = Math.max(best, map.getOrDefault(word,0)+1);
            }
            map.put(words[i],best);
            ans = Math.max(ans, best);
        }
        return ans;
    }
}