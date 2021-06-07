'''
    Time Complexity: O(n)
    Space Complexity: O(1)
'''
class Solution:
    def minCostClimbingStairs(self, cost: List[int]) -> int:
        n, one_step, two_step, curr_step = len(cost), 0, 0, 0

        for i in range(n + 1):
            curr_step = min(one_step + cost[i - 1], two_step + cost[i - 2]) if i > 1 else 0
            two_step, one_step = one_step, curr_step
        return curr_step