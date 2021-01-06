#define ll long long int
#define v vector<ll>
#define fr1(i,a,b) for(i=a; i<=b; i++)
#define fr2(i,a,b) for(i=a; i>=1; i--)

class Solution {
public:
    int minSteps(int n) {
        ll i, j;
        v dp(n+1);
        fr1(i,2,n){
            fr2(j,i-1,1){
                if(!(i%j)){
                    dp[i]=dp[j]+i/j;
                    break;
                }
            }
        }
        return dp[n];
    }
};