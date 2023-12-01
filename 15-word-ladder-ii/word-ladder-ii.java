class Solution {
    public boolean matchWithDiff(String a, String b){
        int cnt = 0, i;
        for(i=0; i<a.length(); i++)
            if (a.charAt(i) != b.charAt(i))
                cnt++;
        return cnt == 1;
    }
    List<List<String>>  findAllSeq(int lvl, String beginWord, String endWord,  List<String> wordList, Map<String, Integer> vis){
        List<List<String>> ans = new ArrayList<>();
        if (matchWithDiff(beginWord, endWord)){
            ans.add(Arrays.asList(beginWord));
            return ans;
        }
        for(String word:wordList){
            if (vis.getOrDefault(word, -1) == lvl && matchWithDiff(word, endWord)){
                for (List<String> vals : findAllSeq(lvl-1, beginWord, word, wordList, vis)) {
                    List<String> currentSeq = new ArrayList<>(vals);
                    currentSeq.add(word);
                    ans.add(currentSeq);
                }
            }
        }
        return ans;
    }
    public List<List<String>> findLadders(String beginWord, String endWord, List<String> wordList) {
        int i, size, lvl = 0;
        String node, str;
        List<List<String>> ans = new ArrayList<>();
        if(!wordList.contains(endWord))
            return ans;
        else if (beginWord.equals(endWord) && wordList.contains(endWord)){
            ans.add(Arrays.asList(beginWord));
            return ans;
        }
        Map<String, Integer> vis = new HashMap<>();
        Queue<String> queue = new LinkedList<>();
        char[] chars = "abcdefghijklmnopqrstuvwxyz".toCharArray();
        vis.put(beginWord, 0);
        queue.add(beginWord);
        while (queue.size() > 0){
            size = queue.size();
            lvl++;
            while(size-- > 0){
                node = queue.poll();
                for(i=0; i<node.length(); i++){
                    for(char ch : chars){
                        str = node.substring(0,i)+ch+node.substring(i+1);
                        if (vis.get(str) == null && wordList.contains(str)){
                            queue.add(str);
                            vis.put(str, lvl);
                        }
                    }
                }
            }
            if (vis.get(endWord) != null)
                break;
        }
        for (List<String> vals : findAllSeq(lvl-1, beginWord, endWord, wordList, vis)) {
            List<String> currentSeq = new ArrayList<>(vals);
            currentSeq.add(endWord);
            ans.add(currentSeq);
        }
        return ans;
    }
}