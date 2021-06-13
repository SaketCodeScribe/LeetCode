'''
    Time Complexity: O(n^2)
    Space Complexity: O(n^2)
'''
class Solution:
    def __init__(self, dp=None):
        self.dp = None

    def StoneGameVII(self, stones: List[int], total: int, s: int, e: int) -> int:
        if s > e:
            return 0
        if self.dp[s][e] >= 0:
            return self.dp[s][e]
        left_choice, right_choice = self.StoneGameVII(stones, total - stones[s], s + 1, e), \
                                    self.StoneGameVII(stones, total - stones[e], s, e - 1)
        self.dp[s][e] = total - left_choice - stones[s] if left_choice + stones[s] < right_choice + stones[
            e] else total - right_choice - stones[e]
        return self.dp[s][e]

    def stoneGameVII(self, stones: List[int]) -> int:
        n, total = len(stones), 0
        self.dp = [[-1 for i in range(n)] for i in range(n)]

        for stone in stones:
            total += stone
        return self.StoneGameVII(stones, total, 0, n - 1)