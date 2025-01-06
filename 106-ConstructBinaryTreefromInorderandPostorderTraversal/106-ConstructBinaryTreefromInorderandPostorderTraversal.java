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
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        HashMap<Integer, Integer> map = new HashMap<>();
        for(int i=0; i<inorder.length; i++){
            map.put(inorder[i],i);
        }
        return buildTree(map, postorder, postorder.length-1, 0, inorder.length-1);
    }
    private TreeNode buildTree(HashMap<Integer, Integer> map, int[] postorder, int rootIndex, int left, int right){
        if(left>right){
            return null;
        }
        TreeNode root = new TreeNode(postorder[rootIndex]);
        int mid = map.get(postorder[rootIndex]);
        root.right = buildTree(map, postorder, rootIndex-1, mid+1, right);
        root.left = buildTree(map, postorder, rootIndex - (right - mid) - 1, left, mid-1);
        return root;
    }
}