'''
    Time Complexity: O(m*n)
    Space Complexity: O(m*n)
'''
class Solution:
    def __init__(self, paths=None, vis=None, area=0):
        self.paths = [[1, 0], [-1, 0], [0, 1], [0, -1]]
        self.vis = vis
        self.area = 0

    def Area(self, grid: List[List[int]], i: int, j: int, m: int, n: int) -> None:
        if i >= m or j >= n or i < 0 or j < 0 or self.vis[i][j] == True or grid[i][j] == 0:
            return None
        self.area += 1
        self.vis[i][j] = True
        for path in self.paths:
            self.Area(grid, i + path[0], j + path[1], m, n)
        return None

    def maxAreaOfIsland(self, grid: List[List[int]]) -> int:
        m, n, ans = len(grid), len(grid[0]), 0
        self.vis = [[False for i in range(n)] for i in range(m)]
        for i in range(m):
            for j in range(n):
                if self.vis[i][j] == False and grid[i][j] == 1:
                    self.area = 0
                    self.Area(grid, i, j, m, n)
                    ans = max(ans, self.area)
        return ans