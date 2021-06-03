'''
    Time Complexity: O(mlogm + nlogn)
    Space Complexity: O(1)
'''
class Solution:
    def maxArea(self, h: int, w: int, horizontalCuts: List[int], verticalCuts: List[int]) -> int:
        m, n, l, b = len(horizontalCuts), len(verticalCuts), 0, 0

        horizontalCuts.sort()
        verticalCuts.sort()
        l, b = max(horizontalCuts[0], h - horizontalCuts[m - 1]), max(verticalCuts[0], w - verticalCuts[n - 1])
        for i in range(1, m):
            l = max(l, horizontalCuts[i] - horizontalCuts[i - 1])
        for i in range(1, n):
            b = max(b, verticalCuts[i] - verticalCuts[i - 1])
        return (l * b) % (10 ** 9 + 7)