#define vs vector<string>
#define ll long long int
#define pb push_back
#define pob pop_back
#define fr(i,a,b) for(ll i=a; i<b; i++)

class Solution {
public:
    vs res={}, map={"", "", "abc", "def", "ghi", "jkl",
                "mno", "pqrs", "tuv", "wxyz"};
    
    void letterComb(int x, string& dig, string& aux){
        if(aux.size()==dig.size()){
            res.pb(aux);
            return;
        }
        ll i, j, ind;
        fr(i, x, dig.size()){
            ind=dig[i]-'0';
            fr(j, 0, map[ind].size()){
                aux.pb(map[ind][j]);
                letterComb(i+1, dig, aux);
                aux.pob();
            }
        }
        return;
    }
    
    vector<string> letterCombinations(string digits) {
        if(!digits.size())
            return {};
        string aux="";
        res={};
        letterComb(0, digits, aux);
        return res;
    }
};