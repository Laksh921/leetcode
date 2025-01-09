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
    int pos = 0;
    public int kthSmallest(TreeNode root, int k) {
        TreeNode node = inOrder(root, k);
        if(node == null){
            return -1;
        }
        return node.val;
    }
    private TreeNode inOrder(TreeNode node, int k){
        if(node == null) return node;
        TreeNode left = inOrder(node.left, k);
        if(left != null){
            return left;
        }
        pos++;
        if(pos == k){
            return node;
        }
        return inOrder(node.right, k);
    }
}