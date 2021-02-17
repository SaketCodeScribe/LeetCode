#define ll long long int
#define v1 vector<ll>
#define v2 vector<v1>
#define pp pair<int, int>
#define vp vector<pp>
#define mod 1000000007
class Solution {
public:
    vp moves = {
                {1, 2}, {1, -2}, {-1, 2}, {-1, -2},
                {2, 1}, {2, -1}, {-2, 1}, {-2, -1}
               };
    int knightDialer(int n) {
        ll i, j, k, ans=0;
        if(n==1)
            return 10;
        v2 dp(4, v1(3));
        for(i=1; i<=n; i++){
            v2 temp(4, v1(3));
            temp[3][0]=temp[3][2]=LLONG_MAX;
            for(j=0; j<4; j++){
                for(k=0; k<3; k++){
                    if(i==1){
                        temp[j][k] = (j==3 && (k==2 || !k)) ? temp[j][k] : 1;
                        continue;
                    }
                    if(dp[j][k]!=LLONG_MAX){
                        for(auto p:moves){
                            ll x=j+p.first, y=k+p.second;
                            if(x<0 || x>3 || y<0 || y>2 || (x==3 && (y==2 || !y))) 
                                continue;
                            temp[x][y]=(temp[x][y]%mod+dp[j][k]%mod)%mod;
                        }
                    }
                }
            }
            dp=temp;
        }
         for(i=0; i<4; i++){
            for(j=0; j<3; j++){
                if(dp[i][j]!=LLONG_MAX)
                    ans=(ans%mod+dp[i][j]%mod)%mod;
            }
         }
        return ans;
    }
};