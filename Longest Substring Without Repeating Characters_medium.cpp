#define ll long long int
#define map unordered_map<char, int>

class Solution {
public:
    int lengthOfLongestSubstring(string s) {
        ll start, end, n=s.size(), ans=0;
        map ch={};
        start=end=0;
        while(end<n){
            while(end<n){
                if(!ch[s[end]]){
                    ch[s[end]]++;
                    end++;
                }
                else{
                    ans=max(ans, end-start);
                    break;
                }
            }
            while(end<n && start<end){
                if(s[start]!=s[end]){
                    ch[s[start]]--;
                    start++;
                }
                else{
                    ch[s[start]]=0;
                    start++;
                    break;
                }
            }
        }
        ans=max(ans, end-start);
        return ans;
    }
};