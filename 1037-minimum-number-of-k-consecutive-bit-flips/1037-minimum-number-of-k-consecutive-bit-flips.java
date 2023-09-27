class Solution {
    public int minKBitFlips(int[] nums, int k) {
        int i, n = nums.length, flipped = 0, ans = 0;
        int[] isFlip = new int[n];
        
        // flipped stores the effect of flip due to [i-k+1, i]
        for(i=0; i<n; i++){
            if (i >= k)
                flipped ^= isFlip[i-k];
            if (flipped == nums[i]){
                if (i+k > n)
                    return -1;
                isFlip[i] = 1;
                flipped ^= 1;
                ans++;
            }
        }
        return ans;
    }
}