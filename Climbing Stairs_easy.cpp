#define ll long long int
#define v vector<ll>
class Solution {
public:
    ll num_stairs(ll n){
        ll i;
        v dp(n+1);
        dp[1]=dp[0]=1;
        for(i=2; i<=n; i++)
            dp[i]=dp[i-1]+dp[i-2];
        return dp[n];
    }
    ll num_of_stairs(ll n){
        ll i, f=1, s=1, temp;
        for(i=2; i<=n; i++){
            temp=s;
            s+=f;
            f=temp;
        }
        return s;
    }
    int climbStairs(int n) {
        // 1. using dp
        // return num_stairs(n);
        
        // 2. using fib sequence
        return num_of_stairs(n);
    }
};