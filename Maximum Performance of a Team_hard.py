'''
    Time: O(n(logn + logk))
    Space: O(n + k)
'''
class Solution:
    def maxPerformance(self, n: int, speed: List[int], efficiency: List[int], k: int) -> int:
        sum_, ans = 0, 0
        heap, pairlist = [], zip(efficiency, speed)

        pairlist = sorted(pairlist, key=lambda x: x[0], reverse=True)
        for val in pairlist:
            if len(heap) >= k:
                mi = heapq.heappop(heap)
                sum_ -= mi
            heapq.heappush(heap, val[1])
            sum_ += val[1]
            ans = max(ans, sum_ * val[0])
        return ans % (10 ** 9 + 7)