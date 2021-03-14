#define ll long long int
#define pp pair<int, int>
#define mp map<pp, bool>
#define v1 vector<bool>
#define v2 vector<vector<bool>>
class Solution {
public:
    // mp dp={};     
    // bool isSum(vector<int>& nums, ll i, ll sum, ll tar){
    //     if(i>=nums.size())
    //         return false;
    //     if(sum==tar)
    //         return true;
    //     if(dp.count({sum, i}))
    //         return dp[{sum, i}];
    //     return dp[{sum, i}] = isSum(nums, i+1, sum+nums[i], tar) || isSum(nums, i+1, sum, tar);
    // }
    
    bool canPartition(vector<int>& nums) {
        ll i, j, n=nums.size(), sum=0;
        for(auto elt:nums)
            sum+=elt;
        if(sum&1)
            return false;
        sum/=2;
        /* 1. 
            top down approach:-
        dp={};
        return isSum(nums, 0, 0, sum);
        */
        
        /*
            2.1. bottom up approach Space: O(n*sum):-
        v2 dp(n+1, v1(sum+1));
        for(i=0; i<=n; i++)
            dp[i][0]=true;
        for(i=1; i<=n; i++){
            for(j=1; j<=sum; j++){
                dp[i][j] = j-nums[i-1]>=0 ?  dp[i-1][j] || dp[i-1][j-nums[i-1]] : dp[i-1][j];
            }
        }
        return dp[n][sum];
        */
        
        /*
            2.2. bottom up approach Space: O(sum):-        
        */
        v1 dp(sum+1);
        dp[0]=true;
        for(i=1; i<=n; i++){
            for(j=sum; j>=1; j--){
                dp[j] = j-nums[i-1]>=0 ?  dp[j] || dp[j-nums[i-1]] : dp[j];
            }
        }
        return dp[sum];
    }
};