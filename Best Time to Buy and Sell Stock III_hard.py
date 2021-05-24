'''
    Time: O(k*n)
    Space: (k*n)
'''
class Solution:
    def maxProfit(self, prices: List[int]) -> int:
        n = len(prices)
        dp = [[[0 for i in range(2)] for i in range(n)] for i in range(3)]

        for k in range(1, 3):
            for i in range(n):
                if i == 0 and k == 1:
                    dp[k][i][1] = -prices[i]
                elif i == 0 and k == 2:
                    continue
                elif i == 1 and k == 2:
                    dp[k][i][0] = dp[k - 1][i][0]
                elif i == 2 and k == 2:
                    dp[k][i][1] = dp[k - 1][i - 1][0] - prices[i]
                    dp[k][i][0] = dp[k - 1][i][0]
                else:
                    dp[k][i][0] = max(dp[k][i - 1][1] + prices[i], max(dp[k - 1][i][0], dp[k][i - 1][0]))
                    dp[k][i][1] = max(dp[k][i - 1][1], dp[k - 1][i - 1][0] - prices[i])
        return dp[2][n - 1][0]