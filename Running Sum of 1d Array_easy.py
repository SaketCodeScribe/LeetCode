'''
    Time: O(n)
    Space: O(n)
'''
class Solution:
    def runningSum(self, nums: List[int]) -> List[int]:
        ans = []

        for i, elt in enumerate(nums):
            if i == 0:
                ans.append(elt)
                continue
            ans.append(elt + ans[i - 1])
        return ans