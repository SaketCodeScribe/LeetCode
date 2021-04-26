class Solution {
public:
    int reverse(int x) {
        int sign, flag=0, ans=0;
        
        if (x == -2147483648)
            return 0;
        
        sign = x > 0 ? 1 : -1;
        x = abs(x);
        
        while(x){
            if(!(x % 10) && !flag){
                x /= 10;
                continue;
            }
            else{
                flag = 1;
                if (ans > INT_MAX / 10)
                    return 0;
                ans = ans * 10 + x%10;
                
                x /= 10;
            }
        }
        return sign * ans;
    }
};