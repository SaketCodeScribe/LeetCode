class Solution {
public:
    string longestPalindrome(string s) {
        int i, j, k, n=s.size();
        string aux="", ans="";
        for(i=0; i<n; i++){
            for(j=i-1, k=i+1; j>=0 && k<n;){
                if(s[j]==s[k]){
                    j--;
                    k++;
                }
                else 
                    break;
            }
            aux=s.substr(min(j+1,n-1), min(k-j-1,n));
            if(ans.size()<aux.size())
                ans=aux;
            for(j=i, k=i+1; j>=0 && k<n;){
                if(s[j]==s[k]){
                    j--;
                    k++;
                }
                else 
                    break;
            }
            aux=s.substr(min(j+1,n-1), min(k-j-1,n));
            if(ans.size()<aux.size())
                ans=aux;
        }
        return ans;
    }
};