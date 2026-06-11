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
    int count;
    public int goodNodes(TreeNode root) {
        count = 0;
        countGoodNodes(root,Integer.MIN_VALUE);
        return count;
    }
    public void countGoodNodes(TreeNode node, int max) {
        if (node == null) return;
        if (max <= node.val){
            max = node.val;
            count++;
        } 
        countGoodNodes(node.left,max);
        countGoodNodes(node.right,max);
    }
}
