#define v1 vector<bool>
#define v2 vector<v1>
class Solution {
public:
    bool isMatch(string s, string p) {
        int i, j, m = s.size(), n = p.size();
        v2 dp(m+1, v1(n+1));
        
        dp[0][0] = true;
        dp[0][1] = p[0] == '.' && m ? true : false;
        for(j = 1; j <= n; j++){
            if(p[j - 1] == '*' || (j < n && p[j] =='*'))
                dp[0][j] = true;
            else 
                break;
        }
        for(i=1; i <= m; i++){
            for(j=1; j <=n; j++){
                if (p[j - 1] == '*')
                    dp[i][j] = (s[i - 1] == p[j - 2]) || p[j - 2] == '.' ? dp[i - 1][j] || dp[i][j-2] : dp[i][j-2];
                else
                    dp[i][j] = (s[i-1] == p[j-1] || p[j - 1] == '.') ? dp[i - 1][j - 1] : false;
            }
        }
        
        return dp[m][n];
    }
};