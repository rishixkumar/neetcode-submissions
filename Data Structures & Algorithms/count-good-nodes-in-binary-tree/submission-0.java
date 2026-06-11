/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */

class Solution {
    public int goodNodes(TreeNode root) {
        return dfs(root, root.val);
    }

    private int dfs(TreeNode node, int maxCount) {
        if (node == null) return 0;

        int result = (node.val >= maxCount) ? 1 : 0;
        maxCount = Math.max(maxCount, node.val);
        result = result + dfs(node.left, maxCount) + dfs(node.right, maxCount);

        return result;
    }
}
