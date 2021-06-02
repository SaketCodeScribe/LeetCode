'''
    1. Time Complexity: O(lmn)
       Space Complexity: O(lmn)
'''


class Solution:
    def isInterleave(self, s1: str, s2: str, s3: str) -> bool:
        l, m, n = len(s3), len(s1), len(s2)
        dp = [[[False for i in range(l + 1)] for i in range(n + 1)] for i in range(m + 1)]

        dp[0][0][0] = True
        for lg in range(1, l + 1):
            for i in range(m + 1):
                for j in range(n + 1):
                    if i > 0 and j > 0 and i + j == lg:
                        if s3[lg - 1] == s1[i - 1] and s1[i - 1] == s2[j - 1]:
                            dp[i][j][lg] = dp[i - 1][j][lg - 1] or dp[i][j - 1][lg - 1]
                        else:
                            dp[i][j][lg] = ((s1[i - 1] == s3[lg - 1]) and dp[i - 1][j][lg - 1]) or (
                                        (s2[j - 1] == s3[lg - 1]) and dp[i][j - 1][lg - 1])
                    elif i == lg:
                        dp[i][j][lg] = (s1[i - 1] == s3[lg - 1]) and dp[i - 1][j][lg - 1]
                    elif j == lg:
                        dp[i][j][lg] = (s2[j - 1] == s3[lg - 1]) and dp[i][j - 1][lg - 1]
        return dp[m][n][l]


'''
    1. Time Complexity: O(mn)
       Space Complexity: O(mn)
'''


class Solution:
    def isInterleave(self, s1: str, s2: str, s3: str) -> bool:
        l, m, n = len(s3), len(s1), len(s2)
        if l != m + n:
            return False
        dp = [[False for i in range(n + 1)] for i in range(m + 1)]

        for i in range(m + 1):
            for j in range(n + 1):
                if i == 0 and j == 0:
                    dp[i][j] = True
                elif j == 0:
                    dp[i][j] = (s1[i - 1] == s3[i - 1]) and dp[i - 1][j]
                elif i == 0:
                    dp[i][j] = (s2[j - 1] == s3[j - 1]) and dp[i][j - 1]
                else:
                    if s3[i + j - 1] == s1[i - 1] and s1[i - 1] == s2[j - 1]:
                        dp[i][j] = dp[i - 1][j] or dp[i][j - 1]
                    else:
                        dp[i][j] = ((s1[i - 1] == s3[i + j - 1]) and dp[i - 1][j]) or (
                                    (s2[j - 1] == s3[i + j - 1]) and dp[i][j - 1])
        return dp[m][n]