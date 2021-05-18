'''
    Time: O(m*n)
    Space: O(m*n)
'''
class Solution:
    def minDistance(self, word1: str, word2: str) -> int:
        m, n, ans = len(word1), len(word2), 0
        dp = [[0 for i in range(n + 1)] for i in range(m + 1)]

        for i in range(m + 1):
            for j in range(n + 1):
                if i == 0 and j == 0:
                    continue
                if i == 0 or j == 0:
                    dp[i][j] = max(i, j)
                elif word1[i - 1] == word2[j - 1]:
                    dp[i][j] = dp[i - 1][j - 1]
                else:
                    dp[i][j] = 1 + min(min(dp[i - 1][j - 1], dp[i][j - 1]), dp[i - 1][j])
        return dp[m][n]