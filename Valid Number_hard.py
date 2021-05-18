'''
    Time: O(n)
    Space: O(1)
'''
class Solution:
    def isDecimal(self, s: str) -> bool:
        n = len(s)
        if s.find('.') == -1 or n == 0:
            return False
        if n == 1:
            return False
        cnt = 0
        for ch in s:
            if ch == '.':
                cnt = cnt + 1
            if cnt > 1:
                return False
        if s.find('+') != -1 or s.find('-') != -1:
            if (s[0] != '+' and s[0] != '-') or n == 2:
                return False
            cnt = 0
            for ch in s:
                if ch == '+' or ch == '-':
                    cnt = cnt + 1
                if cnt > 1:
                    return False
        for ch in s:
            if ch == '.' or ch == '+' or ch == '-':
                continue
            try:
                int(ch)
            except:
                return False
        return True

    def isInteger(self, s: str):
        n = len(s)
        if n == 0:
            return False
        if s.find('+') != -1 or s.find('-') != -1:
            if (s[0] != '+' and s[0] != '-') or n == 1:
                return False
            cnt = 0
            for ch in s:
                if ch == '+' or ch == '-':
                    cnt = cnt + 1
                if cnt > 1:
                    return False
        for ch in s:
            if ch == '+' or ch == '-':
                continue
            try:
                int(ch)
            except:
                return False
        return True

    def isNumber(self, s: str) -> bool:
        pos = s.find('e')
        pos = s.find('E') if pos == -1 else pos
        return ((self.isDecimal(s[:pos]) or self.isInteger(s[:pos])) and self.isInteger(
            s[pos + 1:])) if pos != -1 else (self.isDecimal(s) or self.isInteger(s))