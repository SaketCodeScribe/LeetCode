'''
    1. Time Complexity: O(n)
       Space Complexity: O(n)
'''
class Solution:
    def calculate(self, s: str) -> int:
        stack = []

        for ele in s:
            if ele != ' ' and ele != ')':
                if len(stack) > 0 and stack[-1] != '(' and stack[-1] != '+' and stack[
                    -1] != '-' and ele != '+' and ele != '-':
                    prev = int(stack.pop())
                    stack.append(str(int(ele) + 10 * prev))
                else:
                    stack.append(ele)
            elif ele == ')':
                n, val = len(stack), 0
                while (n > 0 and stack[-1] != '('):
                    if stack[-1] != '+' and stack[-1] != '-':
                        val += int(stack[-1])
                    elif stack[-1] == '-':
                        val -= int(prev) * 2
                    n -= 1
                    prev = stack[-1]
                    stack.pop()
                stack.pop()
                stack.append(str(val))
        n, val = len(stack), 0
        while n > 0:
            if stack[-1] != '+' and stack[-1] != '-':
                val += int(stack[-1])
            elif stack[-1] == '-':
                val -= int(prev) * 2
            n -= 1
            prev = stack[-1]
            stack.pop()
        return val

'''
    2. Time Complexity: O(n)
       Space Complexity: O(n)
'''
class Solution:
    def calculate(self, s: str) -> int:
        ans, num, sign = 0, 0, 1
        stack = []

        for ele in s:
            if ele.isdigit():
                num = num * 10 + int(ele)
            elif ele == '+':
                ans += sign * num
                num = 0
                sign = 1
            elif ele == '-':
                ans += sign * num
                num = 0
                sign = -1
            elif ele == '(':
                stack.append(ans)
                stack.append(sign)
                ans = 0
                sign = 1
            elif ele == ')':
                ans += sign * num
                ans = stack.pop() * ans
                ans += stack.pop()
                num = 0
                sign = 1

        return ans + sign * num
