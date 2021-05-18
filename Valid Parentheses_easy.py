'''
    Time: O(n)
    Space: O(n)
'''
class Solution:
    def isValid(self, s: str) -> bool:
        de = deque()

        for ch in s:
            if ch != '}' and ch != ']' and ch != ')':
                de.append(ch)
            else:
                if len(de) == 0 or (ch == '}' and de[len(de) - 1] != '{') or (ch == ']' and de[len(de) - 1] != '[') or (
                        ch == ')' and de[len(de) - 1] != '('):
                    return False;
                de.pop()

        return True if len(de) == 0 else False