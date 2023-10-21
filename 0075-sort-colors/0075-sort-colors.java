class Solution {
    public void sortColors(int[] nums) {
        int low, mid, high = nums.length-1;
        low = mid = 0;

        while (mid <= high){
            if (nums[mid] == 1)
                mid++;
            else if (nums[mid] == 0){
                int temp = nums[low];
                nums[low++] = 0;
                nums[mid++] = temp;
            }
            else{
                nums[mid] = nums[high];
                nums[high--] = 2;
            }
        }
    }
}