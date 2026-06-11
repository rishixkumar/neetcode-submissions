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
    public int kthSmallest(TreeNode root, int k) {

        PriorityQueue<Integer> maxHeap = new PriorityQueue<>(Collections.reverseOrder());

        dfs(root, k, maxHeap);
        return maxHeap.peek();
    }

    private void dfs(TreeNode node, int k, PriorityQueue<Integer> heap) {
        if (node == null) return;

        heap.offer(node.val);

        if (heap.size() > k) heap.poll();
        dfs(node.left, k, heap);
        dfs(node.right, k, heap);
    }
}
