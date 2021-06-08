'''
    1. Time Complexity: O(n ^ 2)
       Space Complexity: O(n)
'''
class Solution:
    def buildTree(self, preorder: List[int], inorder: List[int]) -> TreeNode:
        if len(preorder) == 0 or len(inorder) == 0:
            return None
        root = TreeNode()
        root.val = preorder[0]
        for ind, val in enumerate(inorder):
            if preorder[0] == val:
                break
        root.left = self.buildTree(preorder[1:ind + 1], inorder[:ind])
        root.right = self.buildTree(preorder[ind + 1:], inorder[ind + 1:])
        return root


'''
    2. Time Complexity: O(n)
       Space Complexity: O(n)
'''
class Solution:
    def __init__(self, mp=None):
        self.mp = mp

    def BuildTree(self, preorder: List[int], inorder: List[int], sp: int, si: int, ep: int, ei: int) -> TreeNode:
        if sp > ep or si > ei == 0:
            return None
        root = TreeNode()
        root.val, ind = preorder[sp], self.mp[preorder[sp]] - si
        root.left = self.BuildTree(preorder, inorder, sp + 1, si, sp + ind, si + ind - 1)
        root.right = self.BuildTree(preorder, inorder, sp + ind + 1, si + ind + 1, ep, ei)
        return root

    def buildTree(self, preorder: List[int], inorder: List[int]) -> TreeNode:
        n = len(preorder)
        self.mp = Counter()

        for ind, val in enumerate(inorder):
            self.mp[val] = ind
        return self.BuildTree(preorder, inorder, 0, 0, n - 1, n - 1)