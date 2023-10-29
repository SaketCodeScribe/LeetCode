class Solution
{
    public int[] twoOddNum(int arr[], int N){
        int i;
        int xor, x, y, rbit;
        xor = x = y = 0;
        
        for(int val:arr)
            xor ^= val;
        rbit = xor & (-xor);
        for(int val:arr){
            if ((val & rbit) > 0)
                x ^= val;
            else
                y ^= val;
        }
        return new int[]{Math.max(x,y), Math.min(x,y)};
    }
}