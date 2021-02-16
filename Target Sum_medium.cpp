#define ll long long int
#define v1 vector<ll>
#define v2 vector<v1>
class Solution {
public:
    int findTargetSumWays(vector<int>& nums, int S) {
        ll i, j, n=nums.size();
        if(S>1000)
            return 0;
        v2 dp(n+1, v1(2001));
        dp[0][1000]=1;
        for(i=0; i<n; i++){
            for(j=-1000; j<=1000; j++){
                if(dp[i][j+1000]>0){
                    dp[i+1][j-nums[i]+1000]+=dp[i][j+1000];
                    dp[i+1][j+nums[i]+1000]+=dp[i][j+1000]; 
                }
            }
        }
        return dp[n][S+1000];
    }
};