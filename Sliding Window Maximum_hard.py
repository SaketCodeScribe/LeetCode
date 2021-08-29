'''
    Time Complexity: O(nlogn)
    Space Complexity: O(n)
'''
class Solution:
    def maxSlidingWindow(self, nums: List[int], k: int) -> List[int]:
        ans, heap, dic = [], [-1 * i for i in nums[:k]], Counter(nums[:k])
        heapq.heapify(heap)
        ans.append(-1 * heap[0])

        for i in range(k, len(nums)):
            dic[nums[i - k]] -= 1
            length = len(heap)
            while (length > 0 and dic[-1 * heap[0]] == 0):
                heapq.heappop(heap)
                length -= 1
            heapq.heappush(heap, -1 * nums[i])
            ans.append(-1 * heap[0])
            dic[nums[i]] += 1
        return ans