'''
    1. Time Complexity: O((m+n) * 2^(m+n))
    2. Space COmplexity: O((m+n) * 2^(m+n))
'''
class Solution:
    def __init__(self, ans=None):
        self.ans = []
        self.dict = Counter()

    def Findwords(self, board, temp, vis, i, j, m, n):
        if i < 0 or j < 0 or i >= m or j >= n or vis[i][j] or len(self.dict) == len(self.ans):
            return None

        vis[i][j] = True
        temp = temp + board[i][j]
        if self.dict[temp]:
            self.ans.add(temp)

        self.Findwords(board, temp, vis, i, j + 1, m, n)
        self.Findwords(board, temp, vis, i + 1, j, m, n)
        self.Findwords(board, temp, vis, i, j - 1, m, n)
        self.Findwords(board, temp, vis, i - 1, j, m, n)
        temp = temp[:-1]
        vis[i][j] = False

    def findWords(self, board: List[List[str]], words: List[str]) -> List[str]:
        m, n, temp = len(board), len(board[0]), ''
        self.dict, self.ans = Counter(words), set()
        vis = [[False for i in range(n)] for i in range(m)]

        for i in range(m):
            for j in range(n):
                self.Findwords(board, temp, vis, i, j, m, n)
        return self.ans