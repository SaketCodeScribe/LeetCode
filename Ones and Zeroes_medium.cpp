#define ll long long int
#define v1 vector<ll>
#define v2 vector<v1>
#define v3 vector<vector<v1>>
#define fr(i,a,b) for(i=a; i<b; i++)
class Solution {
public:
    ll unsetbit(string& str){
        ll cnt=0;
        for(auto ch:str){
            if(!(ch-'0'))
                cnt++;
        }
        return cnt;
    }
    int findMaxForm(vector<string>& strs, int m, int n) {
        ll len=strs.size(), i, j, k, ans=0, one_bit, zero_bit;
        v1 arr={};
        v3 dp(len+1, v2(m+1, v1(n+1)));
        for(auto str:strs)
            arr.push_back(unsetbit(str));
        fr(i,1,len+1){
            fr(j,0,m+1){
                fr(k,0,n+1){
                    zero_bit=arr[i-1];
                    one_bit=strs[i-1].size()-zero_bit;
                    dp[i][j][k] = (zero_bit<=j && one_bit<=k) ? max(dp[i-1][j-zero_bit][k-one_bit]+1, dp[i-1][j][k]) : dp[i-1][j][k];
                    ans=max(ans, dp[i][j][k]);
                }
            }
        }
        return ans;
    }
};