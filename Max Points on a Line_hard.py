'''
    Time Complexity : O(log(max(x,y))*n^2)
    Space Complexity: O(n)
'''
class Solution:
    def findgcd(self, a, b) -> int:
        if b == 0:
            return a
        return self.findgcd(b, a % b)

    def maxPoints(self, points: List[List[int]]) -> int:
        n, ans, dic = len(points), 1, Counter()

        for i in range(n):
            dic = Counter()
            for j in range(i + 1, n):
                a, b = points[j][1] - points[i][1], points[j][0] - points[i][0]
                sign = 1 if b == 0 else (a // abs(a) if a != 0 else 1) * (b // abs(b) if b != 0 else 1)
                gcd = self.findgcd(abs(a), abs(b))
                slope = (sign * abs(a) // gcd, abs(b) // gcd)
                dic[slope] += 1
                ans = max(ans, dic[slope] + 1)
        return ans