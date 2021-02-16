#define ll long long int
#define v vector<ll>
class Solution {
public:
    int combinationSum4(vector<int>& nums, int target) {
        ll i, j, n=nums.size();
        v dp(target+1);
        dp[0]=1;
        for(i=1; i<=target; i++){
            for(j=0; j<n; j++)
                dp[i] = i-nums[j]>=0 && dp[i]<=INT_MAX && dp[i-nums[j]]<=INT_MAX ? dp[i-nums[j]]+dp[i] : dp[i];
        }
        return dp[target];
    }
};