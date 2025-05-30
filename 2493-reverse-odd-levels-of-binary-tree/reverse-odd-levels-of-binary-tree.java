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
    public void reverse(TreeNode root1,TreeNode root2,int level){
        if(root1 == null)
            return;

        if(level % 2 == 1){
            int temp = root2.val;
            root2.val = root1.val;
            root1.val = temp;
        }
        reverse(root1.left,root2.right,level+1);
        reverse(root1.right,root2.left,level+1);
    }
    public TreeNode reverseOddLevels(TreeNode root) {
        reverse(root.left, root.right, 1);
        return root;
    }
}