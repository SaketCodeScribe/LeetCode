'''
    Time Complexity: O(n ^ m) - for our constraint n = 10 & m = 4 which results in O(10 ^ 4)
    Space Complexity: O(L) - L is length of deadend
'''
class Solution:
    def openLock(self, deadends: List[str], target: str) -> int:
        mp, queue, vis, ans = Counter(deadends), deque(), Counter(), 0

        if mp['0000'] > 0:
            return -1
        queue.append(['0', '0', '0', '0'])
        vis['0000'], len_q = 1, 1
        while len_q:
            ans += 1
            while len_q:
                var = queue.popleft()
                digit = ''.join(var)
                if digit == target:
                    return ans - 1
                for i in range(4):
                    ch = var[i]
                    forw, rev = int(ch) + 1 if int(ch) + 1 < 10 else 9 - int(ch), int(ch) - 1 if int(
                        ch) - 1 >= 0 else 9 + int(ch)
                    for direction in [forw, rev]:
                        var[i] = str(direction)
                        digit = ''.join(var)
                        if mp[digit] == 0 and vis[digit] == 0:
                            queue.append([d for d in digit])
                            vis[digit] = 1
                    var[i] = ch
                len_q -= 1
            len_q = len(queue)
        return -1