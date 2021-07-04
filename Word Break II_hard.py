'''
    Time Complexity: O(n*2^n)
    Space Complexity: O(n*2^n)
'''
class Solution:
    def __init__(self, ) -> None:
        self.ans = None
        self.dic = None

    def WordBreak(self, s, temp, i, n):
        m, s1 = 0, []
        if i >= n:
            self.ans.append(''.join(temp[:-1]))
            return None
        while i < n:
            s1.append(s[i])
            m += 1
            if m <= 10 and self.dic[''.join(s1)] > 0:
                for j in range(m):
                    temp.append(s1[j])
                temp.append(' ')
                self.WordBreak(s, temp, i + 1, n)
                for j in range(m + 1):
                    temp.pop()
            elif m > 10:
                return None
            i += 1
        return None

    def wordBreak(self, s: str, wordDict: List[str]) -> List[str]:
        n, s = len(s), [char for char in s]
        self.ans, self.dic = [], Counter(wordDict)

        self.WordBreak(s, [], 0, n)
        return self.ans