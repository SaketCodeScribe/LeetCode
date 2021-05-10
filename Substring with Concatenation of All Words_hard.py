from collections import Counter

class Solution:
    def findSubstring(self, s: str, words: List[str]) -> List[int]:
        n, m, num = len(s), len(words), len(words[0])
        wordmap = Counter(words)
        ans = []

        for i in range(n - m * num + 1):
            hashmap = {}
            j = 0
            while j < m:
                key = s[i + j * num: i + j * num + num]
                if key in wordmap:
                    hashmap[key] = hashmap[key] + 1 if key in hashmap else 1
                    if hashmap[key] > wordmap[key]:
                        break
                else:
                    break
                j = j + 1
            if j >= m:
                ans.append(i)
        return ans