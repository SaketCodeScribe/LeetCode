class Solution {
    public int maxProduct(int[] nums) {
        int temp, prd1 = 1, prd2 = 1, ans = Integer.MIN_VALUE;

        for(int num : nums){
            temp = Math.max(num, Math.max(prd1*num, prd2*num));
            prd2 = Math.min(num, Math.min(prd1*num, prd2*num));
            prd1 = temp;
            ans = Math.max(ans, prd1);
        }
        return ans;
    }
}