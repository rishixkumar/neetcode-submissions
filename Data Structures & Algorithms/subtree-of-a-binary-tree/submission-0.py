# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right

class Solution:   
    def isSubtree(self, root: Optional[TreeNode], subRoot: Optional[TreeNode]) -> bool:
        srl_root = self.serialize(root)
        srl_subRoot = self.serialize(subRoot)
        combination = srl_subRoot + "|" + srl_root

        z = self.z_function(combination)
        sub_length = len(srl_subRoot)

        for i in range(sub_length + 1, len(combination)):
            if z[i] == sub_length:
                return True
        return False


    def serialize(self, root: Optional[TreeNode]) -> str:
        if root == None:
            return "$#";
        
        return ("$" + str(root.val) + self.serialize(root.left) + self.serialize(root.right));

    def z_function(self, s: str) -> list:
        z = [0] * len(s)
        l, r, n = 0, 0, len(s)

        for i in range(1, n):
            if i <= r:
                z[i] = min(r - i + 1, z[i-l])
            while i + z[i] < n and s[z[i]] == s[i+ z[i]]:
                z[i] += 1
            if i + z[i] - 1 > r:
                l, r = i, i + z[i] - 1
        return z


