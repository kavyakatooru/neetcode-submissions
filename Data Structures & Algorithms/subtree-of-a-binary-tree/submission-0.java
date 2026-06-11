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
    public boolean isSubtree(TreeNode root, TreeNode subRoot) {
        return help(root, subRoot);
        
    }

    public boolean help(TreeNode root, TreeNode subRoot) {
        if (root == null) return false;
        if (checkSubtree(root, subRoot)) return true;
        return help(root.left, subRoot) || help(root.right, subRoot);

    }

    public boolean checkSubtree(TreeNode root, TreeNode subRoot) {
        if (root == null && subRoot == null) return true;
        if (root == null || subRoot == null) return false;
        if (root.val != subRoot.val) {
            return false;
        } 

        return checkSubtree(root.left, subRoot.left) && checkSubtree(root.right, subRoot.right);
    }
}
