#define ll long long int
#define v1 vector<ll>
#define v2 vector<v1>
class Solution {
public:
    int longestCommonSubsequence(string text1, string text2) {
        ll i, j, m=text1.size(), n=text2.size();
        v2 dp(m+1, v1(n+1));
        for(i=1; i<=m; i++){
            for(j=1; j<=n; j++){
                if(text1[i-1]==text2[j-1])
                    dp[i][j]=dp[i-1][j-1]+1;
                else
                    dp[i][j]=max(dp[i-1][j], dp[i][j-1]);
            }
        }
        return dp[m][n];
    }
};