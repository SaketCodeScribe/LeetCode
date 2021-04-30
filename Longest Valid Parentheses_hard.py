class Solution:
    def longestValidParentheses(self, s: str) -> int:
        ans = 0
        n = len(s)
        de = deque()

        for i in range(n):
            if s[i] != ')':
                de.append(i)
            else:
                if (len(de) == 0):
                    de.append(i)
                    continue
                if s[de[len(de) - 1]] == '(' and s[i] == ')':
                    de.pop()
                    ans = max(ans, i - de[len(de) - 1]) if len(de) != 0 else max(ans, i + 1)
                else:
                    de.append(i)

        return ans