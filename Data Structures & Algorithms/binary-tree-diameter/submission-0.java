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
    int max;
    Map<Integer, Integer> maxHeight;
    public int diameterOfBinaryTree(TreeNode root) {
        max = Integer.MIN_VALUE;
        maxHeight = new HashMap<>();
        calc(root);
        return max;
    }

    public void calc(TreeNode node) {
        if (node == null) return;
        if (maxHeight.containsKey(node.val)) return;
        int left = 0, right = 0;
        if (node.left != null) left = height(node.left.left, node.left.right, 1);
        if (node.right != null) right = height(node.right.left, node.right.right, 1);
        max = Math.max(left+right, max);
        maxHeight.put(node.val, max);
        calc(node.left);
        calc(node.right);
    }

    public int height(TreeNode l, TreeNode r, int sum) {
        if (l == null && r == null) return sum;
        int lSum = 0, rSum = 0;
        if (l != null) lSum = height(l.left, l.right, sum+1);
        if (r != null) rSum = height(r.left, r.right, sum+1); 
        return Math.max(lSum, rSum);
    } 
}
