'''
	Time Complexity : O(log n)
	Space Complexity: Constant
'''
class Solution:
    def numberToWords(self, num: int) -> str:
        if num == 0:
            return 'Zero'
        prev, p, ans, temp = 0, 1, '', ''
        list, dict = [], {1: 'One', 2: 'Two', 3: 'Three', 4: 'Four',
                          5: 'Five', 6: 'Six', 7: 'Seven', 8: 'Eight', 9: 'Nine',
                          }
        Tdict = {1: 'Ten', 2: 'Twenty', 3: 'Thirty', 4: 'Forty',
                 5: 'Fifty', 6: 'Sixty', 7: 'Seventy', 8: 'Eighty', 9: 'Ninety',
                 11: 'Eleven', 12: 'Twelve', 13: 'Thirteen', 14: 'Fourteen',
                 15: 'Fifteen', 16: 'Sixteen', 17: 'Seventeen', 18: 'Eighteen',
                 19: 'Nineteen'
                 }
        while num:
            if num % 10:
                if p == 1:
                    list.append(dict[num % 10])
                elif p == 2:
                    if (num % 10) * 10 + prev in Tdict:
                        list.pop()
                        list.append(Tdict[(num % 10) * 10 + prev])
                    else:
                        list.append(Tdict[num % 10])
                    temp = ''
                elif p == 3:
                    list.append('Hundred')
                    list.append(dict[num % 10])
                    temp = ''
                elif p == 4:
                    list.append('Thousand')
                    list.append(dict[num % 10])
                    temp = ''
                elif p == 5:
                    if temp != '':
                        list.append(temp)
                        temp = ''
                    if (num % 10) * 10 + prev in Tdict:
                        list.pop()
                        list.append(Tdict[(num % 10) * 10 + prev])
                    else:
                        list.append(Tdict[num % 10])
                elif p == 6:
                    if temp == 'Thousand':
                        list.append(temp)
                        temp = ''
                    list.append('Hundred')
                    list.append(dict[num % 10])
                elif p == 7:
                    list.append('Million')
                    list.append(dict[num % 10])
                    temp = ''
                elif p == 8:
                    if temp != '':
                        list.append(temp)
                        temp = ''
                    if (num % 10) * 10 + prev in Tdict:
                        list.pop()
                        list.append(Tdict[(num % 10) * 10 + prev])
                    else:
                        list.append(Tdict[num % 10])
                elif p == 9:
                    if temp == 'Million':
                        list.append(temp)
                        temp = ''
                    list.append('Hundred')
                    list.append(dict[num % 10])
                else:
                    list.append('Billion')
                    list.append(dict[num % 10])
            else:
                if p % 3 == 0 and p != 3:
                    temp = 'Hundred'
                elif p == 4:
                    temp = 'Thousand'
                elif p == 7:
                    temp = 'Million'
            prev = num % 10
            num //= 10
            p += 1

        ans = list[0]
        for word in list[1:]:
            ans = word + ' ' + ans
        return ans