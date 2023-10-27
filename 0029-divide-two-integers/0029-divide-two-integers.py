class Solution:
    def divide(self, dividend: int, divisor: int) -> int:
        if dividend <= -2**31 and divisor == -1:
            return 2**31-1
           
        cnt, sign = 1, -1 if (divisor > 0 and dividend < 0) or (divisor < 0 and dividend > 0) else 1
        dividend, divisor = abs(dividend), abs(divisor)
        tmp = divisor
        if divisor == 1:
            return sign*dividend
        ans = 0
        while dividend >= 0:
            if dividend >= divisor:
                divisor <<= 1
                cnt <<= 1
            else:
                ans += cnt>>1
                dividend, divisor, cnt = dividend-(divisor>>1), tmp, 1            
        return ans*sign         