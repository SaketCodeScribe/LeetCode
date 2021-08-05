'''
    1. Time Complexity: O((m+n) * 2^(m+n))
       Space COmplexity: O((m+n) * 2^(m+n))
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

    '''
        2. Time Complexity: O(m*n*w)
           Space Complexity: O(w)
    '''
    class TrieNode:
        def __init__(self):
            self.mp = Counter()
            self.is_end = False
    class Trie:
        # def __init__(self,):
        #     self.root = TrieNode()
        # def insert(self, word):
        #     curr = self.root
        #     for char in word:
        #         if curr.mp[char] == 0:
        #             curr.mp[char] = TrieNode()
        #         curr = curr.mp[char]
        #     curr.is_end = True
        def __init__(self, ):
            self.root = None
        def insert(self, word):
            curr = self.root
            for char in word:
                if curr == None:
                    self.root = TrieNode()
                    curr = self.root
                if curr.mp[char] == 0:
                    curr.mp[char] = TrieNode()
                curr = curr.mp[char]
            curr.is_end = True
    class Solution:
        def __init__(self, ans=None):
            self.ans = []
        def search(self, board, vis, trie, temp, i, j, m, n):
            if i < 0 or j < 0 or i >= m or j >= n or board[i][j] == '#' or trie.mp[board[i][j]] == 0:
                return None
            if trie.mp[board[i][j]]:
                char = board[i][j]
                trie = trie.mp[board[i][j]]
                board[i][j] = '#'
            if trie.is_end:
                self.ans.append(temp + char)
                trie.is_end = False
            self.search(board, vis, trie, temp + char, i, j + 1, m, n)
            self.search(board, vis, trie, temp + char, i + 1, j, m, n)
            self.search(board, vis, trie, temp + char, i - 1, j, m, n)
            self.search(board, vis, trie, temp + char, i, j - 1, m, n)
            board[i][j] = char
        def findWords(self, board: List[List[str]], words: List[str]) -> List[str]:
            m, n = len(board), len(board[0])
            self.ans, vis, temp = [], [[False for i in range(n)] for i in range(m)], ''
            trie = Trie()
            for word in words:
                trie.insert(word)
            for i in range(m):
                for j in range(n):
                    self.search(board, vis, trie.root, temp, i, j, m, n)
            return self.ans