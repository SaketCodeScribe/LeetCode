#define ll long long int
#define v1 vector<ll>
#define v2 vector<v1>
#define mod 1000000007
class Solution {
public:
    int numRollsToTarget(int d, int f, int target) {
        int i, j, k;
        // 1. O(N^2) space
        // v2 dp(target+1, v1(d+1));
        // for(i=1; i<=target; i++){
        //     for(j=1; j<=d; j++){
        //         for(k=1; k<=f; k++)
        //             dp[i][j] = (i-k==0 && j==1) ? 1 : (i-k>0 && j>1) ? (dp[i][j]%mod+dp[i-k][j-1]%mod)%mod : dp[i][j];
        //     }
        // }
        // return dp[target][d];
        
        // 2. O(N) space
        v1 ways(target+1);
        for(i=1; i<=d; i++){
            v1 new_ways(target+1);
            for(j=1; j<=target; j++){
                for(k=1; k<=f; k++)
                    new_ways[j] = (j-k==0 && i==1) ? 1 : (j-k>0 && i>1) ? (new_ways[j]%mod+ways[j-k]%mod)%mod : new_ways[j];
            }
            ways=new_ways;
        }
        return ways[target];
    }
};