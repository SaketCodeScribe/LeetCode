#define ll long long int
#define v1 vector<ll>
#define v2 vector<v1>
#define fr(i,a,b) for(i=a; i>=0; i--)
class Solution {
public:
    int calculateMinimumHP(vector<vector<int>>& dungeon) {
        ll i, j, m=dungeon.size(), n=dungeon[0].size(), need;
        v2 dp(m,v1(n, LLONG_MAX));
        dp[m-1][n-1]=dungeon[m-1][n-1]<0 ? 1-dungeon[m-1][n-1] : 1;
        fr(i,m-1,0){
            fr(j,n-1,0){
                if(j-1>=0){
                    need = min(dp[i][j-1], dp[i][j]-dungeon[i][j-1]);
                    dp[i][j-1] = need<=0 ? 1 : need;
                }
                if(i-1>=0){
                    need = min(dp[i-1][j], dp[i][j]-dungeon[i-1][j]);
                    dp[i-1][j] = need<=0 ? 1 : need;
                }
            }
        }
        return dp[0][0];
    }
};