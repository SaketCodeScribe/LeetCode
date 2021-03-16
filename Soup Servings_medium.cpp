#define d double
#define v1 vector<d>
#define v2 vector<vector<d>>
class Solution {
public:
    double soupserve(v2& dp, int x, int y){
        double ans=0.0;
        if(!x && !y)
            return 0.5;
        if(!x && y)
            return 1.0;
        if(!y)
            return 0.0;
        if(dp[x][y]!=-1)
            return dp[x][y];
        return dp[x][y]= 0.25*(soupserve(dp, max(x-4,0),y)+soupserve(dp, max(x-3,0),max(y-1,0))+soupserve(dp, max(x-2,0),max(y-2,0))+soupserve(dp, max(x-1,0),max(y-3,0)));
    }
    double soupServings(int N) {
        if(N>4800)
            return 1.0;
        N=(N+24)/25;
        int i, j;
        v2 dp(200, v1(200, 0));
        /*
        1. top-down approach:
        return soupserve(dp, N, N);
        */
        
        /*
        2. bottom-up approach:
        */
        for(i=0; i<=N; i++){
            for(j=0; j<=N; j++){
                if(!i && !j)
                    dp[i][j]=0.5;
                else if(!i)
                    dp[i][j]=1.0;
                else if(!j)
                    dp[i][j]=0.0;
                else
                    dp[i][j]=0.25*(dp[max(i-4,0)][j]+dp[max(i-3,0)][max(j-1,0)]+dp[max(i-2,0)][max(j-2,0)]+dp[max(i-1,0)][max(j-3,0)]);
            }
        }
        return dp[N][N];
    }
};