class Solution:
    def maximumGap(self, nums: List[int]) -> int:
        ans, n, mi, mx = 0, len(nums), min(nums), max(nums)
        if n == 1 or mx == mi:
            return ans
        bucket, gap = [[10e9 + 1, -1] for i in range(n)], math.ceil((mx - mi) / (n - 1))

        for val in nums:
            k = (val - mi) // gap
            bucket[k][0], bucket[k][1] = min(bucket[k][0], val), max(bucket[k][1], val)
        prev = bucket[0][1] if bucket[0][1] >= 0 else -1
        for i in range(1, n):
            ans = max(ans, bucket[i][0] - prev) if bucket[i][0] <= 10e9 and prev >= 0 else ans
            prev = bucket[i][1] if bucket[i][1] >= 0 else prev
        return ans