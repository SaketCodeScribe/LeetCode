#define ll long long int
#define v1 vector<ll>
#define v2 vector<vector<ll>>
#define fr(i,a,b) for(i=a; i<b; i++)

class Solution {
public:
    int lastStoneWeightII(vector<int>& stones) {
        ll i, j, sum=0, n=stones.size(), ans=0;
        for(auto elt:stones)
            sum+=elt;
        v2 dp(sum/2+1, v1(n+1));
        fr(i,1,sum/2+1){
            fr(j,1,n+1){
                dp[i][j]=(i-stones[j-1]>=0) ? max(dp[i-stones[j-1]][j-1]+stones[j-1], dp[i][j-1]) : dp[i][j-1];
            }
        }
        return sum-2*dp[sum/2][n];
    }
};