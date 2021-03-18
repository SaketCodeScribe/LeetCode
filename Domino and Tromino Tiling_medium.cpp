#define ll long long int
#define v vector<ll>
#define mod 1000000007
class Solution {
public:
    int numTilings(int N) {
        ll i, j;
        v dp(N+1);
        dp[0]=dp[1]=1;
        for(i=2; i<=N; i++)
            dp[i]=(i-3>=0 && i-1>=0) ? (2*dp[i-1]+dp[i-3])%mod : 2*dp[i-1];
        return dp[N];
    }
};