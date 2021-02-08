#define ll long long int
#define v1 vector<ll>
#define v2 vector<v1>
#define mod 1000000007
class Solution {
public:
    int numRollsToTarget(int d, int f, int target) {
        int i, j, k;
        v2 dp(target+1, v1(d+1));
        for(i=1; i<=target; i++){
            for(j=1; j<=d; j++){
                for(k=1; k<=f; k++)
                    dp[i][j] = (i-k==0 && j==1) ? 1 : (i-k>0 && j>1) ? (dp[i][j]%mod+dp[i-k][j-1]%mod)%mod : dp[i][j];
            }
        }
        return dp[target][d];
    }
};