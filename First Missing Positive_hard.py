# 1. Stack based solution
class Solution:
    def firstMissingPositive(self, nums: List[int]) -> int:
        n = len(nums)

        for i in range(n):
            if nums[i] <= 0 or nums[i] > n:
                nums[i] = n + 1
        for i in range(n):
            if abs(nums[i]) > n:
                continue
            nums[abs(nums[i]) - 1] = -abs(nums[abs(nums[i]) - 1])
        for i in range(n):
            if nums[i] > 0:
                return i + 1
        return n + 1

#2. DP based solution
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