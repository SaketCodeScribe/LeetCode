'''
    Time Colmplexity: O(kn)
    Space Complexity: O(kn)
'''
class Solution:
    def maxProfit(self, prices: List[int]) -> int:
        n = len(prices)
        dp = [[[0 for i in range(2)] for i in range(n)] for i in range(3)]
        
        for k in range(1,3):
            for i in range(n):
                if i == 0 and k == 1:
                    dp[k][i][1] = -prices[i]
                elif i == 0 and k == 2:
                    continue
                elif i == 1 and k == 2:
                    dp[k][i][0] = dp[k - 1][i][0]
                elif i == 2 and k == 2:
                    dp[k][i][1] = dp[k - 1][i - 1][0]-prices[i]
                    dp[k][i][0] = dp[k - 1][i][0]
                else:
                    dp[k][i][0] = max(dp[k][i - 1][1] + prices[i], max(dp[k - 1][i][0],dp[k][i - 1][0]))
                    dp[k][i][1] = max(dp[k][i - 1][1], dp[k - 1][i - 1][0] - prices[i])
        return dp[2][n - 1][0]

'''
    More clean and elegant version of above.
'''
class Solution:
    def maxProfit(self, prices: List[int]) -> int:
        n = len(prices)
        dp = [[0 for i in range(n)] for i in range(3)]          
        
        for k in range(1,3):
            buy = -999999
            for i in range(n):
                if i == 0:
                    buy = -prices[i]
                elif k == 2 and i == 1:
                    buy = max(buy, -prices[i])
                    dp[k][i] = dp[k - 1][i] if i > 0 else 0
                else:
                    dp[k][i] = max(buy + prices[i], max(dp[k - 1][i], dp[k][i - 1]))
                    buy = max(buy, dp[k - 1][i - 1] - prices[i])
        return dp[2][n - 1]

'''
    Time Complexity: O(n)
    Space Complexity: O(1)
'''
class Solution:
    def maxProfit(self, prices: List[int]) -> int:
        n, buy1, buy2, sell1, sell2, temp = len(prices), 999999, 999999, 0, 0, 0
        
        for i in range(n):
            buy1 = min(buy1, prices[i])
            sell1 = max(prices[i] - buy1, sell1)
            buy2 = min(buy2, prices[i] - temp)
            sell2 = max(prices[i] - buy2, sell2)
            temp = sell1
        return sell2

'''
    In the above code(3) the purpose of temp is to consider that buying 
    and selling happens on different days but if buying 2nd time and selling 
    1st time happens on same day then for 2nd transaction it may happen that 
    by selling it again on the same day we encounter max profit i.e we are 
    saying by only 1 transaction we can encounter max profit.
'''
class Solution:
    def maxProfit(self, prices: List[int]) -> int:
        n, buy1, buy2, sell1, sell2, temp = len(prices), 999999, 999999, 0, 0, 0
        
        for i in range(n):
            buy1 = min(buy1, prices[i])
            sell1 = max(prices[i] - buy1, sell1)
            buy2 = min(buy2, prices[i] - sell1)
            sell2 = max(prices[i] - buy2, sell2)
        return sell2 