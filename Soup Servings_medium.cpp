#define d double
#define v1 vector<d>
#define v2 vector<vector<d>>
class Solution {
public:
    double soupserve(v2& dp, int n, int x, int y){
        double ans=0.0;
        if(!x && !y)
            return 0.5;
        if(!x && y)
            return 1.0;
        if(!y)
            return 0.0;
        if(dp[x][y]!=-1)
            return dp[x][y];
        return dp[x][y]= 0.25*(soupserve(dp, n, max(x-4,0),y)+soupserve(dp, n, max(x-3,0),max(y-1,0))+soupserve(dp, n, max(x-2,0),max(y-2,0))+soupserve(dp, n, max(x-1,0),max(y-3,0)));
    }
    double soupServings(int N) {
        v2 dp(200, v1(200, -1));
        return N>4800 ? 1 : soupserve(dp, N, (N+24)/25, (N+24)/25);    
    }
};