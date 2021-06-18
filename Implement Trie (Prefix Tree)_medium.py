'''
    Time Complexity: O(n*l)
    Space Complexity: O(26*26)
'''
class TrieNode:
    def __init__(self):
        self.mp = Counter()
        self.val = False

class Trie:
    def __init__(self):
        self.root = TrieNode()

    def insert(self, word: str) -> None:
        curr = self.root
        for char in word:
            if curr.mp[char] == 0:
                curr.mp[char] = TrieNode()
            curr = curr.mp[char]
        curr.val = True

    def search(self, word: str) -> bool:
        curr = self.root
        for char in word:
            if curr.mp[char] == 0:
                return False
            curr = curr.mp[char]
        return curr.val

    def startsWith(self, prefix: str) -> bool:
        curr = self.root
        for char in prefix:
            if curr.mp[char] == 0:
                return False
            curr = curr.mp[char]
        return True