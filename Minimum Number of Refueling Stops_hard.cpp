#define ll long long int
#define v vector<ll>
#define frinc(i,a,b) for(i=a; i<=b; i++)
#define frdec(i,a,b) for(i=a; i>=b; i--)
class Solution {
public:
    int minRefuelStops(int t, int sf, vector<vector<int>>& st) {
        ll i, j, n=st.size(), prev=sf;
        v dp(n+1, LLONG_MIN);
        dp[0]=sf;
        frinc(i,0,n-1){
            frdec(j,i,0){
                if(dp[j]>=st[i][0])
                    dp[j+1]=max(dp[j+1], dp[j]+st[i][1]);
            }
        }
        frinc(i,0,n){
            if(dp[i]>=t)
                return i;
        }
        return -1;
    }
};