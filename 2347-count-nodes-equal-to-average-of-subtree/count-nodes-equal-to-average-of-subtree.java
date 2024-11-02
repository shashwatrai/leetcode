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
    public int[] solve(TreeNode root){
        if(root == null)
            return new int[0];
        
        int []left  = solve(root.left);
        int []right = solve(root.right);

        int []ans = new int[3];

        ans[0] = root.val + (left.length > 0 ? left[0] : 0) + (right.length > 0? right[0]: 0);
        ans[1] = 1 + (left.length > 0 ? left[1] : 0) + (right.length > 0? right[1]: 0);
        if(root.val == ans[0]/ans[1])
            ans[2] = 1;
        ans[2] += (left.length > 0 ? left[2] : 0) + (right.length > 0? right[2]: 0);
        return ans;
    }
    public int averageOfSubtree(TreeNode root) {
        int []ans = solve(root);
        if(ans.length == 0)
            return 0;
        return ans[2];
    }
}