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
    public int ans(TreeNode root , int val){
        if(root == null)
            return 0;
        
        int left = ans(root.left, Math.max(root.val,val));
        int right = ans(root.right, Math.max(root.val,val));
        return left + right + (root.val >= val ? 1: 0);
    }
    public int goodNodes(TreeNode root) {
        return ans(root, Integer.MIN_VALUE);
    }
}