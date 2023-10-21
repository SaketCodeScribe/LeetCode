class Solution {
    public int findPeakElement(int[] nums) {
        int low = 0, high = nums.length-1, mid;
        if (low == high)
            return low;

        while (low <= high){
            mid = low+(high-low)/2;
            if ((mid == 0 && nums[mid] > nums[mid+1]) || (mid == nums.length-1 && nums[mid] > nums[mid-1]) || (nums[mid] > nums[mid+1] && nums[mid] > nums[mid-1]))
                return mid;
            if (mid > 0 && nums[mid-1] > nums[mid])
                high = mid-1;
            else
                low = mid+1;
        }
        return low;
    }
}