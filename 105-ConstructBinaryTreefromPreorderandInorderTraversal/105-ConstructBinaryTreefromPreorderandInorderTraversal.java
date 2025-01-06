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
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        HashMap<Integer, Integer> inorderIndexMap = new HashMap<>();
        for(int i=0; i<inorder.length; i++){
            inorderIndexMap.put(inorder[i],i);
        }
        return buildTreePreorder(preorder, inorderIndexMap, 0, 0, inorder.length-1);
        }
    private TreeNode buildTreePreorder(int preorder[], HashMap<Integer, Integer> inorderIndexMap, int rootIndex, int left, int right){
        if (left > right) {
            return null;
        }
        TreeNode root = new TreeNode(preorder[rootIndex]);
        int mid = inorderIndexMap.get(preorder[rootIndex]);
        root.left = buildTreePreorder(preorder, inorderIndexMap, rootIndex+1, left, mid-1);
        root.right= buildTreePreorder(preorder, inorderIndexMap, rootIndex + (mid - left + 1), mid+1, right);
        return root;
    }
}