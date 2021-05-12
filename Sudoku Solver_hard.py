class Solution:
    def Missingindex(self, matrix: List[List[str]]) -> [int, int]:
        m, n = len(matrix), len(matrix[0])

        for i in range(m):
            for j in range(n):
                if matrix[i][j] == '.':
                    return [i, j]
        return [-1, -1]

    def Valid(self, num: int, x: int, y: int, matrix: List[List[str]]) -> bool:
        m, n = len(matrix), len(matrix[0])

        for i in range(m):
            if matrix[i][y] == str(num):
                return False
        for i in range(n):
            if matrix[x][i] == str(num):
                return False
        m, n = 3 * (x // 3), 3 * (y // 3)
        for i in range(m, m + 3):
            for j in range(n, n + 3):
                if matrix[i][j] == str(num):
                    return False
        return True

    def SolveSudoku(self, matrix: List[List[str]]) -> bool:
        x, y = self.Missingindex(matrix)
        if x == -1:
            return True

        for i in range(1, 10):
            if self.Valid(i, x, y, matrix):
                matrix[x][y] = str(i)
                if self.SolveSudoku(matrix) == False:
                    matrix[x][y] = '.'
                else:
                    return True
        return False

    def solveSudoku(self, board: List[List[str]]) -> None:
        """
        Do not return anything, modify board in-place instead.
        """
        self.SolveSudoku(board)