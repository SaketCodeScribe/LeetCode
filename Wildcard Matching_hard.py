'''
    Time: O(n^2)
    Space: O(n^2)
'''
class Solution:
    def isMatch(self, s: str, p: str) -> bool:
        m, n = len(s), len(p)
        dp = [[False for i in range(m + 1)] for i in range(n + 1)]

        dp[0][0] = True
        for i in range(1, n + 1):
            if (p[i - 1] == '*'):
                dp[i][0] = True
            else:
                break
        for i in range(1, n + 1):
            for j in range(1, m + 1):
                if s[j - 1] == p[i - 1] or p[i - 1] == '?':
                    dp[i][j] = dp[i - 1][j - 1]
                elif p[i - 1] == '*':
                    dp[i][j] = dp[i][j - 1] or dp[i - 1][j]
        return dp[n][m]