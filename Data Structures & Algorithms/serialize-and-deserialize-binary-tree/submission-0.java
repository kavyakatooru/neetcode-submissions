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

public class Codec {

    List<String> preOrderString;
    int idx;

    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        preOrderString = new ArrayList<>();
        preOrder(root);
        return String.join(",", preOrderString);

        
    }

    private void preOrder(TreeNode root) {
        if (root == null) {
            preOrderString.add("N");
            return;
        }
        preOrderString.add(String.valueOf(root.val));
        preOrder(root.left);
        preOrder(root.right);
    }


    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        idx = 0;
        String[] preOrder = data.split(",");
        return dfs(preOrder);
        
    }

    private TreeNode dfs(String[] preOrder) {
        if (preOrder[idx].equals("N")) {
            idx++;
            return null;
        }
        TreeNode node = new TreeNode(Integer.parseInt(preOrder[idx]));
        idx++;
        node.left = dfs(preOrder);
        node.right = dfs(preOrder);
        return node;
    }
}
