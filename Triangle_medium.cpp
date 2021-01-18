#define ll long long int
#define v vector<ll>
#define fr(i,a,b) for(i=a; i<b; i++)

class Solution {
public:
    int minimumTotal(vector<vector<int>>& triangle) {
        ll n=triangle.size(), i, j;
        v dp(n, INT_MAX);
        dp[0]=triangle[0][0];
        fr(i,1,n){
            v temp(n, INT_MAX);
            fr(j,0,triangle[i].size())
                temp[j]=j-1>=0 ? min(dp[j-1], dp[j])+triangle[i][j] : dp[j]+triangle[i][j];
            dp=temp;
        }
        return *min_element(dp.begin(), dp.end());
    }
};