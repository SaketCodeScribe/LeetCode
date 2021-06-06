'''
    1. Time Complexity: O(n)
       Space Complexity: O(n)
'''
class Solution:
    def longestConsecutive(self, nums: List[int]) -> int:
        ans = 0
        mp = Counter()
        for num in nums:
            mp[num] = 1
        for key in mp.keys():
            var = key + 1
            while mp[var]:
                mp[key] += mp[var]
                if mp[var] > 1:
                    break
                mp[var] = 0
                var += 1
            ans = max(ans, mp[key])
        return ans
'''
    2. Time Complexity: O(n)
       Space Complexity: O(n)
'''
class Solution:
    def longestConsecutive(self, nums: List[int]) -> int:
        ans = 0
        mp = Counter()
        for num in nums:
            mp[num] = 1
        for key in mp.keys():
            if mp[key - 1] == 0:
                var = key + 1
                while mp[var]:
                    mp[key] += mp[var]
                    if mp[var] > 1:
                        break
                    var += 1
            ans = max(ans, mp[key])
        return ans