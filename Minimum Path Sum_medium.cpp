#define ll long long int
#define v2 vector<vector<ll>>
#define v1 vector<ll>
#define vp vector<pair<int, int>>
#define fr(i,a,b) for(i=a; i<b; i++)

class Solution {
public:
    vp moves={
              {0,1}, 
              {1,0}
             };
    
    int minPathSum(vector<vector<int>>& grid) {
        ll i, j, m=grid.size(), n=grid[0].size(), x, y;
        v2 dp(m, v1(n, LLONG_MAX));
        dp[0][0]=grid[0][0];
        fr(i,0,m){
            fr(j,0,n){
                if(dp[i][j]!=LLONG_MAX){
                    for(auto p:moves){
                        x=i+p.first;
                        y=j+p.second;
                        if(x>=0 && y>=0 && x<m && y<n)
                            dp[x][y]=min(dp[x][y], dp[i][j]+grid[x][y]);
                    }      
                }
            }
        }
        return dp[m-1][n-1];
    }
};