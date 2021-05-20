'''
    1. Using Stack
       Time: O(n)
       Space: O(n)
'''
class Solution:
    def largestRectangleArea(self, heights: List[int]) -> int:
        n, ans, stack = len(heights), 0, []

        for i in range(n):
            m = len(stack)
            if m == 0 or heights[stack[m - 1]] <= heights[i]:
                stack.append(i)
            else:
                while m and heights[stack[m - 1]] > heights[i]:
                    ht = heights[stack.pop()]
                    m = m - 1
                    ans = max(ans, ht * (i - stack[m - 1] - 1) if m > 0 else ht * i)
                stack.append(i)
        m = len(stack)
        while m:
            ht = heights[stack.pop()]
            m = m - 1
            ans = max(ans, ht * (n - stack[m - 1] - 1) if m > 0 else ht * n)
        return ans
'''
   2.  Using dp
       Time: O(n)
       Space: O(n)
'''
class Solution:
    def largestRectangleArea(self, heights: List[int]) -> int:
        n, ans = len(heights), 0
        l_max, r_max = [-1] * n, [n] * n

        for i in range(1, n):
            p = i - 1
            while p >= 0 and heights[p] >= heights[i]:
                p = l_max[p]
            l_max[i] = p
        for i in range(n - 2, -1, -1):
            p = i + 1
            while p < n and heights[p] >= heights[i]:
                p = r_max[p]
            r_max[i] = p
        for i in range(n):
            ans = max(ans, heights[i] * (r_max[i] - l_max[i] - 1))

        return ans