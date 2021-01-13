class Solution {
public:
    int rob(vector<int>& nums) {
        int inc, exc, temp;
        inc=exc=0;
        for(int i=0; i<nums.size(); i++){
            temp=inc;
            inc=max(inc, exc+nums[i]);
            exc=temp;
        }
        return inc;
    }
};