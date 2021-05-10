class Solution {
public:
    vector<int> findSubstring(string s, vector<string>& words) {
        int n = s.size(), m = words.size(), len = words[0].size(), i, j;
        unordered_map<string,int> wordmap = {}, dict={};
        vector<int> ans = {};
        
        for(auto str:words)
            wordmap[str]++;
        for(i = 0; i <= n - m * len; i++){
            dict = {};
            for(j = 0; j <= m; j++){
                string aux = s.substr(i + j * len, len);
                if(wordmap.count(aux)){
                    dict[aux]++;
                    if(dict[aux] > wordmap[aux])
                        break;
                }
                else
                    break;
            }
            if (j >= m)
                ans.push_back(i);
        }
        return ans;
    }
};