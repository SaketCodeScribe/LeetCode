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