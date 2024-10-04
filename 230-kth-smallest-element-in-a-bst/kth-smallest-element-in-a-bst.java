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
    public int helper(TreeNode root,int []k){
        if(root == null){
            return -1;
        }
        int left = helper(root.left,k);
        if(left >= 0)
            return left;
        k[0]--;
        if(k[0] == 0)
            return root.val;
        int right = helper(root.right,k);
        return right;
    }
    public int kthSmallest(TreeNode root, int k) {
        if(root == null){
            return -1;
        }
        int ele[] = new int[1];
        ele[0] = k;
        return helper(root,ele);
    }
}