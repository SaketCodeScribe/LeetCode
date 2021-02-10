#define d double
#define ll long long int
#define pp pair<int, int>
#define v1 vector<d>
#define v2 vector<v1>
class Solution {
public:
    vector<pp> moves={{2,1},{2,-1},{-2,1},{-2,-1},{1,2},{-1,2},{1,-2},{-1,-2}};
    d knightProbability(int n, int k, int r, int c) {
        ll m, i, j, x, y;
        d ans=0;
        v2 dp(n, v1(n));
        dp[r][c]=1;
        for(m=1; m<=k; m++){
            v2 temp(n, v1(n));
            for(i=0; i<n; i++){
                for(j=0; j<n; j++){
                    if(dp[i][j]){
                        for(auto p:moves){
                            x=i+p.first;
                            y=j+p.second;
                            if(x>=0 && x<n && y>=0 && y<n){
                                temp[x][y]+=dp[i][j]/8.0;
                                
                            }
                        }
                    }
                }
            }
            dp=temp;
        }
        for(auto arr:dp)
            for(auto elt:arr)
                ans+=elt;
        return ans;
    }
};