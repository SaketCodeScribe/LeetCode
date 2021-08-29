'''
    Time Complexity: O(log n)
    Space Complexity: O(n)
'''
class Solution:
    def countDigitOne(self, n: int) -> int:
        ans, div, mul = 0, 10, 1
        while n//mul > 0:
            ans += (n//div*mul) + min(max(n%div - mul + 1, 0), mul)
            div *= 10
            mul *= 10
        return ans