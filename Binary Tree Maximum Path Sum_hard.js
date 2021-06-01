var ans
function MaxPathSum(root){
    if (root == null)
        return 0
    let left_sum, right_sum, var1, var2
    left_sum = MaxPathSum(root.left)
    right_sum = MaxPathSum(root.right)
    var1 = (left_sum >= 0 ? left_sum : 0) + (right_sum >= 0 ? right_sum : 0)
    var2 = Math.max(left_sum >= 0 ? left_sum : 0, right_sum >= 0 ? right_sum : 0)
    ans = Math.max(ans, root.val + var1)
    return root.val + var2
}
var maxPathSum = function(root) {
    ans = -999999
    MaxPathSum(root)
    return ans
}