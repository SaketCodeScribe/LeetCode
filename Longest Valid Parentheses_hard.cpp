class Solution {
public:
    int longestValidParentheses(string s) {
        int i, n = s.size(), ans = 0;
        stack<int> st = {};
        
        for(i = 0; i < n; i++){
            if (s[i] != ')')
                st.push(i);
            else{
                if (st.empty()){
                    st.push(i);
                    continue;
                }
                if (s[st.top()] == '(' && s[i] == ')'){
                    st.pop();
                    ans = !st.empty() ? max(ans, i - st.top()) : max(ans, i + 1);
                }
                else
                    st.push(i);
            }
        }
        
        return ans;
    }
};