class Solution:
    def Valid(self, queen: List[List[str]], n: int, row: int, col: int) -> bool:
        for i in range(n):
            if queen[i][col] == 'Q':
                return False
        for i in range(col, -1, -1):
            if queen[row][i] == 'Q':
                return False
        for (i, j) in zip(range(row, -1, -1), range(col, -1, -1)):
            if queen[i][j] == 'Q':
                return False
        for (i, j) in zip(range(row, n), range(col, -1, -1)):
            if queen[i][j] == 'Q':
                return False
        return True

    def SolveNQueens(self, ans: List[List[str]], queen: List[List[str]], n: int, col: int) -> List[List[str]]:
        if col >= n:
            ans.append(["".join(queen[i]) for i in range(n)])
            return ans
        for row in range(n):
            if self.Valid(queen, n, row, col):
                queen[row][col] = 'Q'
                self.SolveNQueens(ans, queen, n, col + 1)
                queen[row][col] = '.'
        return ans

    def solveNQueens(self, n: int) -> List[List[str]]:
        ans, queen = [], [['.' for i in range(n)] for i in range(n)]

        return self.SolveNQueens(ans, queen, n, 0)