```
'''
1.  Time Complexity: O(n*k)
    Space Complexity: O(n*k)
'''
class Solution:
    def maxProfit(self, k: int, prices: List[int]) -> int:
        n, ans = len(prices), 0
        if n== 0 or k == 0:
            return ans
        dp = [[[0,-99999] for i in range(k + 1)] for i in range(n + 1)]
        for i in range(1,n + 1):
            for j in range(1,k + 1):
                dp[i][j][0] = max(max(dp[i - 1][j][0], dp[i - 1][j - 1][0]), prices[i - 1] + dp[i - 1][j][1])
                if j <= i:
                    dp[i][j][1] = max(dp[i - 1][j][1], -prices[i - 1] + dp[i - 1][j - 1][0])
                ans = max(ans, dp[i][j][0])
        return ans
```
```
'''
2.  Time Complexity: O(n*k)
    Space Complexity: O(k)
'''
class Solution:
    def maxProfit(self, k: int, prices: List[int]) -> int:
        n, ans = len(prices), 0
        if n == 0 or k == 0:
            return ans
        buy, sell = [-99999] * (k + 1), [0] * (k + 1)
        for i in range(n):
            for j in range(1,k + 1):
                sell[j] = max(max(sell[j], sell[j - 1]), prices[i] + buy[j])
                if j <= i + 1:
                    buy[j] = max(buy[j], -prices[i] + sell[j - 1])
                ans = max(ans, sell[j])
        return ans
```