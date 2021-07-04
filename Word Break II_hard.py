class Solution:
    def __init__(self, ) -> None:
        self.ans = None
        self.dic = None

    def WordBreak(self, s, temp, i, n):
        s1 = []
        if i >= n:
            self.ans.append(''.join(temp[:-1]))
            return None
        while i < n:
            s1.append(s[i])
            if self.dic[''.join(s1)] > 0:
                m = len(s1)
                for j in range(m):
                    temp.append(s1[j])
                temp.append(' ')
                self.WordBreak(s, temp, i + 1, n)
                for j in range(m + 1):
                    temp.pop()
            i += 1
        return None

    def wordBreak(self, s: str, wordDict: List[str]) -> List[str]:
        n, s = len(s), [char for char in s]
        self.ans, self.dic = [], Counter(wordDict)

        self.WordBreak(s, [], 0, n)
        return self.ans