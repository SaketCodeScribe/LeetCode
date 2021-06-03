'''
    Time Complexity: O(beginWord.length*26*n)
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