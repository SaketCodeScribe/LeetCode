#define ll long long int
#define v vector<ll>
#define fr(i,a,b) for(i=a; i<b; i++)
class Solution {
public:
    int minCostClimbingStairs(vector<int>& cost) {
        ll i, n=cost.size();
        v dp(n+2);
        fr(i,3,n+2)
            dp[i]=min(dp[i-1]+cost[i-2], dp[i-2]+cost[i-3]);
        return dp[n+1];
    }
};