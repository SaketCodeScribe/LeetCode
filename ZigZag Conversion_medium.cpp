class Solution {
public:
    string convert(string s, int nR) {
        if (nR == 1)
            return s;
        
        int i, prev, r, n = s.size();
        string ans = "";
        
        i = prev = 0;
        r = 1;
        ans.push_back(s[0]);
        while (ans.size() < n){
            if (i >= n){
                i = ++prev;
                ans.push_back(s[i]);
                r++;
            }
            
            i = nR - r > 0 ? i + (nR - r) * 2 : i;
            if (nR - r > 0 && i < n)
                ans.push_back(s[i]);
            
            i = r - 1 > 0 ? i + (r- 1) * 2 : i;
            if (r - 1 > 0 && i < n)
                ans.push_back(s[i]);
        }
        
        return ans;
    }
};