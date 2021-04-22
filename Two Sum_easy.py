class Solution:
    def twoSum(self, nums: List[int], target: int) -> List[int]:
        dic = {}

        for i in range(len(nums)):
            if dic.get(nums[i]) != None:
                return [dic[nums[i]], i]
            dic[target - nums[i]] = i

        return []