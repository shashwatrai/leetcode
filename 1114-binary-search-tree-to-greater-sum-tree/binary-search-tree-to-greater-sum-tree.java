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
    public int helper(TreeNode root,int add){
        if(root == null)
            return add;
        
        int sum = helper(root.right,add);
        root.val +=sum;
      
        return helper(root.left,root.val);

    }
    public TreeNode bstToGst(TreeNode root) {

        helper(root,0);
        return root;

    }
}