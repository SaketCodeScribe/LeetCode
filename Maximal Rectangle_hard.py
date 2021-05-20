'''
    Time: O(m+n)
    Space: O(n)
'''
class Solution:
    def MaxRectangle(self, height: List[int], n: int) -> int:
        l, r, ans = [-1] * n, [n] * n, 0
        for i in range(1, n):
            p = i - 1
            while p >= 0 and height[p] >= height[i]:
                p = l[p]
            l[i] = p
        for i in range(n - 2, -1, -1):
            p = i + 1
            while p < n and height[p] >= height[i]:
                p = r[p]
            r[i] = p
        for i in range(n):
            ans = max(ans, height[i] * (r[i] - l[i] - 1))
        return ans

    def maximalRectangle(self, matrix: List[List[str]]) -> int:
        if len(matrix) == 0:
            return 0
        m, n, ans = len(matrix), len(matrix[0]), 0
        height = [0] * n

        for i in range(m):
            for j in range(n):
                if i == 0:
                    height[j] = int(matrix[i][j])
                else:
                    if matrix[i][j] == '1':
                        height[j] += 1
                    else:
                        height[j] = 0
            ans = max(ans, self.MaxRectangle(height, n))
        return ans