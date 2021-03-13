#define ll long long int
#define v1 vector<ll>
#define v2 vector<v1>
#define mod 1000000007
class Solution {
public:
    int dieSimulator(int n, vector<int>& rollmax) {
        ll i, j, k;
        v2 dp(n+1, v1(7));
        dp[0][6]=1;
        for(i=1; i<=n; i++){
            for(j=0; j<6; j++){
                for(k=1; k<=rollmax[j]; k++){
                    if(i-k>=0)
                        dp[i][j]=(dp[i][j]+dp[i-k][6]-dp[i-k][j]+mod)%mod;
                }
                dp[i][6]=(dp[i][6]%mod+dp[i][j]%mod)%mod;
            }
        }
        return dp[n][6];
    }
};