'''
    1. Time Complexity: O(n^2)
       Space Complexity: O(n)
'''
class Solution:
    def minRefuelStops(self, target: int, startFuel: int, stations: List[List[int]]) -> int:
        n = len(stations)
        dp = [0 for i in range(n + 1)]

        dp[0] = startFuel
        for i in range(1, n + 1):
            for j in reversed(range(i)):
                if dp[j] >= stations[i - 1][0]:
                    dp[j + 1] = max(dp[j + 1], dp[j] + stations[i - 1][1])
        for i in range(n + 1):
            if dp[i] >= target:
                return i
        return -1