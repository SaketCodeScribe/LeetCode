'''
    1. Time Complexity: O(beginWord.length*26*n)
       Space Complexity: O(n)
'''
class Solution:
    def ladderLength(self, beginWord: str, endWord: str, wordList: List[str]) -> int:
        if endWord in wordList == False:
            return 0
        n, ans = len(wordList), 0
        mp, chars, queue = Counter(wordList), list(string.ascii_lowercase), deque()

        queue.append(beginWord)
        l_q = len(queue)
        while l_q:
            ans += 1
            while l_q:
                word = queue.popleft()
                if word == endWord:
                    return ans
                n, word = len(word), [ch for ch in word]
                for i in range(n):
                    ch = word[i]
                    for k in chars:
                        word[i] = k
                        aux = ''.join(word)
                        if mp[aux] > 0:
                            queue.append(aux)
                            del mp[aux]
                    word[i] = ch
                l_q -= 1
            l_q = len(queue)
        return 0

'''
    2. Time Complexity: O(beginWord.length*n^2)
       Space Complexity: O(n)
'''
class Solution:
    def diff(self, str1: str, str2: str) -> bool:
        cnt = 0

        for i, j in zip(str1, str2):
            if i != j:
                cnt += 1
        return True if cnt == 1 else False

    def ladderLength(self, beginWord: str, endWord: str, wordList: List[str]) -> int:
        if endWord in wordList == False:
            return 0
        n, ans, l = len(wordList), 999999, 1
        vis, queue = [False for i in range(n)], deque()

        queue.append(beginWord)
        l_q = len(queue)
        while l_q > 0:
            l += 1
            while l_q > 0:
                ind = queue.popleft()
                word = wordList[ind] if ind != beginWord else ind
                for i in range(n):
                    if wordList[i] == endWord and self.diff(wordList[i], word):
                        return l
                    elif vis[i] == False and self.diff(wordList[i], word):
                        queue.append(i)
                        vis[i] = True
                l_q -= 1
            l_q = len(queue)
        return 0