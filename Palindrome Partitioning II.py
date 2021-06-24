'''
	1. Time: O(n^3)
	   Space: O(n^2)
'''
class Solution:
    def minCut(self, s: str) -> int:
        n, ans = len(s), 2000
        dp = [[2000 for i in range(n)] for i in range(n)]

        for l in range(1, n + 1):
            for i in range(n - l + 1):
                for j in range(i, i + l):
                    if l == 1:
                        dp[i][i + l - 1] = 0
                    else:
                        if s[i:j + 1] == s[i + l - 1:j:-1] or s[i:j + 1] == s[i + l - 1:j + 1:-1]:
                            dp[i][i + l - 1] = 0
                            break
                        if dp[i][j] < 2000 and (j + 1 < i + l and dp[j + 1][i + l - 1] < 2000):
                            dp[i][i + l - 1] = min(dp[i][i + l - 1], dp[i][j] + dp[j + 1][i + l - 1] + 1)
            if l == n:
                ans = min(ans, dp[0][n - 1])
        return ans

'''
    2. Time: O(n^2) 
	   Space: O(n^2)
	Rather than creating the solution from l = 1 and going to top, 
	if we know the pallindromes in our string then we can optimize our code by removing one loop.
'''
class Solution:
    def ispalindrome(self, s, rs, n, i, j):
        l = (j - i + 1)
        if s[i:i + l] == rs[n - i - l:n - i]:
            return True
        return False

    def minCut(self, s: str) -> int:
        n, ans, rs = len(s), 2000, s[::-1]
        dp = [[2000 for i in range(n)] for i in range(n)]
        for i in range(n):
            for j in range(i, n):
                if i == j or self.ispalindrome(s, rs, n, i, j):
                    dp[i][j] = 0
        for i in range(n):
            for j in range(i + 1):
                if dp[0][j] < 2000 and (j < i and dp[j + 1][i] < 2000):
                    dp[0][i] = min(dp[0][i], dp[0][j] + dp[j + 1][i] + 1)
        return dp[0][n - 1]