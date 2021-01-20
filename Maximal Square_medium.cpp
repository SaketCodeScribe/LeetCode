#define ll long long int
#define v1 vector<ll>
#define v2 vector<v1>
class Solution {
public:
    ll res=0;
    ll maxarea(vector<vector<char>>& mat, v2& dp, int x, int y){
        ll ans=0;
        if(x<0 || y<0)
            return 0;
        if(!x && !y)
            return dp[x][y]=mat[x][y]-'0';
        if(dp[x][y]!=-1)
            return dp[x][y];
        if(mat[x][y]-'0'){
            ans=1;
            if(x-1>=0 && y-1>=0 && mat[x][y-1]-'0' && mat[x-1][y]-'0' && mat[x-1][y-1]-'0'){
                ll side=sqrt(min(min(maxarea(mat, dp, x, y-1), maxarea(mat, dp, x-1, y)), maxarea(mat, dp, x-1, y-1)))+1;
                ans=max(ans, side*side);
            }
        }
        res=max(res, max(max(maxarea(mat, dp, x, y-1), maxarea(mat, dp, x-1, y)), maxarea(mat, dp, x-1, y-1)));
        res=max(res, ans);
        return dp[x][y]=ans;
    }
    ll maximalSquare(vector<vector<char>>& matrix) {
        ll m=matrix.size(), n=matrix[0].size();
        res=0;
        v2 dp(m, v1(n, -1));
        maxarea(matrix, dp, m-1, n-1);
        return max(res, dp[0][0]);
    }
};