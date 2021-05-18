'''
    1. Using Stack
       Time: O(n)
       Space: O(n)
'''
class Solution:
    def longestValidParentheses(self, s: str) -> int:
        ans = 0
        n = len(s)
        de = deque()

        for i in range(n):
            if s[i] != ')':
                de.append(i)
            else:
                if (len(de) == 0):
                    de.append(i)
                    continue
                if s[de[len(de) - 1]] == '(' and s[i] == ')':
                    de.pop()
                    ans = max(ans, i - de[len(de) - 1]) if len(de) != 0 else max(ans, i + 1)
                else:
                    de.append(i)

        return ans
'''
   2.  Using dp
       Time: O(n)
       Space: O(n)
'''
class Solution:
    def longestValidParentheses(self, s: str) -> int:
        n = len(s)
        dp = [0] * n
        ans = 0

        for i in range(1, n):
            if s[i] == ')' and s[i - 1] == '(':
                dp[i] = dp[i - 2] + 2;
            elif s[i] == ')' and s[i - 1] == ')' and i - dp[i - 1] - 1 >= 0 and s[i - dp[i - 1] - 1] == '(':
                dp[i] = dp[i - 1] + dp[i - dp[i - 1] - 2] + 2;
            ans = max(ans, dp[i])

        return ans