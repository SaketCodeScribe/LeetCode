'''
    Time Complexity: O(nlogK)
'''
class Solution:
    def maxResult(self, nums: List[int], k: int) -> int:
        n, i = len(nums), 1
        if n == 1:
            return nums[0]

        heap = [[-nums[0], 0]]
        while i < n:
            val, ind = heap[0]
            while i - ind > k:
                heapq.heappop(heap)
                val, ind = heap[0]
            new_val = [val - nums[i], i]
            heapq.heappush(heap, new_val)
            i += 1
        ans = -new_val[0]
        return ans