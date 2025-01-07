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
    private int ans = Integer.MIN_VALUE;
    public int maxPathSum(TreeNode root) {
        dfs(root);
        return ans;
    }
    private int dfs(TreeNode node){
        if(node == null) return 0;
        int leftNode = Math.max(0,dfs(node.left));
        int rightNode = Math.max(0, dfs(node.right));
        ans = Math.max(ans, node.val + leftNode + rightNode);
        return node.val + Math.max(leftNode, rightNode);
    }
}