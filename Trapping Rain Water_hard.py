# 1. Stack based solution
class Solution:
    def trap(self, height: List[int]) -> int:
        n = len(height)
        ans = 0
        stack = []

        for i in range(n):
            l = len(stack)
            if l == 0 or height[i] < height[stack[l - 1]]:
                stack.append(i)
            else:
                while (l > 0 and height[stack[l - 1]] <= height[i]):
                    ht = height[stack.pop()]
                    l = l - 1
                    ans = ans + (0 if l == 0 else (min(height[i], height[stack[l - 1]]) - ht) * (i - stack[l - 1] - 1))
                stack.append(i)
        return ans


# 2. DP based solution
class Solution:
    def trap(self, height: List[int]) -> int:
        n = len(height)
        ans = 0
        if n == 0:
            return ans
        l_max, r_max = [0] * n, [0] * n

        mx = height[0]
        for i in range(1, n):
            l_max[i] = mx
            mx = max(mx, height[i])
        mx = height[n - 1]
        for i in range(n - 2, -1, -1):
            r_max[i] = mx
            mx = max(mx, height[i])
        for i in range(n):
            area = min(l_max[i], r_max[i]) - height[i]
            ans = ans + (area if area > 0 else 0)
        return ans