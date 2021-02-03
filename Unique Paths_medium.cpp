#define ll long long int
#define v1 vector<ll>
#define v2 vector<v1>
class Solution {
public:
    int uniquePaths(int m, int n) {
        ll i, j;
        v2 dp(m+1, v1(n+1));\
        for(i=1; i<=m; i++){
            for(j=1; j<=n; j++){
                dp[i][j] = (i==1 && j==1)? 1 : ((j-1>0 ? dp[i][j-1] : 0) + (i-1>0 ? dp[i-1][j] : 0));
            }
        }
        return dp[m][n];
    }
};