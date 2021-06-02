/**
 	* Time Complexity: O(n)
 	* Space Complexity: O(n)
 */
/**
 * @param {number[]} nums
 * @return {number[]}
 */
var runningSum = function(nums) {
    ans = []
    for (let i in nums){
        if (i == 0){
            ans.push(nums[i])
            continue
        }
        ans.push(nums[i] + ans[i - 1])
    }
    return ans
};