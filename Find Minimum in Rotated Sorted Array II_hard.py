'''
    Time Complexity: O(n)
    Avg. Time Complexity: O(log n)
    Space Complexity: O(1)
'''
class Solution:
    def findMin(self, nums: List[int]) -> int:
        low, high = 0, len(nums) - 1

        while low <= high:
            mid = low + (high - low) // 2
            if nums[mid] > nums[high]:
                low = mid + 1
            elif nums[mid] < nums[high]:
                high = mid
            elif nums[low] < nums[mid]:
                high = mid - 1
            else:
                high -= 1
        return nums[low]