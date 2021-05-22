'''
    Time: O(n^4)
    Space: O(n^3)
'''

class Solution:
    def isScramble(self, s1: str, s2: str) -> bool:
        n = len(s1)
        dp = [[[False for i in range(n + 1)] for i in range(n)] for i in range(n)]

        for l in range(1, n + 1):
            for i in range(n - l + 1):
                for j in range(n - l + 1):
                    if l == 1:
                        dp[i][j][l] = s1[i] == s2[j]
                    else:
                        for k in range(1, l):
                            dp[i][j][l] = dp[i][j][l] or ((dp[i][j][k] and dp[i + k][j + k][l - k]) or (
                                        dp[i][j + l - k][k] and dp[i + k][j][l - k]))
                            if dp[i][j][l]:
                                break
        return dp[0][0][n]