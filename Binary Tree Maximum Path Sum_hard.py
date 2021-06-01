'''
    Time Complexity: O(n)
    Space Complexity: O(n)
'''
class Solution:
    def __init__(self, ans=-999999):
        self.ans = ans

    def MaxPathSum(self, root: TreeNode) -> int:
        if root == None:
            return 0
        left_sum, right_sum = self.MaxPathSum(root.left), self.MaxPathSum(root.right)
        var1, var2 = (left_sum if left_sum >= 0 else 0) + (right_sum if right_sum >= 0 else 0), max(
            (left_sum if left_sum >= 0 else 0), (right_sum if right_sum >= 0 else 0))
        self.ans = max(self.ans, root.val + var1)
        return root.val + var2

    def maxPathSum(self, root: TreeNode) -> int:
        self.MaxPathSum(root)
        return self.ans