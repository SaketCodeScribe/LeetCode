'''
	Time Complexity: O(n* 4^n)
	Space Complexity: O(n)
'''
class Solution:
    def Accumulate(self, list, n):
        j, flag = 0, 0
        stacknum, stackopp = [], []
        while j < n:
            if list[j] == '':
                if stacknum[-1] > 0:
                    val = stacknum.pop()*10+list[j+1]
                    stacknum.append(val)
                    j += 1
                else:
                    return -9999999
            elif list[j] != '+' and list[j] != '-' and list[j] != '*':
                stacknum.append(list[j])
            else:
                if flag:
                    stacknum.append(stacknum.pop()*stacknum.pop())
                    flag = 0
                if list[j] == '*':
                    flag = 1
                else:
                    stackopp.append(list[j])
            j += 1
        if flag:
            stacknum.append(stacknum.pop()*stacknum.pop())
        sign, val, i = 1, stacknum[0], 1
        for e in stackopp:
            if e == '-':
                sign = -1
            else:
                sign = 1
            val += sign*stacknum[i]
            i += 1
        return val

    def Solve(self, list, target, i, n, ans):
        if i == n:
            if self.Accumulate(list, n) == target:
                ans.append(''.join(map(str,list)))
            return None
        for op in ['','+','-','*']:
            list[i] = op
            self.Solve(list, target, i+2, n, ans)
        return None

    def addOperators(self, num: str, target: int) -> List[str]:
        if len(num) == 1 and int(num) == target:
            return num
        list, ans = [], []

        for e in num:
            list.append(int(e))
            list.append('')
        list.pop()
        self.Solve(list, target, 1, len(list), ans)
        return ans