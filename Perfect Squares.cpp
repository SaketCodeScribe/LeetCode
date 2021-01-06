#define ll long long int
#define v vector<ll>
#define fr(i,a,b) for(i=a; i<=b; i++)

class Solution {
public:
    int numSquares(int n) {
        ll i, j;
        v dp(n+1, INT_MAX);
        dp[0]=0;
        fr(i,0,n){
            if(dp[i]!=INT_MAX){
                fr(j,1,sqrt(n)){
                    if(i+j*j>n)
                        break;
                    dp[i+j*j]=min(dp[i+j*j], dp[i]+1);
                }
            }
        }
        return dp[n];
    }
};