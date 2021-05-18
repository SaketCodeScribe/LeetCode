'''
    1. Using Sliding Window Technique
       Time Complexity = O(n * word_length)
'''
class Solution:
    def fullJustify(self, words: List[str], maxWidth: int) -> List[str]:
        n, start, end = len(words), 0, 0
        ans = []

        while start < n:
            aux = []
            l = 0
            while start < n and l + len(words[start]) + 1 <= maxWidth + 1:
                l = l + len(words[start]) + 1
                start = start + 1
            m = start - end - 1
            l = l - m - 1
            if m > 0:
                q, r = (maxWidth - l) // m, (maxWidth - l) % m
            else:
                q, r = (maxWidth - l), 0
            while end < start:
                if start < n:
                    for ch in words[end]:
                        aux.append(ch)
                    if end < start - 1 or m == 0:
                        aux.append(' ' * q)
                    if r > 0:
                        aux.append(' ')
                    r = r - 1
                else:
                    maxWidth = maxWidth - len(words[end]) - 1
                    if end < start - 1:
                        aux.append(words[end])
                        aux.append(' ')
                    else:
                        aux.append(words[end])
                        aux.append(' ' * (maxWidth + 1))
                end = end + 1
            ans.append("".join(aux))
        return ans


''' 
    2. Shorter Code but higher time complexity 
       Time Complexity = O(n * maxWidth) 
'''


class Solution:
    def fullJustify(self, words: List[str], maxWidth: int) -> List[str]:
        ans, curr, l = [], [], 0

        for w in words:
            if len(curr) + len(w) + l > maxWidth:
                for i in range(maxWidth - l):
                    curr[i % (len(curr) - 1 or 1)] += ' '
                ans.append("".join(curr))
                curr, l = [], 0
            l = l + len(w)
            curr.append(w)
        curr = " ".join(curr)
        curr = curr + ' ' * (maxWidth - len(curr))
        ans.append("".join(curr))
        return ans