#define ll long long int
#define v vector<ll>
#define fr(i,a,b) for(i=a; i<=b; i++)

class Solution {
public:
    ll prev, mx_day;
    void calc(v& dp, ll start, ll day, ll cost){
        ll i;
        fr(i,start,start+day){
            if(i>=mx_day)
                break;
            dp[i]=min(dp[i], dp[prev]+cost);
        }
    }
    int mincostTickets(vector<int>& days, vector<int>& costs) {
        ll i, j, n=days.size();
        mx_day=days[n-1]+1;
        prev=0;
        v dp(mx_day, INT_MAX), arr={0, 6, 29};
        dp[0]=0;
        for(auto d:days){
            fr(j,0,2){
                calc(dp, d, arr[j], costs[j]);
            }
            prev=d;
        }
        return dp[days[n-1]];
    }
};