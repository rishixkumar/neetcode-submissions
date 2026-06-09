# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right

class Solution:
    def isSameTree(self, p: Optional[TreeNode], q: Optional[TreeNode]) -> bool:
        if (not p and not q):
            return True
        return self.preOrderHelper(p, q)

    def preOrderHelper(self, x: Optional[TreeNode], y: Optional[TreeNode]) -> bool:
        if (not x and not y):
            return True
        if (not x or not y):
            return False

        if (x.val != y.val):
            return False

        return self.preOrderHelper(x.left, y.left) and self.preOrderHelper(x.right, y.right)